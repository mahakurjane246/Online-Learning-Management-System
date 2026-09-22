package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.EnrollementDto;

@FeignClient(name="Enrollment-service")
public interface EnrollementClient {
	@GetMapping("/enrollements/{id}")
	public EnrollementDto findById(@PathVariable("id")int id);

}