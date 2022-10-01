package com.learn.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.demo.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	List<Student> studentList = new ArrayList<>();
	
	List<Integer> nums = new ArrayList<>();

	@GetMapping
	public String studentPage() {
		return "Student Page";
	}
	
	@PostMapping("/save")
	public String addStudent(@RequestBody Student student) {
		studentList.add(student);
		return "Student Save In DB";
	}
	
	@GetMapping("/{rollNo}")
	public Student getStudent(@PathVariable int rollNo) {
		
		for (int i = 0; i < studentList.size(); i++) {
			if(rollNo == studentList.get(i).getRollNo())
				return studentList.get(i);
			
		}
		
		
		Student s = studentList.stream()
				.filter(student  -> student.getRollNo() == rollNo)
				.findFirst().get();
	
		return s ;
	}
	
	@GetMapping("/list")
	public List<Student> getAllStudent() {
		
		return  studentList;
	}
}



// localhost:9090/student