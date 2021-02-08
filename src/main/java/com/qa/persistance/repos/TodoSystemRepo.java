package com.qa.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistance.domain.SystemTodoDomain;
import com.qa.persistance.domain.Todo;

@Repository
public interface TodoSystemRepo extends JpaRepository<SystemTodoDomain, Long> {
	
	//CRUD -> H2 database 
	
	//CREATE 
	//READ
	//UPDATE
	//DELETE
	
	

}
