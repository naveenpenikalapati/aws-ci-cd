package EmployeeProject.emp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmployeeProject.emp.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{

	List<Employee> findAll();


	//List<Employee> getById(List<Integer> id);

}
