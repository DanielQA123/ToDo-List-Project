package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistance.domain.TodoSystemDomain;
import com.qa.persistance.dtos.TodoSystemDTO;
import com.qa.persistance.repos.TodoSystemRepo;

@SpringBootTest
public class TodoSystemServiceTest {

	@MockBean
	private ModelMapper mockedMapper;
	
	@MockBean
	private TodoSystemRepo mockedRepo;
	
	@Autowired
	private TodoSystemService service;
	
	@Test
	public List<TodoSystemDTO> readAll() {
		List<TodoSystemDomain> systemList = this.repo.findAll();
		List<TodoSystemDTO> systemListDTO = systemList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return systemListDTO;
	}

	public TodoSystemDTO readTodo(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());

	}

	// POST => CREATE:

	public TodoSystemDTO createTodo(TodoSystemDomain todo) {
		return this.mapToDTO(this.repo.save(todo));
	}

	// PUT => UPDATE:

	public TodoSystemDTO updateTodo(Long id, TodoSystemDomain newInfo) {
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
