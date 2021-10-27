package com.employee11.repository;

import com.employee11.model.AiProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface AiProjectRepository extends JpaRepository<AiProject, Long>{

}

