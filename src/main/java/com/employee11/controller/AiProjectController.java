package com.employee11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.AiProject;
import com.employee11.repository.AiProjectRepository;
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
@RequestMapping("/api/ai1/")
public class AiProjectController {
	@Autowired
	private AiProjectRepository aiprojectRepository;
	
	// get all aiProject
		@GetMapping("/aiproject")
		public List<AiProject> getAllAiProjects(){
			return aiprojectRepository.findAll();
		}	
		
		// create AiProject rest api
		@PostMapping("/aiproject")
		public AiProject createEmployee(@RequestBody AiProject aiproject) {
			return aiprojectRepository.save(aiproject);
		}
		
		// get aiProject by id rest api
		@GetMapping("/aiproject/{id}")
		public ResponseEntity<AiProject> getAiProjectById(@PathVariable Long id) {
			System.out.println("****************"+id);
			AiProject aiproject = aiprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("AiProject not exist with id :" + id));
			return ResponseEntity.ok(aiproject);
		}
		
		// update Project rest api
		
		@PutMapping("/aiproject/{id}")
		public ResponseEntity<AiProject> updateProjects(@PathVariable Long id, @RequestBody AiProject aiprojectDetails){
			AiProject aiproject = aiprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			aiproject.setProjectName(aiprojectDetails.getProjectName());
			aiproject.setStudentName(aiprojectDetails.getStudentName());
		
			
			AiProject aiupdatedProject = aiprojectRepository.save(aiproject);
			return ResponseEntity.ok(aiupdatedProject);
		}
		
		// delete aiproject rest api
		@DeleteMapping("/aiproject/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteaiProject(@PathVariable Long id){
		     System.out.println("delete me");
		     AiProject project = aiprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(" ai Project not exist with id :" + id));
			
			aiprojectRepository.delete(project);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}		
}
