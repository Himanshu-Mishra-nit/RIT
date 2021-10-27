package com.employee11.repository;

import com.employee11.model.JavaProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface JavaProjectRepository extends JpaRepository<JavaProject, Long>{

}
