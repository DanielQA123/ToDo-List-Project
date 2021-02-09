package com.qa.services;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistance.domain.TodoDomain;
import com.qa.persistance.domain.TodoSystemDomain;
import com.qa.persistance.repos.TodoRepo;

@SpringBootTest
public class TodoServiceTest {

	@MockBean
	private ModelMapper mockedMapper;

	@MockBean
	private TodoRepo mockedRepo;

	@Autowired
	private TodoService service;

	// MY CRUD TEST
	@Test
	public void createTodo() {
	
		TodoDomain testTodo = new TodoDomain(1L,"Cook","Dinner for today", Date.valueOf("2020-09-11"), true, null);
		
		Mockito.when(this.mockedRepo.save(Mockito.any(TodoDomain.class))).thenReturn(testTodo);

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
