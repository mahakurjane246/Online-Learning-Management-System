package com.example.demo.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
int studentid;
int enrollementid;
int amount;
LocalDate date;
String status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public int getEnrollementid() {
	return enrollementid;
}
public void setEnrollementid(int enrollementid) {
	this.enrollementid = enrollementid;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}