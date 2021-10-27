package com.employee11.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	@Entity
	@Table(name = "py_project")
	public class PythonProject {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "stu_name")
		private String studentName;

		@Column(name = "project")
		private String projectName;
		
		public PythonProject(){
			
		}

		public PythonProject(String studentName, String projectName) {
			super();
			this.studentName = studentName;
			this.projectName = projectName;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
	}
