package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Intructor;

public interface InstructorRepository extends JpaRepository<Intructor, Integer> {

	
}
