package EmployeeProject.emp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import EmployeeProject.emp.EmployeWrapper;
import EmployeeProject.emp.Employee;
import EmployeeProject.emp.Repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo emprepo;
	
	public List<Employee> getAllEmployees() 
	{
		return emprepo.findAll();
	}

	public List<Employee> getEmpByExperience(int exp) 
	{
		if(exp<=0) 
		{
			 throw new IllegalArgumentException("Experience must be greater than 0");
		}
		return emprepo.findAll()
				      .stream()
				      .filter(emp -> emp.getExperience()==exp)
				      .collect(Collectors.toList());	
	}

	public Employee addEmployee(Employee addemp) 
	{
		return 	emprepo.save(addemp) ;
	}

	public ResponseEntity<String> deleteEmpByEmpid(Integer empid) 
	{
		if(emprepo.existsById(empid))
		{
			emprepo.deleteById(empid);
			return new ResponseEntity<>("employees deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Employee ID does not exist", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Employee> updateEmpDetails(Employee updateemp) 
	{
		if(emprepo.existsById(updateemp.getEmpid())!=false)
		{
	     emprepo.save(updateemp);
	     return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	public ResponseEntity<List<EmployeWrapper>> getEmpLimitedDetails(List<Integer> empids) 
	{
		List<EmployeWrapper> limiteddetails = new ArrayList<EmployeWrapper>();
		List<Employee> totaldetails = new ArrayList<Employee>();
		for(Integer empid : empids)
		{
		       totaldetails.add(emprepo.findById(empid).get());
		}
		for(Employee empdata : totaldetails )
		{
			EmployeWrapper emp1 = new EmployeWrapper();
			emp1.setEmpid(empdata.getEmpid());
			emp1.setEmpname(empdata.getEmpname());
			emp1.setAge(empdata.getAge());
			limiteddetails.add(emp1);
		}
		return new ResponseEntity<>(limiteddetails, HttpStatus.CREATED);
	}
}
