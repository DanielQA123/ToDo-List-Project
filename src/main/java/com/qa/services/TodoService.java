package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistance.repos.TodoRepo;

@Service
public class TodoService {
	
	private TodoRepo repo;

	@Autowired
	public TodoService(TodoRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	

}
