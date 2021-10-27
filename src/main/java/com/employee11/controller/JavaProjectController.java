package com.employee11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee11.exception.ResourceNotFoundException;
import com.employee11.model.JavaProject;
import com.employee11.repository.JavaProjectRepository;
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
@RequestMapping("/api/jv1/")
public class JavaProjectController {
	@Autowired
	private JavaProjectRepository jvprojectRepository;
	
	// get all jvProject
		@GetMapping("/jvproject")
		public List<JavaProject> getAllJvProjects(){
			return jvprojectRepository.findAll();
		}	
		
		// create jvProject rest api
		@PostMapping("/jvprojects")
		public JavaProject createJvProject(@RequestBody JavaProject project) {
			return jvprojectRepository.save(project);
		}
		
		// get jvProject by id rest api
		@GetMapping("/jvprojects/{id}")
		public ResponseEntity<JavaProject> getJvProjectById(@PathVariable Long id) {
			System.out.println("****************"+id);
			JavaProject project = jvprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			return ResponseEntity.ok(project);
		}
		
		// update jvProject rest api
		
		@PutMapping("/jvprojects/{id}")
		public ResponseEntity<JavaProject> updateJvProjects(@PathVariable Long id, @RequestBody JavaProject projectDetails){
			JavaProject project = jvprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			project.setProjectName(projectDetails.getProjectName());
			project.setStudentName(projectDetails.getStudentName());
		
			
			JavaProject updatedProject = jvprojectRepository.save(project);
			return ResponseEntity.ok(updatedProject);
		}
		
		// delete jvemployee rest api
		@DeleteMapping("/jvprojects/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteJvProject(@PathVariable Long id){
		     System.out.println("delete me");
		     JavaProject project = jvprojectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			jvprojectRepository.delete(project);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
