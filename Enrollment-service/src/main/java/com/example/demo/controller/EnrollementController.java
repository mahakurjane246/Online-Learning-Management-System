package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.CourseClient;
import com.example.demo.client.StudentClient;
import com.example.demo.dao.EnrollementRepository;
import com.example.demo.model.Enrollement;

@RestController
@RequestMapping("/enrollements")
public class EnrollementController {
private final EnrollementRepository enrollementRepository;
private final StudentClient studentClient;
private final CourseClient courseClient;

public EnrollementController(EnrollementRepository enrollementRepository, StudentClient studentClient,
		CourseClient courseClient) {
	super();
	this.enrollementRepository = enrollementRepository;
	this.studentClient = studentClient;
	this.courseClient = courseClient;
}

@PostMapping
public ResponseEntity<Enrollement> save(@RequestParam("studentid")int studentid,@RequestParam("courseid")int courseid,@RequestBody Enrollement enrollement)
{
	if(courseClient.findById(courseid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	if(studentClient.findById(studentid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	Enrollement enroll=enrollement;
	enroll.setCourseid(courseid);
	enroll.setStudentid(studentid);
	enroll.setDate(LocalDate.now());
	Enrollement enroll1=enrollementRepository.save(enroll);
	return ResponseEntity.ok(enroll1);
}

@GetMapping("/{id}")
public Enrollement findById(@PathVariable("id")int id)
{
	return enrollementRepository.findById(id).orElse(null); 
}

@GetMapping
public List<Enrollement> findAll()
{
	return enrollementRepository.findAll();
}

@PutMapping("/{id}")
public ResponseEntity<Enrollement> update(@PathVariable("id") int id,@RequestBody Enrollement enrollement)
{
	Enrollement enrollement1=enrollementRepository.findById(id).orElse(null);
	if(enrollement1!=null)
	{ 
		enrollement1.setStatus(enrollement.getStatus());
		Enrollement enroll=enrollementRepository.save(enrollement1);
		return ResponseEntity.ok(enroll);
    }
	else
	{
		return ResponseEntity.notFound().build();
	}
}


@DeleteMapping("/{id}")
public int delete(@PathVariable("id")int id)
{
	enrollementRepository.deleteById(id);
	return 1;
}


}