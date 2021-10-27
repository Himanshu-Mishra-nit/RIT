package com.employee11.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.EmailRequest;
import com.employee11.model.Employee;
import com.employee11.repository.EmployeeRepository;
import com.employee11.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//get count all employee
	@GetMapping("/employees/count")
	public int getAllCountEmployee() {
		List<Employee> employee =employeeRepository.findAll();
		int all=employee.size();
		return all;
		
	}
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		System.out.println("****************"+id);
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
	     System.out.println("delete me");
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@Autowired
	private SendEmailService sendEmailSerivce;
	//api to send email
	@RequestMapping(value="/sendemail",method=RequestMethod.POST)
	 public  ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		 
		boolean ans = this.sendEmailSerivce.sendSimpleMessage(request.getTo(),request.getSubject(),request.getText());
		if(ans)
		{	
		     return ResponseEntity.ok("Email is sent successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( "Email Not sent..");
		}
		}
	
	
}
