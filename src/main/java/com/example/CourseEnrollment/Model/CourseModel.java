package com.example.CourseEnrollment.Model;

public class CourseModel {
	
	String course_id;
	String course_name;
	String course_price;
	public CourseModel(){
		
	}

	public CourseModel(String course_id, String course_name, String course_price) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_price = course_price;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_price() {
		return course_price;
	}

	public void setCourse_price(String course_price) {
		this.course_price = course_price;
	}

}
