package com.employee11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.DataScienceProject;
import com.employee11.repository.DataScienceProjectRepository;
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
@RequestMapping("/api/ds1/")
public class DataScienceProjectController {
	@Autowired
	private DataScienceProjectRepository projectRepository;
	
	// get all dsProject
		@GetMapping("/dsproject")
		public List<DataScienceProject> getAllProjects(){
			return projectRepository.findAll();
		}	
		
		// create Project rest api
		@PostMapping("/dsprojects")
		public DataScienceProject createJvProject(@RequestBody DataScienceProject project) {
			return projectRepository.save(project);
		}
		
		// get Project by id rest api
		@GetMapping("/jvprojects/{id}")
		public ResponseEntity<DataScienceProject> getProjectById(@PathVariable Long id) {
			System.out.println("****************"+id);
			DataScienceProject project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			return ResponseEntity.ok(project);
		}
		
		// update jvProject rest api
		
		@PutMapping("/dsprojects/{id}")
		public ResponseEntity<DataScienceProject> updateProjects(@PathVariable Long id, @RequestBody DataScienceProject projectDetails){
			DataScienceProject project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			project.setProjectName(projectDetails.getProjectName());
			project.setStudentName(projectDetails.getStudentName());
		
			
			DataScienceProject updatedProject = projectRepository.save(project);
			return ResponseEntity.ok(updatedProject);
		}
		
		// delete employee rest api
		@DeleteMapping("/dsprojects/{id}")
		public ResponseEntity<Map<String, Boolean>> deletedsProject(@PathVariable Long id){
		     System.out.println("delete me");
		     DataScienceProject project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			projectRepository.delete(project);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
