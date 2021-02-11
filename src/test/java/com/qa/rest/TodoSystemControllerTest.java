package com.qa.rest;

import java.util.List;

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
		List<TodoSystemDTO> listDTO = List.of(testDTO);
		
		// RULES:
		Mockito.when(this.service.readAll()).thenReturn(listDTO);
		
		// ACTION:
		ResponseEntity<List<TodoSystemDTO>> result = this.controller.readAll();
		
		// ASSERTIONS:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<List<TodoSystemDTO>>(listDTO, HttpStatus.OK));
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	public void readTodo() {
		// RESOURCES:
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		TodoSystemDTO testDTO = new TodoSystemDTO(1L, "Complete This Month", null);
		
		// RULES:
		Mockito.when(this.service.readTodo(1L)).thenReturn(testDTO);
		
		// ACTION:
		ResponseEntity<TodoSystemDTO> result = this.controller.readTodo(1L);
		
		// ASSERTIONS:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<TodoSystemDTO>(testDTO, HttpStatus.ACCEPTED));
		Mockito.verify(this.service, Mockito.times(1)).readTodo(1L);
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
