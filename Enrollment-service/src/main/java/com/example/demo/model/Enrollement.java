package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollement {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
int studentid;
int courseid;
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
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public String getStatus() {
	return status;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public void setStatus(String status) {
	this.status = status;
}
}