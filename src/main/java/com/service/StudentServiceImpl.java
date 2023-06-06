package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository sr;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void save(Student student) {
		try {
			sr.save(student);
			log.info("Save riuscito.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Save fallito.");
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> findAll() {
		List<Student> students = sr.findAll();
		if (students != null && !students.isEmpty()) {
			log.info("Studenti trovati.");
			students.forEach(System.out::println);
		} else {
			log.info("Studenti non trovati.");
		}
		return students;
	}

	@Override
	public void deleteById(Integer studentId) {
		if (sr.existsById(studentId)) {
			try {
				sr.deleteById(studentId);
				log.info("Studente eliminato.");
			} catch (IllegalArgumentException iae) {
				log.info("Studente non eliminato.");
				iae.printStackTrace();
			}
		} else {
			log.info("Studente non trovato.");
		}

	}

}
