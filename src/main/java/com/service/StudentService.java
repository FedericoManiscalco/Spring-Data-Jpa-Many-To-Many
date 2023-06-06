package com.service;

import java.util.List;

import com.entity.Student;

public interface StudentService {
	public void save(Student student);

	public List<Student> findAll();

	public void deleteById(Integer studentId);

}
