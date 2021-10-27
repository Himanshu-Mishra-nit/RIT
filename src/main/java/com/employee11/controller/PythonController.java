package com.employee11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.Python;
import com.employee11.repository.PythonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/py/")
public class PythonController {

	
	@Autowired
	private PythonRepository employeeRepository;
	
	
	//get count all employee
	@GetMapping("/pyproject/count")
	public int getAllCountEmployee() {
		List<Python> employee =employeeRepository.findAll();
		int all=employee.size();
		return all;
		
	}
	// get all employees
	@GetMapping("/pyproject")
	public List<Python> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/pyproject")
	public Python createEmployee(@RequestBody Python employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/pyproject/{id}")
	public ResponseEntity<Python> getEmployeeById(@PathVariable Long id) {
		System.out.println("****************"+id);
		Python employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	
	@PutMapping("/pyproject/{id}")
	public ResponseEntity<Python> updateEmployee(@PathVariable Long id, @RequestBody Python employeeDetails){
		Python employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Python updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/pyproject/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
	     System.out.println("delete me");
	     Python employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	

}


}
