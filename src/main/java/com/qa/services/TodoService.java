package com.qa.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.persistance.domain.Todo;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.persistance.repos.TodoRepo;

@Service
public class TodoService {

	private TodoRepo repo;
	private ModelMapper mapper;

	@Autowired
	public TodoService(TodoRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private TodoDTO map(Todo model) {
		return this.mapper.map(model, TodoDTO.class);
	}

	// POST => CREATE:

	public TodoDTO createTodo(Todo todo) {
		return this.repo.save(todo);
	}

}
