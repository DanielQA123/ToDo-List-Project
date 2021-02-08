package com.qa.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistance.domain.TodoSystemDomain;
import com.qa.persistance.domain.TodoDomain;

@Repository
public interface TodoSystemRepo extends JpaRepository<TodoSystemDomain, Long> {
	
	//CRUD -> H2 database 
	
	//CREATE 
	//READ
	//UPDATE
	//DELETE
	
	

}
