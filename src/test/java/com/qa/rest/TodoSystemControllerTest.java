package com.qa.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.persistance.domain.TodoSystemDomain;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.persistance.dtos.TodoSystemDTO;
import com.qa.services.TodoSystemService;

@SpringBootTest
public class TodoSystemControllerTest {
	
	@MockBean
	private TodoSystemService service;
	
	@Autowired
	private TodoSystemController controller;
	
	@Test
	public void createTodo() {
		// RESOURCES:
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		TodoSystemDTO testDTO = new TodoSystemDTO(1L, "Complete This Month", null);
		
		// RULES:
		Mockito.when(this.service.createTodo(testSystem)).thenReturn(testDTO);
		
		// ACTION:
		ResponseEntity<TodoSystemDTO> result = this.controller.createTodo(testSystem);

		// ASSERTIONS:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<TodoSystemDTO>(testDTO, HttpStatus.CREATED));
		Mockito.verify(this.service, Mockito.times(1)).createTodo(testSystem);
	}
	
	
	@Test
	public void readAll() {
		// RESOURCES:
		TodoSystemDTO testDTO = new TodoSystemDTO(1L, "Complete This Month", null);
		
		// RULES:
		// ACTION:
		// ASSERTIONS:
	}

	@Test
	public void readTodo() {
		// RESOURCES:
		// RULES:
		// ACTION:
		// ASSERTIONS:
	}

	@Test
	public void updateTodo() {
		// RESOURCES:
		// RULES:
		// ACTION:
		// ASSERTIONS:
	}

	@Test
	public void deleteSuccessful() {
		// RESOURCES:
		// RULES:
		// ACTION:
		// ASSERTIONS:
	}

	@Test
	public void deleteUnsuccessful() {
		// RESOURCES:
		// RULES:
		// ACTION:
		// ASSERTIONS:
	}

}
