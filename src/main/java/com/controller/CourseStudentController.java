package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service.CourseService;
import com.service.StudentService;
import com.vo.CourseStudentVO;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
public class CourseStudentController {

	@Autowired
	private CourseService cs;

	@Autowired
	private StudentService ss;

	@GetMapping("api/v1/coursestudent")
	public List<CourseStudentVO> getCoursesReviews() {
		return cs.findCourseStudent();
	}

	@GetMapping("api/v1/coursestudent/{studentId}")
	public List<CourseStudentVO> findCourseStudentByStudentId(@PathVariable("studentId") Integer studentId) {
		return cs.findCourseStudentByStudentId(studentId);
	}
}
