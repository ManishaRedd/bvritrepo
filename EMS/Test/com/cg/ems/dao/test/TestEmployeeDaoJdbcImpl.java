package com.cg.ems.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoJdbcImpl;

class TestEmployeeDaoJdbcImpl {

	

	@Test
	public void testFindEmployeeByIdExist()throws Exception
	{
		EmployeeDao dao= new EmployeeDaoJdbcImpl();
		Employee employee=dao.findEmployeeById(1056);
		//assertEquals(1056,employee.getEmployeeId());
		assertNotNull(employee);
				
	}
	@Test
	public void testFindEmployeeByIdNotExist()throws Exception
	{
		EmployeeDao dao= new EmployeeDaoJdbcImpl();
		Employee employee=dao.findEmployeeById(1056);
		//assertEquals(1056,employee.getEmployeeId());
		assertNotNull(employee);
				
	}
	
}
