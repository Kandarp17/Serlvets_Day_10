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
			Class.forName("oracle.jdbc.driver.oracleDriver");
			conn=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","System","root");
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
