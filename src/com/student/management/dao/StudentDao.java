package com.student.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;
import com.student.management.db.DBConnection;
import com.student.management.model.Student;

public class StudentDao implements StudentDaoInterface {

	@Override
	public boolean insertStudent(Student s) {
		boolean flag= false;
		try {
			Connection con=DBConnection.createConnection();
			String query="insert into student_details(sname,clgName,city,percentage) value(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,s.getName());
			pst.setString(2,s.getClgName());
			pst.setString(3,s.getCity());
			pst.setDouble(4,s.getPercentage());
			pst.executeUpdate();
			flag=true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delelte(int roll) {
		boolean flag= false;
		try {
			Connection con=DBConnection.createConnection();
			String query ="delete from student_details where rollnum="+roll;
			PreparedStatement pst=con.prepareStatement(query);
			pst.executeUpdate();
			flag=true;
		}catch(Exception ex) {
			ex.printStackTrace();
			flag=true;
		}
		return false;
	}

	@Override
	public boolean update(int roll, String update, int ch, Student s) {
		int choice =ch;
		boolean flag= false;
		try {
			Connection con=DBConnection.createConnection();
			String query="update student_details set sname=? where rollnum=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,update);
			pst.setInt(2,roll);
			pst.executeUpdate();
			flag=true;
		}catch(Exception ex) {
			ex.printStackTrace();
			flag=false;
		}
		return false;
	}

	@Override
	public void showAllStudent() {
		try {
			Connection con=DBConnection.createConnection();
			String query ="select * from student_details";
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery(query);
			while(rs.next()) {
				System.out.println("RollNumber: "+rs.getInt(1)+"\n"+"Name: "+rs.getString(2)+"\n"+"college name: "+rs.getString(3)+
						"\n"+"City: "+rs.getString(4)+"\n"+"Percentage: "+rs.getDouble(5));
				System.out.println("---------------------------------");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean showStudentById(int roll) {
		try {
			Connection con=DBConnection.createConnection();
			String query ="select * from student_details where rollnum="+roll;
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery(query);
			while(rs.next()) {
				System.out.println("RollNumber: "+rs.getInt(1)+"\n"+"Name: "+rs.getString(2)+"\n"+"college name: "+rs.getString(3)+
						"\n"+"City: "+rs.getString(4)+"\n"+"Percentage: "+rs.getDouble(5));
				System.out.println("---------------------------------");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
