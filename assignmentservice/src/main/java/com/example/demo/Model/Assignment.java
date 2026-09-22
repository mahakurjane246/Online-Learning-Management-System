package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String title;
String description;
int courseid;
int instructorid;
int duedate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public int getInstructorid() {
	return instructorid;
}
public void setInstructorid(int instructorid) {
	this.instructorid = instructorid;
}
public int getDuedate() {
	return duedate;
}
public void setDuedate(int duedate) {
	this.duedate = duedate;
}

}