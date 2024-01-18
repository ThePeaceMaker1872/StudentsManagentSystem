package com.example.demo.hello;

import java.util.*;
import com.example.demo.hello.HelloService;

import org.apache.catalina.valves.CrawlerSessionManagerValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProfessorRepository profRepository;
	
	@Autowired
	private CourseRepository cRepository;

	
	public void addStudent(Student s) throws Exception {
		//Check first if exist already
		// in this way it could return HTTP 200 when it is able to save new entry
		// and 400, or 500 error with message when if fails
		Optional<Student> byId = studentRepository.findById(s.getName());
		if(!byId.isPresent())
			studentRepository.save(s);
	}

	public List<Student> getAllStudents() throws Exception {
		return studentRepository.findAll();
	}
	
	public Optional<Student> findStudentById(Student s) throws Exception{
		return studentRepository.findById(s.getName());
	}
	
	public void addProfessor(Professor p) throws Exception {
		Optional<Professor> byId = profRepository.findById(p.getName());
		if(!byId.isPresent())
			profRepository.save(p);
	}

	public void addCourse(Course course) {
		Optional<Course> byId = cRepository.findById(course.getName());
		
		if(!byId.isPresent())
			cRepository.save(course);
	}
	
	

}

