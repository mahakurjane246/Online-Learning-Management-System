package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}
