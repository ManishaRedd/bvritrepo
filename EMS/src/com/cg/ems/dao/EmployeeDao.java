package com.cg.ems.dao;
import java.util.List;				
import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
public interface EmployeeDao {

	public int addEmployee(Employee employee) throws EmployeeException;
	public Employee findEmployeeById(int emploeeId) throws EmployeeException;
	public Employee deleteEmployeeById(int emploeeId) throws EmployeeException;
	
	public List<Employee> findAllEmployee()throws EmployeeException;
	
}
