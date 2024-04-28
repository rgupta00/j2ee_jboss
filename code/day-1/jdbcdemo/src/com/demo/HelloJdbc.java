package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbc {
	
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
			
			//create Statement and resultset 
			Statement stmt=connection.createStatement();
			//executeQuery vs executeUpdate
			//fetch 		 add/update/delete
			
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getString(1)+": "+ rs.getString(3)+": "+rs.getDouble(4));
			}
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
