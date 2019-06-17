package com.marlabs.servlets;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeVO implements Serializable {
	private int empNumber;
	private String empName;
	private double empSalary;
	private int DepartmentNumber;
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getDepartmentNumber() {
		return DepartmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		DepartmentNumber = departmentNumber;
	}
	@Override
	public String toString() {
		return "EmployeeVO [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary
				+ ", DepartmentNumber=" + DepartmentNumber + "]";
	}
	

}
