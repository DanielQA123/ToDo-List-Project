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
		TodoSystemDomain testSystem_update = new TodoSystemDomain(1L, "Complete This Month", null);
		TodoSystemDTO testDTO_update = new TodoSystemDTO(1L, "Complete This Month", null);
		
		// RULES:
		Mockito.when(this.service.updateTodo(1L, testSystem_update)).thenReturn(testDTO_update);
		
		// ACTION:
		ResponseEntity<TodoSystemDTO> result = this.controller.updateTodo(1L, testSystem_update);
		
		// ASSERTIONS:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<TodoSystemDTO>(testDTO_update, HttpStatus.ACCEPTED));
		Mockito.verify(this.service, Mockito.times(1)).updateTodo(1L, testSystem_update);
	}

	@Test
	public void deleteSuccessful() {
		// RESOURCES:
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		
		// RULES:
		Mockito.when(this.service.delete(1L)).thenReturn(true);
		
		// ACTION:
		ResponseEntity<Object> result = this.controller.delete(1L);
		
		// ASSERTIONS:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		Mockito.verify(this.service, Mockito.times(1)).delete(1L);
	}

	@Test
	public void deleteUnsuccessful() {
		// RESOURCES:
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		
		// RULES:
		Mockito.when(this.service.delete(1L)).thenReturn(false);
		
		// ACTION:
		ResponseEntity<Object> result = this.controller.delete(1L);
		
		// ASSERTIONS:
		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		Mockito.verify(this.service, Mockito.times(1)).delete(1L);
	}

}
