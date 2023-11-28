package com.student.management.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
static Connection conn;
public static Connection createConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String user="root";
		String pass="SuMa201@";
		String url="jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false";
		conn=DriverManager.getConnection(url,user,pass);
		System.out.println("connection checking"+conn);
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return conn;
}
}
