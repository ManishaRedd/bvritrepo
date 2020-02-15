package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		int id=0;
		try
		{
		Connection connection = DBUtil.getConnection();
		String cmd="insert into Employee_tbl values(?,?,?)";
		PreparedStatement pstmt=connection.prepareStatement(cmd);
		pstmt.setInt(1, employee.getEmployeeId());
		pstmt.setString(2, employee.getEmployeename());
		pstmt.setDouble(3,employee.getSalary());
		pstmt.executeUpdate();
		connection.close();
		}catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
		}
		id= employee.getEmployeeId();
		return id;
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException {
		Employee emp=new Employee();
		try
		{
		Connection connection = DBUtil.getConnection();
		String cmd="select empid,empname,empsal from Employee_tbl values where empid=(?)";
		PreparedStatement pstmt=connection.prepareStatement(cmd);
		pstmt.setInt(1, employeeId);
		//pstmt.setString(2, emp.getEmployeename());
		//pstmt.setDouble(3,emp.getSalary());
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next())
		{
			int id=rst.getInt("empid");
			String name=rst.getString("empname");
			double sal=rst.getDouble("empsal");
			emp.setEmployeeId(id);
			emp.setEmployeename(name);
			emp.setSalary(sal);
			
		}
		else
		{
			throw new EmployeeException(employeeId+"not exist");
		}
		connection.close();
		}catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
		}

		return emp;
	}

	@Override
	public Employee deleteEmployeeById(int employeeId) throws EmployeeException {
		Employee emp=new Employee();
		try
		{
		Connection connection = DBUtil.getConnection();
		String cmd="delete empid,empname,empsal from Employee_tbl values where empid=(?)";
		PreparedStatement pstmt=connection.prepareStatement(cmd);
		pstmt.setInt(1, employeeId);
		//pstmt.setString(2, emp.getEmployeename());
		//pstmt.setDouble(3,emp.getSalary());
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next())
		{
			int id=rst.getInt("empid");
			String name=rst.getString("empname");
			double sal=rst.getDouble("empsal");
			emp.setEmployeeId(id);
			emp.setEmployeename(name);
			emp.setSalary(sal);
			
		}
		else
		{
			throw new EmployeeException(employeeId+"not exist");
		}
		connection.close();
		}catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
		}

		return emp;
	}
	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		try
		{
		Connection connection=DBUtil.getConnection();
		String qry="select empid,empname,empsal from employee_tbl";
		PreparedStatement pstmt=connection.prepareStatement(qry);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("empid");
			String name=rst.getString("empname");
			int empsal=rst.getInt("empsal");
			System.out.println(id+" "+name+" "+empsal);
		}
		
		//System.out.println("connection success");
		connection.close();
	}
      catch(Exception e)
      {
    	 throw new EmployeeException(e.getMessage());
      }


		return null;
	}

}
