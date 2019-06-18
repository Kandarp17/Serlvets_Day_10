package com.marlabs.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private DBUtil() {
		
	}
	public static Connection getConnection() {
		Connection conn= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connection = "jdbc:mysql://18.188.53.157:3306/employee?serverTimezone=EST5EDT";
			conn=DriverManager.getConnection
					(connection,"root","root");
			conn.setAutoCommit(false);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//LOG.fatal("Message");
		}
		catch(SQLException e ) {
			e.printStackTrace();
			//LOG.fatal("Message");
		}
		return conn;
		
	}
}
