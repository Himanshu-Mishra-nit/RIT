

package com.employee11.repository;



import com.employee11.model.Python;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PythonRepository extends JpaRepository<Python, Long>{

}

