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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.AssignmentRepository;
import com.example.demo.Model.Assignment;
import com.example.demo.client.CourseClient;
import com.example.demo.client.InstructorClient;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
private final AssignmentRepository assignmentRepository;
private final CourseClient courseClient;
private final InstructorClient instructorClient;
public AssignmentController(AssignmentRepository assignmentRepository, CourseClient courseClient, InstructorClient instructorClient) {
	this.assignmentRepository = assignmentRepository;
	this.courseClient = courseClient;
	this.instructorClient = instructorClient;
}
 
@PostMapping
public ResponseEntity<Assignment> save(@RequestParam("courseid")int courseid,@RequestParam("instructorid")int instructorid,@RequestBody Assignment assignment)
{
	if(courseClient.findById(courseid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	if(instructorClient.findByID(instructorid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	Assignment assign1=assignment;
	assign1.setCourseid(courseid);
	assign1.setInstructorid(instructorid);
	Assignment assignment2= assignmentRepository.save(assign1);
	return ResponseEntity.ok(assignment2);
}

@GetMapping("/{id}")
public Assignment findById(@PathVariable("id")int id)
{
	return assignmentRepository.findById(id).orElse(null);
}

@GetMapping
public List<Assignment> findAll()
{
	return assignmentRepository.findAll();
}

@PutMapping("/{id}")
public ResponseEntity<Assignment> update(@PathVariable("id") int id,@RequestBody Assignment assignment)
{
	Assignment assignment1=assignmentRepository.findById(id).orElse(null);
	if(assignment1!=null)
	{ 
		assignment1.setTitle(assignment.getTitle());
		assignment1.setDescription(assignment.getDescription());
		assignment1.setDuedate(assignment.getDuedate());
		Assignment assignment2= assignmentRepository.save(assignment1);
		return ResponseEntity.ok(assignment2);
    }
	else
	{
		return ResponseEntity.notFound().build();
	}
}



@DeleteMapping("/{id}")
public int Delete(@PathVariable("id")int id)
{
	assignmentRepository.deleteById(id);
	return 1;
}

}