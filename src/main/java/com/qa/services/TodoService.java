package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.persistance.domain.Todo;
import com.qa.persistance.repos.TodoRepo;

@Service
public class TodoService {

	private TodoRepo repo;

	@Autowired
	public TodoService(TodoRepo repo) {
		super();
		this.repo = repo;
	}

	//POST => CREATE
	
	public Todo createTodo(Todo todo) {
		return this.repo.save(todo);
	}

}
