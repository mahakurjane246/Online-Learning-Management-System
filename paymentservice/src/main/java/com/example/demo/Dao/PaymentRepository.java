package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
