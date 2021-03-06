package com.qa.rest;

import java.sql.Date;
import java.util.List;

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
		Mockito.verify(this.service, Mockito.times(1)).createTodo(testTodo);
	}

	@Test
	public void readAll() {
		// Resources:
		TodoDTO testDTO = new TodoDTO(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"), true);
		List<TodoDTO> listDTO = List.of(testDTO);
		
		// Rules:
		Mockito.when(this.service.readAll()).thenReturn(listDTO);
		
		// Action:
		ResponseEntity<List<TodoDTO>> result = this.controller.readAll();
		
		// Assertions:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<List<TodoDTO>>(listDTO, HttpStatus.OK));
		Mockito.verify(this.service, Mockito.times(1)).readAll();
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
		Mockito.verify(this.service, Mockito.times(1)).readTodo(1L);
	}

	@Test
	public void updateTodo() {
		// Resources:
		TodoDomain testTodo_update = new TodoDomain(1L, "Exercise", "complete run", Date.valueOf("2020-12-11"),
				true, null);
		TodoDTO testDTO_update = new TodoDTO(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"), true);

		// Rules:
		Mockito.when(this.service.updateTodo(1L, testTodo_update)).thenReturn(testDTO_update);
		
		// Action:
		ResponseEntity<TodoDTO> result = this.controller.updateTodo(1L, testTodo_update);
		
		// Assertions:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<TodoDTO>(testDTO_update, HttpStatus.ACCEPTED));
		Mockito.verify(this.service, Mockito.times(1)).updateTodo(1L, testTodo_update);
		
	}

	@Test
	public void deleteTodoSuccessful() {
		// Resources:
		TodoDomain testTodo = new TodoDomain(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true, null);
		
		// Rules:
		Mockito.when(this.service.delete(1L)).thenReturn(true);

		// Action:
		ResponseEntity<Object> result = this.controller.deleteTodo(1L);
		
		// Assertions:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		Mockito.verify(this.service, Mockito.times(1)).delete(1L);
	}
	
	@Test
	public void deleteTodoUnsuccessful() {
		// Resources:
		TodoDomain testTodo = new TodoDomain(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true, null);
		
		// Rules:
		Mockito.when(this.service.delete(1L)).thenReturn(false);

		// Action:
		ResponseEntity<Object> result = this.controller.deleteTodo(1L);
		
		// Assertions:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		Mockito.verify(this.service, Mockito.times(1)).delete(1L);
	}

}
