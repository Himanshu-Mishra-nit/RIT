

package com.employee11.repository;



import com.employee11.model.Java;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JavaRepository extends JpaRepository<Java, Long>{

}

