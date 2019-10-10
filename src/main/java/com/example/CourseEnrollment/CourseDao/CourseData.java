package com.example.CourseEnrollment.CourseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import com.example.CourseEnrollment.Model.CourseModel;
import com.example.CourseEnrollment.Rowmapper.CourseRowMapper;

@Repository
public class CourseData implements interf {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// Working but old style!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	/*
	 * public List<CourseModel> getCourseDetails() { String sql =
	 * "select * from course"; List<CourseModel> customers =
	 * jdbcTemplate.query(sql, new CourseRowMapper()); return customers; }
	 */
	public List<CourseModel> getCourseDetails() {
		String sql = "select * from course";

		return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> new CourseModel(rs.getString("ID"),
				rs.getString("COURSE_NAME"), rs.getString("COURSE_FEE")));
	}

	// Getting the course result based on streams filter

	@SuppressWarnings("unchecked")
	public List<CourseModel> getCourseBasedOnFeeFilter() {
		// String sql = "select * from COURSE where COURSE_FEE <=2000";
		String sql = "select * from course";
		@SuppressWarnings("rawtypes")
		List<CourseModel> list = (List) jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> new CourseModel(rs.getString("ID"), rs.getString("COURSE_NAME"),
						rs.getString("COURSE_FEE")));
		String stringNumber = "3000";
		List<CourseModel> li = list.stream().filter(
				courseModel -> Integer.parseInt(courseModel.getCourse_price()) >= Integer.parseInt(stringNumber))
				.sorted().collect(Collectors.toList());
		return li;
	}

	@Override
	public String insert(CourseModel courseModel) {
	String sql = "INSERT INTO COURSE" + "(ID,COURSE_NAME,COURSE_FEE) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { courseModel.getCourse_id(), courseModel.getCourse_name(),
				courseModel.getCourse_price() });
		return "course details Added";
	}
	
	public List<CourseModel> updateInId(){
		String sql = "select * from course";
		List<CourseModel>list= jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> new CourseModel(rs.getString("ID"),
				rs.getString("COURSE_NAME"), rs.getString("COURSE_FEE")));

		List<CourseModel>getList=list.stream().map(e->{e.setCourse_id("3");
		return e;}).collect(Collectors.toList());
		return getList;
	}

	public List<CourseModel> findById() {
		String sql = "select * from course";
		List<CourseModel> list = jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> new CourseModel(rs.getString("ID"), rs.getString("COURSE_NAME"),
						rs.getString("COURSE_FEE")));
		List<CourseModel> getList = list.stream()
				.filter(e -> Integer.parseInt(e.getCourse_price()) >= Integer.parseInt("2000")).map(e -> {
					e.setCourse_id("11");
					return e;
				}).collect(Collectors.toList());
		return getList;
	}

	public Long countCourseById() {
		String sql = "select * from course";
		List<CourseModel> list = jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> new CourseModel(rs.getString("ID"), rs.getString("COURSE_NAME"),
						rs.getString("COURSE_FEE")));
		String no = "1";
		Long val = list.stream().filter(e -> Integer.parseInt(e.getCourse_id()) >= Integer.parseInt(no)).count();
		return val;
	}
	
	public List<CourseModel> getSortCourseDetails() {
		String sql = "select * from course";
		List<CourseModel> list = jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> new CourseModel(rs.getString("ID"), rs.getString("COURSE_NAME"),
						rs.getString("COURSE_FEE")));
		List<CourseModel> sortList = list.stream().sorted().collect(Collectors.toList());
		return sortList;
	}
	

}
