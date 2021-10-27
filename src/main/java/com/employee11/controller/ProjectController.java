package com.employee11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.ProjectAssign;
import com.employee11.repository.ProjectRepository;
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
@RequestMapping("/api/v2/")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;
	
	// get all Project
		@GetMapping("/projects")
		public List<ProjectAssign> getAllProjects(){
			return projectRepository.findAll();
		}	
		
		// create Project rest api
		@PostMapping("/projects")
		public ProjectAssign createEmployee(@RequestBody ProjectAssign project) {
			return projectRepository.save(project);
		}
		
		// get Project by id rest api
		@GetMapping("/projects/{id}")
		public ResponseEntity<ProjectAssign> getProjectById(@PathVariable Long id) {
			System.out.println("****************"+id);
			ProjectAssign project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			return ResponseEntity.ok(project);
		}
		
		// update Project rest api
		
		@PutMapping("/projects/{id}")
		public ResponseEntity<ProjectAssign> updateProjects(@PathVariable Long id, @RequestBody ProjectAssign projectDetails){
			ProjectAssign project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			project.setProjectName(projectDetails.getProjectName());
			project.setSubject(projectDetails.getSubject());
		
			
		ProjectAssign updatedProject = projectRepository.save(project);
			return ResponseEntity.ok(updatedProject);
		}
		
		// delete employee rest api
		@DeleteMapping("/projects/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteProject(@PathVariable Long id){
		     System.out.println("delete me");
			ProjectAssign project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			projectRepository.delete(project);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}		
	

}
