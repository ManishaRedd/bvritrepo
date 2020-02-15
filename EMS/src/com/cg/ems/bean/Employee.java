package com.cg.ems.bean;

public class Employee {
	private int employeeId;
	private String employeename;
	private double salary;
	public Employee(int employeeId, String employeename, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeename = employeename;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
