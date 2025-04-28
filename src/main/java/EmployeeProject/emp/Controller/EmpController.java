package EmployeeProject.emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import EmployeeProject.emp.EmployeWrapper;
import EmployeeProject.emp.Employee;
import EmployeeProject.emp.Service.EmpService;

@RestController
public class EmpController 
{
    @Autowired
	private EmpService empservice;
    
//   get all employees
    @GetMapping("/allemp")
    public List<Employee> getAllEmployees()
    {
    	return empservice.getAllEmployees();
    }
    
   @GetMapping("/limiteddetails/{empids}")    
    public ResponseEntity<List<EmployeWrapper>> getEmpLimitedDetails(@PathVariable List<Integer> empids)
    {
	   return empservice.getEmpLimitedDetails(empids);
    }
    
//   get employee by experience    
    @GetMapping("/byexp/{exp}")
    public List<Employee> getEmpByExperience(@PathVariable Integer exp)
    {
    	return empservice.getEmpByExperience(exp);
    }
//   adding an employee   
    @PostMapping("/addemp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee addemp)
    {
    	Employee emp1 = empservice.addEmployee(addemp);
    	return ResponseEntity.status(HttpStatus.CREATED).body(emp1);
    }
//   updating emp details  
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmpDetails(@RequestBody Employee updateemp)
    {
    	return empservice.updateEmpDetails(updateemp);
    }
//  deleting emp by employee ID  
    @DeleteMapping("/deleteemp/{empid}")
    public ResponseEntity<String> deleteEmpByEmpid(@PathVariable Integer empid)
    {
    	return empservice.deleteEmpByEmpid(empid);
    }
    
}
