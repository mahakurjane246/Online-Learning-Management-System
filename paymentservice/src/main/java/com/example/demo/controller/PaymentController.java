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

import com.example.demo.Dao.PaymentRepository;
import com.example.demo.Model.Payment;
import com.example.demo.client.EnrollementClient;
import com.example.demo.client.StudentClient;

@RestController
@RequestMapping("/payments")
public class PaymentController {
private final PaymentRepository paymentRepository;
private final EnrollementClient enrollementClient;
private final StudentClient studentClient;
public PaymentController(PaymentRepository paymentRepository, EnrollementClient enrollementClient,
		StudentClient studentClient) {
	super();
	this.paymentRepository = paymentRepository;
	this.enrollementClient = enrollementClient;
	this.studentClient = studentClient;
}

@PostMapping
public ResponseEntity<Payment> save(@RequestParam("enrollementid")int enrollementid,@RequestParam("studentid")int studentid,@RequestBody Payment payment)
{
	if(enrollementClient.findById(enrollementid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	if(studentClient.findById(studentid)==null)
	{
		return ResponseEntity.notFound().build();
	}
	Payment pay=payment;
	pay.setEnrollementid(enrollementid);
	pay.setStudentid(studentid);
	pay.setDate(LocalDate.now());
	Payment pay1=paymentRepository.save(pay);
	return ResponseEntity.ok(pay1);
}

@GetMapping("/{id}")
public Payment findById(@PathVariable("id")int id)
{
	return paymentRepository.findById(id).orElse(null);
}

@GetMapping
public List<Payment> findAll()
{
	return paymentRepository.findAll();
}

@PutMapping("/{id}")
public ResponseEntity<Payment> update(@PathVariable("id") int id,@RequestBody Payment payment)
{
	Payment payment1=paymentRepository.findById(id).orElse(null);
	if(payment1!=null)
	{ 
		payment1.setAmount(payment.getAmount());
		payment1.setStatus(payment.getStatus());
		Payment pay1=paymentRepository.save(payment1);
		return ResponseEntity.ok(pay1);

    }
	else
	{
		return ResponseEntity.notFound().build();
	}
}

@DeleteMapping("/{id}")
public int delete(@PathVariable("id")int id)
{
	paymentRepository.deleteById(id);
	return 1;
}


}