package com.employee11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.PythonProject;
import com.employee11.repository.PythonProjectRepository;
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
@RequestMapping("/api/py1/")
public class PythonProjectController {
  
	@Autowired
	private PythonProjectRepository pyprojectRepository;
	
	// get all pyProject
		@GetMapping("/pyproject")
		public List<PythonProject> getAllPyProjects(){
			return pyprojectRepository.findAll();
		}	
		
		// create pyProject rest api
		@PostMapping("/pyprojects")
		public PythonProject createPyProject(@RequestBody PythonProject pyproject) {
			return pyprojectRepository.save(pyproject);
		}
		
		// get PyProject by id rest api
		@GetMapping("/pyprojects/{id}")
		public ResponseEntity<PythonProject> getPyProjectById(@PathVariable Long id) {
			System.out.println("****************"+id);
			PythonProject project = pyprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			return ResponseEntity.ok(project);
		}
		
		// update PyProject rest api
		
		@PutMapping("/pyprojects/{id}")
		public ResponseEntity<PythonProject> updatePyProjects(@PathVariable Long id, @RequestBody PythonProject projectDetails){
			PythonProject project = pyprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			project.setProjectName(projectDetails.getProjectName());
			project.setStudentName(projectDetails.getStudentName());
		
			
			PythonProject updatedProject = pyprojectRepository.save(project);
			return ResponseEntity.ok(updatedProject);
		}
		
		// delete pyemployee rest api
		@DeleteMapping("/pyprojects/{id}")
		public ResponseEntity<Map<String, Boolean>> deletePyProject(@PathVariable Long id){
		     System.out.println("delete me");
		     PythonProject project = pyprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			pyprojectRepository.delete(project);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}		
}
