package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbc2Add {
	
	public static void main(String[] args) {
		//download the jar for jdbc driver add the the project (done)
		
		///load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//get connection object
		Connection connection=null;
		try {
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");
			
			 PreparedStatement pstmt=connection.prepareStatement
					 ("insert into books(isbn, title, price) values(?,?,?)");
			 pstmt.setString(1, "MAZ1243");
			 pstmt.setString(2, "travel guide to India");
			 pstmt.setDouble(3, 390.00);
			 pstmt.executeUpdate();//use to add the rec to the databse
			 
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		


		//till we have a record i want to display them
	}

}
