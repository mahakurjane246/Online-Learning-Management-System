package com.example.demo.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
int studentid;
int assignmentid;
int enrollmentid;
int marks;
String grade;
LocalDate date;
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
public int getAssignmentid() {
	return assignmentid;
}
public void setAssignmentid(int assignmentid) {
	this.assignmentid = assignmentid;
}
public int getEnrollmentid() {
	return enrollmentid;
}
public void setEnrollmentid(int enrollmentid) {
	this.enrollmentid = enrollmentid;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}

}