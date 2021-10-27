package com.employee11.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.*;
import com.employee11.repository.*;
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
@RequestMapping("/api/i1/")
public class InternsController {

//	@Autowired
//	private EmployeeRepository employeeRepository;
	
	@Autowired
	private InternsRepository internsRepository;
	
	@Autowired
	private JavaRepository javaRepository;
	@Autowired
	private AiRepository aiRepository;
	@Autowired
	private PythonRepository pythonRepository;
	@Autowired
	private DataScienceRepository datascienceRepository;
	@Autowired
	private Leave1Repository leaveRepository;

	//get count all employee
		@GetMapping("/interns/count")
		public int getAllCountEmployee() {
			List<Interns> employee =internsRepository.findAll();
			int all=employee.size();
			return all;
			
		}
//	// get all employees
//	@GetMapping("/employees")
//	public List<Employee> getAllEmployees(){
//		return employeeRepository.findAll();
//	}		

	@GetMapping("/interns")
	public List<Interns> getAllInterns(){
		return internsRepository.findAll();
	}	
//	// create employee rest api
//	@PostMapping("/employees")
//	public Employee createEmployee(@RequestBody Employee employee) {
//		return employeeRepository.save(employee);
//	}
	

	@PostMapping("/interns")
	public Interns createEmployee(@RequestBody Interns employee) {
		return internsRepository.save(employee);
	
	}
//	// get employee by id rest api
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		return ResponseEntity.ok(employee);
//	}
	@GetMapping("/interns/{id}")
	public ResponseEntity<Interns> getEmployeeById(@PathVariable Long id) {
		Interns employee = internsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	@PutMapping("/interns/{id}")
	public ResponseEntity<Interns> updateEmployee(@PathVariable Long id, @RequestBody Interns employeeDetails){
		Interns employee = internsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Interns updatedEmployee = internsRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	// delete employee rest api
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
//	
	@DeleteMapping("/interns/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Interns employee = internsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		internsRepository.delete(employee);
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
	@GetMapping("/python/count")
	public int getAllCountPythonInterns(){
		List<Python> employee= pythonRepository.findAll();
	    int all=employee.size();
	    return all;
	}
	@GetMapping("/java/count")
	public int getAllCountJavaInterns(){
		List<Java> employee= javaRepository.findAll();
	    int all=employee.size();
	    return all;
	}
	@GetMapping("/ai/count")
	public int getAllCountAiInterns(){
		List<Ai> employee= aiRepository.findAll();
	    int all=employee.size();
	    return all;
	}
	@GetMapping("/datascience/count")
	public int getAllCountDSInterns(){
		List<DataScience> employee= datascienceRepository.findAll();
	    int all=employee.size();
	    return all;
	}
	@GetMapping("/python")
	public List<Python> getAllPythonInterns(){
		return pythonRepository.findAll();
	}	
	@GetMapping("/java")
	public List<Java> getAllJavaInterns(){
		return javaRepository.findAll();
	}	
	@GetMapping("/ai")
	public List<Ai> getAllAiInterns(){
		return aiRepository.findAll();
	}	
	@GetMapping("/datascience")
	public List<DataScience> getAllDSInterns(){
		return datascienceRepository.findAll();
	}	
	
	@PostMapping("/python")
	public Python createEmployee(@RequestBody Python employee) {
		return pythonRepository.save(employee);
	
	}@PostMapping("/java")
	public Java createEmployee(@RequestBody Java employee) {
		return javaRepository.save(employee);
	
	}@PostMapping("/datascience")
	public DataScience createEmployee(@RequestBody DataScience employee) {
		return datascienceRepository.save(employee);
	
	}@PostMapping("/ai")
	public Ai createEmployee(@RequestBody Ai employee) {
		return aiRepository.save(employee);
	
	}
	
	//api for  add leave
	@PostMapping("/leave")
	public Leave1 createleave(@RequestBody Leave1 leave) {
		System.out.println("!!!!!!!!!!!!!!!!!");
		return leaveRepository.save(leave);
	
	}
	//api for getAllLeave
	@GetMapping("/leave")
	public List<Leave1> getAllLeaveInterns(){
		return leaveRepository.findAll();
	}	
	//delete leave
	@DeleteMapping("/leave/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteleaveEmployee(@PathVariable Long id){
		Leave1 employee = leaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		leaveRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
