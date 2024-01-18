package com.example.demo.hello;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

// Since this is the controller, it is the place where we add our end-points
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelloController {

	@Autowired
	private HelloService hs;
	
	@GetMapping(path="/students")
	public List<Student> getAllStudent()  throws Exception{
		return hs.getAllStudents();
	} 
	
	@PostMapping(path="/addStudent")
	public void addStudent(@RequestBody Student st) throws Exception {
		hs.addStudent(st);
	}
	

	@GetMapping(path="/findStudentById")
	public Optional<Student> findStudentById(@RequestBody Student st) throws Exception {
		return hs.findStudentById(st);
	}
	
	@PostMapping(path = "/addCourse")
	public void addCourse(@RequestBody Course course) throws Exception {
		hs.addCourse(course);
	}
}
