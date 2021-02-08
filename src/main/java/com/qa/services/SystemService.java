package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.persistance.domain.SystemDomain;
import com.qa.persistance.domain.Todo;
import com.qa.persistance.dtos.SystemDTO;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.persistance.repos.SystemRepo;
import com.qa.persistance.repos.TodoRepo;

@Service
public class SystemService {

	private SystemRepo repo;
	private ModelMapper mapper;

	@Autowired
	public SystemService(SystemRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private SystemDTO mapToDTO(SystemDomain model) {
		return this.mapper.map(model, SystemDTO.class);
	}

	// GET => READ:

	public List<SystemDTO> readAll() {
		List<SystemDomain> systemList = this.repo.findAll();
		List<SystemDTO> systemListDTO = systemList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return systemListDTO;
	}

	public SystemDTO readTodo(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());

	}

	// POST => CREATE:

	public SystemDTO createTodo(SystemDomain todo) {
		return this.mapToDTO(this.repo.save(todo));
	}

	// PUT => UPDATE:

	public SystemDTO updateTodo(Long id, SystemDomain newInfo) {
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
