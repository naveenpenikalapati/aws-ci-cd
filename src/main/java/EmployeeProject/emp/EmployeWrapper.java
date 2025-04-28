package EmployeeProject.emp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeWrapper 
{
	private int   empid;
	private String empname;
	private int  age;
	
	public EmployeWrapper(int empid, String empname, int age) 
	{
		this.empid = empid;
		this.empname = empname;
		this.age = age;
	}
	
	
}
