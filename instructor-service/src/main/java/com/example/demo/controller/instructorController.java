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

import com.example.demo.dao.InstructorRepository;
import com.example.demo.model.Intructor;

@RestController
@RequestMapping("/instructor")
public class instructorController {
	InstructorRepository instructorrepository;

	 	
	public instructorController(InstructorRepository instructorrepository) {
		this.instructorrepository = instructorrepository;
	}

	@PostMapping
	public Intructor save(@RequestBody Intructor intructor)
	{
		return instructorrepository.save(intructor);
	}
	
	@GetMapping
	public List<Intructor> findAll()
	{
		return instructorrepository.findAll();
				
	}
	
	@GetMapping("/{id}")
	public Intructor findById(@PathVariable("id") int id)
	{
		return instructorrepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Intructor> update(@PathVariable("id") int id,@RequestBody Intructor instructor)
	{
		Intructor instructor1=instructorrepository.findById(id).orElse(null);
		if(instructor1!=null)
		{ 
			instructor1.setName(instructor.getName());
			instructor1.setEmail(instructor.getEmail());
			instructor1.setSpecialization(instructor.getSpecialization());
            Intructor instructor2=instructorrepository.save(instructor1);
            return ResponseEntity.ok(instructor2);
        }
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	
	@DeleteMapping("/{id}")
	public int delete(@PathVariable("id") int id)
	{
		instructorrepository.deleteById(id);
		return 1;
	}
}
