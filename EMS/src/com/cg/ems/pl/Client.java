package com.cg.ems.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImple1;

public class Client {
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		EmployeeService employeeService= new EmployeeServiceImple1();
		int choice=0;
		Employee employee=null;
		List<Employee> list=null;
		while(choice!=5)
		{
			System.out.println("1.Add employee");
			System.out.println("2.search employee");
			
			System.out.println("3.Delete employee");
			System.out.println("4.List all employees");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			
			choice=scanner.nextInt();
            
			switch(choice)
			{
			case 1:System.out.println("enter name");
		           scanner.nextLine();
			       String name=scanner.nextLine();
			       System.out.println("enter salary");
			       double salary=scanner.nextDouble();
			       employee= new Employee();
			       employee.setEmployeename(name);
			       employee.setSalary(salary);
			       try
			       {
			       int id= employeeService.addEmployee(employee);
			       System.out.println("employee id="+id);
			       }catch(EmployeeException e)
			       {
			    	   System.err.println(e.getMessage());
			       }
				   break;
			
			case 2: System.out.println("Enter employee Id");
			        int id=scanner.nextInt();
			        try
			        {
			        employee =employeeService.findEmployeeById(id);
			        System.out.println("name=" +employee.getEmployeename());
			        System.out.println("salary="+employee.getSalary());
			        }catch(EmployeeException e)
			        {
			        	System.out.println(e.getMessage());
			        }
				    break;
			
			case 3:System.out.println("enter employee Id");
			 id=scanner.nextInt();
			 try
			{
				 employee =employeeService.deleteEmployeeById(id);
				 System.out.println("deleted");
				 
			}catch(EmployeeException e)
			 {
				System.out.println(e.getMessage());
			 }
				    break;
			
			case 4: try
			{
				  list=employeeService.findAllEmployee();
			      for( Employee emp: list)
			{
				id=emp.getEmployeeId();
				name=emp.getEmployeename();
				salary=emp.getSalary();
				System.out.println(id+" "+name+" "+salary);
			}
			}catch(EmployeeException e)
			{
				System.out.println(e.getMessage());
			}
				break;
			case 5: 
				System.out.println("thank you ");
		            	return;
			}
		}
	}

}
