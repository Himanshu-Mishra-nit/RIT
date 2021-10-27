package com.employee11.repository;

import com.employee11.model.ProjectAssign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<ProjectAssign, Long> {

}
