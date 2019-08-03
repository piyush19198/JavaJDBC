package com.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC_Test_2 {
	public static void main(String[] args) {
		//String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		//String DB_URL = "jdbc:mysql://localhost:3306/anuj";
		//String USER = "root";
		//String PASS = "";

		try {

			// 1.load the jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2.establish database connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anuj", "root", "");
			int rollNo = 1;
			String SQL = "SELECT * FROM STUDENT WHERE rollno =?";
			PreparedStatement pstmt = conn.prepareStatement(SQL); 
			pstmt.setInt(1, rollNo);
			// 3.create a statement
			
			// 4.process the result
			ResultSet rs = pstmt.executeQuery();

			// 5.process the result
			while (rs.next()) 
				System.out.println(rs.getInt("rollNO")+" "+
				rs.getString("name")+" "+rs.getString("subj")+" "+ 
				rs.getFloat("marks"));
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
