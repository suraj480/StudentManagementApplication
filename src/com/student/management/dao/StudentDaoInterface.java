package com.student.management.dao;
import com.student.management.model.Student;
public interface StudentDaoInterface {
public boolean insertStudent(Student s);
public boolean delelte(int roll);
public boolean update(int roll,String update,int ch,Student s);
public void showAllStudent();
public boolean showStudentById(int roll);
}
 	