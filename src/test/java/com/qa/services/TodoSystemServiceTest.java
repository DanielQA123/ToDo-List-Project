package com.qa.services;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
	public void createTodo() {	
	}
	
	
	@Test
	public void readAll() {
	}

	@Test
	public void readTodo() {
	}
	
	@Test
	public void updateTodo() {
	}

	@Test
	public void delete() {
	}

}
