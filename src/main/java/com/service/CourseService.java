package com.service;

import java.util.List;

import com.entity.Course;

public interface CourseService {

	public void save(Course course);

	public List<Course> findAll();

	public void deleteById(Integer courseId);

}
