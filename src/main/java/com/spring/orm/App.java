package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.studentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext con = new ClassPathXmlApplicationContext("config.xml");

		studentDao std = con.getBean("studentDao", studentDao.class);

//    Student std1=  new Student(123, "Ramesh","Lucknow");
//    int r =std.insert(std1);
//
//    System.out.println("Done"+r);
		// this logic is to perform crud operation based on the input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true; //making it true unless it break condition is satisfied (false)

		while (go) {
			System.out.println("Press 1 for add of students");
			System.out.println("Press 2 for display of all students");
			System.out.println("Press 3 for get details of single students");
			System.out.println("Press 4 for delete a student record");
			System.out.println("Press 5 for update of student");
			System.out.println("Press 6 for exit");

			try {
				// the below code will check the user press input
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// add a student
					
//					Student std1 = new Student(116,"DhruvaJyoti","Delhi");
//					int r = std.insert(std1);
					//we will ask user for the input
					
					System.out.println("Enter the user id : ");
					int uid = Integer.parseInt(br.readLine());
					
					System.out.println("Enter the user Name : ");
					String uname = br.readLine();
					
					System.out.println("Enter the user City : ");
					String ucity = br.readLine();
					
					Student std1 = new Student(uid, uname,ucity);
					int r = std.insert(std1);
					
					break;
				case 2:
					// for display of all students
					
					List<Student> std11 = std.getAllStudent();
					for(Student ss : std11) {
						System.out.println("ID IS :" +((Student) ss).getStudentid());
						System.out.println("NAME IS :" +((Student) ss).getStudentname());
						System.out.println("CITY2 IS :" +((Student) ss).getCity());	
						
					}
					System.out.println("**************************************");
					
					break;
				case 3:
					// for get details of single students
					System.out.println("Enter the user id : ");
					int uid2 = Integer.parseInt(br.readLine());
					
					Student std2 = new Student();
					Student r1 = std.getStudent(uid2);
					
					System.out.println("ID IS :" +r1.getStudentid());
					System.out.println("NAME IS :" +r1.getStudentname());
					System.out.println("CITY2 IS :" +r1.getCity());
					break;
				case 4:
					//for delete a student record
					System.out.println("Enter the user id : ");
					int uid1 = Integer.parseInt(br.readLine());
					Student std22 = new Student();
					Student r12 = std.deleteStudent(uid1);
					
					System.out.println("Deleted Student Id =="+ r12.getStudentid());
					
					break;
				case 5:
					// for update of student
					
					System.out.println("Enter the user id : ");
					int uid23 = Integer.parseInt(br.readLine());
					
					System.out.println("Enter the user Name : ");
					String uname23 = br.readLine();
					
					System.out.println("Enter the user City : ");
					String ucity23 = br.readLine();
					
					Student std23 = new Student(uid23, uname23,ucity23);
					std.updateStudent(std23);
					
					System.out.println("STUDENT UPDATED !!!!"+ std23);
					
					
					
					break;
				case 6:
					// for exit
					go= false;
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println("Invalid Input , Try With Another One!!!");
				e.printStackTrace();
			}
		}
		
		System.out.println("Thanks For Using!!!");
	}
}