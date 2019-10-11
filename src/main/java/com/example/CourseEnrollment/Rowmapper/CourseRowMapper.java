package com.example.CourseEnrollment.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.CourseEnrollment.Model.CourseModel;

public class CourseRowMapper implements RowMapper<CourseModel> {

	@Override
	public CourseModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseModel courseModel = new CourseModel(null, null, null);
		courseModel.setCourse_id(rs.getString("ID"));
		courseModel.setCourse_name(rs.getString("COURSE_NAME"));
		courseModel.setCourse_price(rs.getString("COURSE_FEE"));
		return courseModel;
	}

}
