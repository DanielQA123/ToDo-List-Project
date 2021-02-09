package com.qa.services;

import java.sql.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistance.domain.TodoDomain;
import com.qa.persistance.dtos.TodoDTO;
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
	
		TodoDomain testTodo = new TodoDomain(1L,"Assignment","complete project work", Date.valueOf("2020-12-11"), true, null);
		
		Mockito.when(this.mockedRepo.save(Mockito.any(TodoDomain.class))).thenReturn(testTodo);

		TodoDTO result = this.service.createTodo(testTodo);
		
		Assertions.assertThat(result).isEqualTo(this.mockedMapper.map(testTodo, TodoDTO.class));
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
