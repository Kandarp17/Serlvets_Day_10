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
			Class.forName("com.mysql.jdbc.Driver");
			String connection = "jdbc:mysql://18.217.17.251:3306/employee";
			conn=DriverManager.getConnection
					(connection,"root","root");
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
