package com.spring.orm.entities;

import javax.persistence.*;

@Entity
@Table(name = "stdtable")
public class Student {

	//this helps to create columns and id in the database according to this names
    @Id
    @Column(name = "student_id")
	private int studentid;
    @Column(name = "student_name")
	private String studentname;

	@Column(name = "student_city")
	private String city;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student(int studentid, String studentname, String city) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.city = city;
	}
}
