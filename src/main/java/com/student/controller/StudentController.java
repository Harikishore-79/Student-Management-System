package com.student.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService serv;
	
	public StudentController(StudentService serv) {
		this.serv=serv;
	}
	
	
//	@GetMapping("/test")
//	public String test() {
//		return "Working!";
//	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student st) {
		return serv.saveStudent(st);
	}
	
	@PostMapping("/all")
	public List<Student>addAllStudents(@RequestBody List<Student>students){
		return serv.saveAllStudents(students);
	}
	
	@GetMapping
	public List<Student>getAllStudents(){
		return serv.getAllStudents();
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id,@RequestBody Student st) {
		return serv.updateStudent(id, st);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		serv.deleteStudent(id);
		return "Deleted Successfully!";
	}
		
	
}
