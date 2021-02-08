package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.persistance.domain.TodoDomain;
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

	private TodoDTO mapToDTO(TodoDomain model) {
		return this.mapper.map(model, TodoDTO.class);
	}

	// GET => READ:

	public List<TodoDTO> readAll() {
		List<TodoDomain> dbList = this.repo.findAll();
		List<TodoDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
	}

	public TodoDTO readTodo(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());

	}

	// POST => CREATE:

	public TodoDTO createTodo(TodoDomain todo) {
		return this.mapToDTO(this.repo.save(todo));
	}

	// PUT => UPDATE:
	
	public TodoDTO updateTodo(Long id, TodoDomain newInfo) {
		this.repo.findById(id).orElseThrow();
		
		//my target
		newInfo.setId(id);
		
		return this.mapToDTO(this.repo.save(newInfo));
		
		
	}

	// DELETE:
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		
		return this.repo.existsById(id);
	}
	
	

}
