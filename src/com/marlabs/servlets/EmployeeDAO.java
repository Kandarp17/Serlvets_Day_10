package com.marlabs.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeDAO {
	public boolean registerEmployee(final EmployeeVO valueObject)throws SQLException {
		Connection connection = null;
		PreparedStatement pstStatement = null;
		Boolean result=false;
		try {
			connection = DBUtil.getConnection();
			final String insertQuery = "insert into emp2 values(?,?,?,?)";
			pstStatement = connection.prepareStatement(insertQuery); // Step -3
			// Step -4 Write And Execute SQL Query
			// insert into emp2 values(111,'AAA',9000.34,10);
			pstStatement.setInt(1, valueObject.getEmpNumber());
			pstStatement.setString(2, valueObject.getEmpName());
			pstStatement.setDouble(3, valueObject.getEmpSalary());
			pstStatement.setInt(4, valueObject.getDepartmentNumber());
			int updateCount= pstStatement.executeUpdate();
			if(updateCount>0) {
				result=true;
			}
			connection.commit();
		}
		catch (SQLException e) {
			 try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//e.printStackTrace();
			 throw new SQLException(e); 
		}
		finally {
			try {
				// Step -5
				// Closing the Resources
				if(pstStatement!= null) {
					pstStatement.close();
				}
				if(connection!= null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return result;
	}
}
