package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

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

	private TodoDTO mapToDTO(Todo model) {
		return this.mapper.map(model, TodoDTO.class);
	}
	
	//GET => READ:
	
	public List<TodoDTO> readAll(){
		List<Todo> dbList = this.repo.findAll();
		List<TodoDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		
		return resultList;
	}

	// POST => CREATE:

	public TodoDTO createTodo(Todo todo) {
		return this.mapToDTO(this.repo.save(todo));
	}

}
