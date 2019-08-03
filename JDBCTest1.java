package com.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test {

	public static void main(String[] args) {
		String JDBC_Driver = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/Piyush";
		String USER = "root";
		String PASS = "";

		try {
			// 1.Load the JDBC Driver
			Class.forName(JDBC_Driver);
			// 2.Establish database connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// 3.Create a statement
			Statement stat = conn.createStatement();
			// 4.Process the result
			ResultSet rs = stat.executeQuery("SELECT * FROM STUDENT");

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.close();
			stat.close();
			conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
