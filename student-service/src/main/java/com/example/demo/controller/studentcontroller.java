package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;

@RestController
@RequestMapping("/students")
public class studentcontroller {

	StudentRepository studentRepository;

	public studentcontroller(StudentRepository studentRepository) {
		
		this.studentRepository = studentRepository;
	}
	
	@PostMapping
	public Student save(@RequestBody Student student)
	{
	return 	studentRepository.save(student);
	}
	
	@GetMapping
	public List<Student> findAll()
	{
		return studentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Student findById(@PathVariable("id") int id)
	{
		return studentRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable("id") int id,@RequestBody Student student)
	{
		Student student1=studentRepository.findById(id).orElse(null);
		if(student1!=null)
		{
		student1.setName(student.getName());
		student1.setMobile(student.getMobile());
		student1.setEmail(student.getEmail());
		Student updatedstudent= studentRepository.save(student1);
		
		
			return ResponseEntity.ok(updatedstudent);
		}
		
		else
		{
			return ResponseEntity.notFound().build();
		}
		
		
	}
      
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id, @RequestBody Student student)
	{
 	studentRepository.delete(student);
	}
}