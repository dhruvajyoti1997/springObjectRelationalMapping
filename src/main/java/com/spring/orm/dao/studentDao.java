package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class studentDao {
//hibernatetemplate - this obj will be used for property in IOC container
	private HibernateTemplate hibernatetemplate;

	// save student
	// we have set the bean for transaction save which coming from session factory
	// and we need to declare the annotation - @transactional
	@Transactional
	public int insert(Student student) {

		// how to insert ?
		// basically hibernate has all the methods to save the values
		Integer i = (Integer) this.hibernatetemplate.save(student);
		// return 1; //1 means one row insert
		return i;

	}
	
	//CRUD operation create read update delete
	
	//read operation single data
	public Student getStudent(int studentid) {
		
	Student std1=	hibernatetemplate.get(Student.class, studentid);
		return std1;
		
		
	}
	
	//get all data
	public List<Student> getAllStudent() {
		
	List<Student> std2=	(List<Student>) hibernatetemplate.loadAll(Student.class);
	
		return std2;
		
		
	}

	//deleteing the data
	@Transactional
	public Student deleteStudent(int studentId) {
		Student std3 = hibernatetemplate.get(Student.class,studentId );
		hibernatetemplate.delete(std3);
		return std3;
		
	}
	
	//update
	@Transactional
	public void updateStudent(Student student) {
		
		 hibernatetemplate.saveOrUpdate(student);
		 
		
	}

	
	
	

}
