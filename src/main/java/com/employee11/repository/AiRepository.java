
package com.employee11.repository;



import com.employee11.model.Ai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AiRepository extends JpaRepository<Ai, Long>{

}
