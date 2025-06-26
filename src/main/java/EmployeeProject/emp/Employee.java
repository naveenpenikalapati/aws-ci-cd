package EmployeeProject.emp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
@Schema(description = "Student entity")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int   empid;
	@Schema(description = "Name of the student", example = "John Doe")
	private String empname;
	private int  age;
	private String dept;
	private int  experience;
	
}