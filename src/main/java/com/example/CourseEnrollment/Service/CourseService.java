package com.example.CourseEnrollment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseEnrollment.CourseDao.CourseData;
import com.example.CourseEnrollment.Model.CourseModel;

@Service
public class CourseService {
	@Autowired
	private CourseData courseData;

	public List<CourseModel> getAllCourse() {
		List<CourseModel> courseList = courseData.getCourseDetails();
		return courseList;
	}

	public List<CourseModel> getCoursebasedOnFeeFilter() {
		List<CourseModel> courseList = courseData.getCourseBasedOnFeeFilter();
		return courseList;
	}

	public String postCourseData(CourseModel courseModel) {
		String a = courseData.insert(courseModel);
		return a;
	}

	public List<CourseModel> getAllCourseId() {
		List<CourseModel> courseList = courseData.updateInId();
		return courseList;
	}

	public List<CourseModel> findById() {
		List<CourseModel> courseList = courseData.findById();
		return courseList;
	}

	public Long countCourseById() {
		return courseData.countCourseById();
	}

	public List<CourseModel> sortedCourseDetails() {
		return courseData.getSortCourseDetails();
	}
}
