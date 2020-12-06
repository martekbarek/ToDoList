package com.paka.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "todolist";
		String pass = "todolist";
		
		try {
			System.out.println("Connecting to database: "+ jdbcUrl);
			
			Connection myConn=
					DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successful ;ppp");
			
			
			
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
