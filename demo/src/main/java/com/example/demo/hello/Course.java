package com.example.demo.hello;

import java.util.*;

import javax.persistence.*;


@Entity
public class Course {
	@Id
	private String name;
	private int semester;
	
	@ManyToOne
	@JoinColumn(name="professor_name")
	private Professor lecturer; 
	
	public void setProfessor(Professor p) {
		lecturer = p;
		p.addCourse(this);
	}
	
	public Professor getProfessor() {return lecturer;}


	@ManyToMany(mappedBy="courses")
	private Set<Student> students = new HashSet<Student>();

	public Course() {}

	public Course(String n, int s) {
		name = n;
		semester =s;
	}

	public String getName() {return name;}
	public int getSemester() {return semester;}
}

