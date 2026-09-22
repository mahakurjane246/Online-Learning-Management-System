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

import com.example.demo.dao.CourseRepository;
import com.example.demo.model.Course;
@RestController
@RequestMapping("/courses")
public class courseController {
	
	CourseRepository courserepository;

		
	public courseController(CourseRepository courserepository) {
		super();
		this.courserepository = courserepository;
	}
	@PostMapping
	public Course save(@RequestBody Course course)
	{
		return courserepository.save(course);
	}
	@GetMapping
	public List<Course> findAll()
	{
	return courserepository.findAll();	
	}
	
	@GetMapping("/{id}")
	public Course findById(@PathVariable("id") int id)
	{
		return courserepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> update(@PathVariable("id") int id,@RequestBody Course course)
	{
		Course course1=courserepository.findById(id).orElse(null);
		if(course1!=null)
		{ 
			course1.setCourseName(course.getCourseName());
			course1.setDuration(course.getDuration());
			course1.setFee(course.getFee());
        Course course2= courserepository.save(course1);
        return ResponseEntity.ok(course2);
        }
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	
	@DeleteMapping("/{id}")
	public int delete(@PathVariable("id") int id)
	{
		courserepository.deleteById(id);
		return 1;
	}
}
