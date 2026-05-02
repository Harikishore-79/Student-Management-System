package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	

	private final StudentRepository sr;
	
	public StudentService(StudentRepository sr) {
		this.sr=sr;
	}
	
	public Student saveStudent(Student st) {
		return sr.save(st);
	}
	
	
	public List<Student>saveAllStudents(List<Student>students){
		return sr.saveAll(students);
	}
	public List<Student>getAllStudents(){
		return sr.findAll();
	}
	
	public Student updateStudent(Long id,Student newStudent) {
		Student s =sr.findById(id)
				.orElseThrow(() ->new RuntimeException("Not found!"));
		s.setName(newStudent.getName());
		s.setAge(newStudent.getAge());
		s.setEmail(newStudent.getEmail());
		s.setPercentage(newStudent.getPercentage());
		s.setBranch(newStudent.getBranch());
		
		return sr.save(s);
		
	}
	
	public void deleteStudent(Long id) {
		sr.deleteById(id);
	}
	
	
}

