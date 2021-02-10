package com.qa.rest;

import java.sql.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.persistance.domain.TodoDomain;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.services.TodoService;

@SpringBootTest
public class TodoControllerTest {

	@MockBean
	private TodoService service;

	@Autowired // (Or Mockbean?)
	private TodoController controller;

	@Test
	public void createTodo() {

		// Resources:
		TodoDomain testTodo = new TodoDomain(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true, null);
		TodoDTO testDTO = new TodoDTO(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"), true);

		// Rules:
		Mockito.when(this.service.createTodo(testTodo)).thenReturn(testDTO);

		// Action:
		ResponseEntity<TodoDTO> result = this.controller.createTodo(testTodo);

		// Assertions:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<TodoDTO>(testDTO, HttpStatus.CREATED));
	}

	@Test
	public void readAll() {
		// Resources:
		// Rules:
		// Action:
		// Assertions:

	}

	@Test
	public void readTodo() {
		// Resources:
		TodoDomain testTodo = new TodoDomain(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true, null);
		TodoDTO testDTO = new TodoDTO(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"), true);

		// Rules:
		Mockito.when(this.service.readTodo(1L)).thenReturn(testDTO);
		
		// Action:
		ResponseEntity<TodoDTO> result = this.controller.readTodo(1L);
	
		// Assertions:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<TodoDTO>(testDTO, HttpStatus.ACCEPTED));
	}

	@Test
	public void updateTodo() {
		// Resources:
		// Rules:
		// Action:
		// Assertions:
	}

	public void deleteTodo() {
		// Resources:
		TodoDomain testTodo = new TodoDomain(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true, null);
		
		// Rules:
		Mockito.when(null)
		
		// Action:
		// Assertions:
	}

}
