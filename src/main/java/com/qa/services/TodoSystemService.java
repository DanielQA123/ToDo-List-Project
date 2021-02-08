package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.persistance.domain.SystemTodoDomain;
import com.qa.persistance.domain.Todo;
import com.qa.persistance.dtos.SystemTodoDTO;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.persistance.repos.TodoSystemRepo;
import com.qa.persistance.repos.TodoRepo;

@Service
public class TodoSystemService {

	private TodoSystemRepo repo;
	private ModelMapper mapper;

	@Autowired
	public TodoSystemService(TodoSystemRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private SystemTodoDTO mapToDTO(SystemTodoDomain model) {
		return this.mapper.map(model, SystemTodoDTO.class);
	}

	// GET => READ:

	public List<SystemTodoDTO> readAll() {
		List<SystemTodoDomain> systemList = this.repo.findAll();
		List<SystemTodoDTO> systemListDTO = systemList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return systemListDTO;
	}

	public SystemTodoDTO readTodo(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());

	}

	// POST => CREATE:

	public SystemTodoDTO createTodo(SystemTodoDomain todo) {
		return this.mapToDTO(this.repo.save(todo));
	}

	// PUT => UPDATE:

	public SystemTodoDTO updateTodo(Long id, SystemTodoDomain newInfo) {
		this.repo.findById(id).orElseThrow();

		// my target
		newInfo.setId(id);

		return this.mapToDTO(this.repo.save(newInfo));

	}

	// DELETE:
	public boolean delete(Long id) {
		this.repo.deleteById(id);

		return this.repo.existsById(id);
	}

}
