package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Course;
import com.entity.Student;
import com.service.CourseService;
import com.service.StudentService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CourseService cs;

	@Autowired
	private StudentService ss;

	@Resource
	private Student s1;

	@Resource
	private Student s2;

	@Resource
	private Student s3;

	@Resource
	private Student s4;

	@Resource
	private Course c1;

	@Resource
	private Course c2;

	@Resource
	private Course c3;

	@Resource
	private Course c4;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s1.setFirstName("Roberto");
		s1.setLastName("Graffeo");

		c1.setTitle("Java 1");
		c1.setDescription("Corso Java 1");

		s1.getCourses().add(c1);

		cs.save(c1);
		ss.save(s1);

		cs.findAll();
		ss.findAll();
	}

}
