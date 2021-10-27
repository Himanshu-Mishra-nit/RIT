package com.employee11.repository;

import com.employee11.model.DataScienceProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



 


@Repository
public interface DataScienceProjectRepository extends JpaRepository<DataScienceProject, Long>{

}
