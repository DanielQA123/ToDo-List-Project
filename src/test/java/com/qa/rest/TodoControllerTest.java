package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.services.TodoService;

@SpringBootTest
public class TodoControllerTest {

	@MockBean
	private TodoService service;

	@Autowired // (Or Mockbean?)
	private TodoController controller;

	public void createTodo() {
		// Resources:
		// Rules:
		// Action:
		// Assertions:
	}

	public void readAll() {
		// Resources:
		// Rules:
		// Action:
		// Assertions:

	}
	
	public void readTodo() {
		// Resources:
		// Rules:
		// Action:
		// Assertions:
	}

	public void updateTodo() {
		// Resources:
		// Rules:
		// Action:
		// Assertions:
	}


	public void deleteTodo() {
		// Resources:
		// Rules:
		// Action:
		// Assertions:
	}
	
}
