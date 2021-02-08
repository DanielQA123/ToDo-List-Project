package com.qa.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistance.domain.TodoDomain;

@Repository
public interface TodoRepo extends JpaRepository<TodoDomain, Long> {
	
	//CRUD -> H2 database 

}
