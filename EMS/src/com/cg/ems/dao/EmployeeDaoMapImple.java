package com.cg.ems.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeDaoMapImple implements EmployeeDao{

	private Map<Integer,Employee> map;
	
	public EmployeeDaoMapImple() {
		
		map = new HashMap<Integer,Employee>();
	}
	
	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		boolean flag= map.containsKey(employee.getEmployeeId());
		if(flag) {
			throw new EmployeeException("ID already exists");
		}
		else
		{
			map.put(employee.getEmployeeId(), employee);
		}
		
		return  employee.getEmployeeId();
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException {
		boolean flag= map.containsKey(employeeId);
		Employee employee=null;
		if(flag)
		{
			employee=map.get(employeeId);
		}
		else
		{
			throw new EmployeeException(employeeId+"Id NOT FOUND");
		}
		return employee;
	}

	@Override
	public Employee deleteEmployeeById(int emploeeId) throws EmployeeException {
		
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		Collection<Employee> col=map.values();
		List<Employee> list= new ArrayList<Employee>();
		
		
		return list;
	}

}
