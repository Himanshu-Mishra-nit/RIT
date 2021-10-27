package com.employee11.repository;

import com.employee11.model.PythonProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PythonProjectRepository extends JpaRepository<PythonProject, Long>{

}

