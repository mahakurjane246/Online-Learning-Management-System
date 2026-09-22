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

import com.example.demo.Dao.ResultRepository;
import com.example.demo.Model.Result;
import com.example.demo.client.AssignmentClient;
import com.example.demo.client.EnrollementClient;
import com.example.demo.client.StudentClient;

@RestController
@RequestMapping("/results")
public class ResultController {
private final ResultRepository resultRepository;
private final EnrollementClient enrollementClient;
private final StudentClient studentClient;
private final AssignmentClient assignmentClient;

public ResultController(ResultRepository resultRepository, EnrollementClient enrollementClient,
		StudentClient studentClient, AssignmentClient assignmentClient) {
	super();
	this.resultRepository = resultRepository;
	this.enrollementClient = enrollementClient;
	this.studentClient = studentClient;
	this.assignmentClient = assignmentClient;
}

@PostMapping
public ResponseEntity<Result> save(@RequestParam("enrollementid")int enrollementid,@RequestParam("studentid")int studentid,@RequestParam("assignmentid")int assignmentid,@RequestBody Result result)
{
	if(enrollementClient.findById(enrollementid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	if(studentClient.findById(studentid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	if(assignmentClient.findById(assignmentid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	Result res=result;
	res.setEnrollmentid(enrollementid);
	res.setStudentid(studentid);
	res.setAssignmentid(assignmentid);
	res.setDate(LocalDate.now());
	Result res1=resultRepository.save(res);
	return ResponseEntity.ok(res1);
}

@GetMapping("/{id}")
public Result findById(@PathVariable("id")int id)
{
	return resultRepository.findById(id).orElse(null);
}

@GetMapping
public List<Result> findAll()
{
	return resultRepository.findAll();
}

@PutMapping("/{id}")
public ResponseEntity<Result> update(@PathVariable("id") int id,@RequestBody Result result)
{
	Result result1=resultRepository.findById(id).orElse(null);
	if(result1!=null)
	{ 
		result1.setGrade(result.getGrade());
		result1.setMarks(result.getMarks());
		Result res1=resultRepository.save(result1);
		return ResponseEntity.ok(res1);
    }
	else
	{
		return ResponseEntity.notFound().build();
	}
}


@DeleteMapping("/{id}")
public int delete(@PathVariable("id")int id)
{
	resultRepository.deleteById(id);
	return 1;
}


}