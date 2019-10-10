package com.example.CourseEnrollment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseEnrollment.Model.CourseModel;
import com.example.CourseEnrollment.Service.CourseService;

@RestController
@RequestMapping("/course")
public class Course {

	@Autowired
	private CourseService courseService;

	@GetMapping
	public @ResponseBody List<CourseModel> getCourseDetails() {
		List<CourseModel> courseList = courseService.getAllCourse();
		return courseList;
	}

	@GetMapping("/GetCourseBasedOnFeeFilter")
	public @ResponseBody List<CourseModel> getCourseDetailsBasedOnFeeFilter() {
		List<CourseModel> courseList = courseService.getCoursebasedOnFeeFilter();
		return courseList;
	}

	@PostMapping("/PostCourseDataFunctioalInterface")
	public String addCourseData(CourseModel courseModel) {
		String success = courseService.postCourseData(courseModel);
		return success;
	}

	@GetMapping("/GetUpdatedIDByStream.map()")
	public @ResponseBody List<CourseModel> getIdOnly() {
		List<CourseModel> courseList = courseService.getAllCourseId();
		return courseList;
	}

	@GetMapping("/getIdByStream.FilterAndStream.Map")
	public @ResponseBody List<CourseModel> findById() {
		List<CourseModel> courseList = courseService.findById();
		return courseList;
	}

	@GetMapping("/getCountByID")
	public Long courseCount() {
		return courseService.countCourseById();
	}

	@GetMapping("/getSortedData")
	public List<CourseModel> getSortedData() {
		return courseService.sortedCourseDetails();
	}

}
