package com.employee11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.DataScience;
import com.employee11.repository.DataScienceRepository;
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
@RequestMapping("/api/ds/")
public class DataScienceController {
	
	@Autowired
	private DataScienceRepository employeeRepository;
	
	
	//get count all employee
	@GetMapping("/dsproject/count")
	public int getAllCountEmployee() {
		List<DataScience> employee =employeeRepository.findAll();
		int all=employee.size();
		return all;
		
	}
	// get all employees
	@GetMapping("/dsproject")
	public List<DataScience> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/dsproject")
	public DataScience createEmployee(@RequestBody DataScience employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/dsproject/{id}")
	public ResponseEntity<DataScience> getEmployeeById(@PathVariable Long id) {
		System.out.println("****************"+id);
		DataScience employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	
	@PutMapping("/dsproject/{id}")
	public ResponseEntity<DataScience> updateEmployee(@PathVariable Long id, @RequestBody DataScience employeeDetails){
		DataScience employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		DataScience updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
	     System.out.println("delete me");
	     DataScience employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	

}
}
