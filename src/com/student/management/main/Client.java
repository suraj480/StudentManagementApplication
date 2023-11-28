package com.student.management.main;

import java.util.Scanner;

import com.student.management.dao.StudentDao;
import com.student.management.dao.StudentDaoInterface;
import com.student.management.model.Student;

public class Client {
public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	StudentDaoInterface dao=(StudentDaoInterface) new StudentDao();
	System.out.println("*****Welcome to student management application*****");
	while(true) {
		System.out.println("\n1.Add student"+
				"\n2.Show All students"
				+
				"\n3.Get student based on roll number"
				+
				"\n4.Delete student"
				+
				"\n5.Update student"
				+
				"\n6.Exit"
				);
		System.out.println("Enter Choice");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Add Student");
			System.out.println("Enter student name :");
			String name=sc.next();
			System.out.println("Enter student college name :");
			String clgName=sc.next();
			System.out.println("Enter city:");
			String city=sc.next();
			System.out.println("Enter percentage :");
			double percentage=sc.nextDouble();
			Student st = new Student( name,clgName,city,percentage);
			boolean ans=dao.insertStudent(st);
			System.out.println("checkme"+ans);
//			if(ans) {
//				System.out.println("Record inserted successfully");
//			}else {
//				System.out.println("Something went wrong !!");
//			}
			break;
		case 2:
			System.out.println("Show All students");
			dao.showAllStudent();
			break;
		case 3:
			System.out.println("Get student based on roll number");
			System.out.println("Enter roll number: ");
			int roll =sc.nextInt();
			boolean f=dao.showStudentById(roll);
			if(!f) {
				System.out.println("Student with this id is not available in our system");
			}
			break;
		case 4:
			System.out.println("Delete student");
			System.out.println("Enter roll number to delete: ");
			int rollDelete =sc.nextInt();
			boolean deleteStundet=dao.delelte(rollDelete);
			if(!deleteStundet) {
				System.out.println("Student with this id is not available in our system");
			}
			break;
		case 5:
			System.out.println("Update student");
			System.out.println("\n1.Update name \n2.Update clgName");
			System.out.println("Enter your choice: ");
			int choice =sc.nextInt();
			if(choice==1) {
				System.out.println("Enter roll: ");
				int rnum=sc.nextInt();
				System.out.println("Enter new name: ");
				String sname=sc.next();
				Student std =new Student();
				std.setName(sname);
			boolean flag=dao.update(rnum,sname,choice,std);
				if(flag){
					System.out.println("Name update successfully");
				}else {
					System.out.println("Somenthing went wrong");
				}
			}
			break;
		case 6:
			System.out.println("Thanks you using student management application");
			System.exit(0);
			break;
		default:
				System.out.println("Please select correct choice");
				
		}
	}
}
}
