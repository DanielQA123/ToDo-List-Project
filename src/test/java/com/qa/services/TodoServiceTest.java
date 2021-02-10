package com.qa.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
		TodoDomain testTodo = new TodoDomain(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true, null);
		Mockito.when(this.mockedRepo.save(Mockito.any(TodoDomain.class))).thenReturn(testTodo);
		TodoDTO result = this.service.createTodo(testTodo);
		Assertions.assertThat(result).isEqualTo(this.mockedMapper.map(testTodo, TodoDTO.class));
		Assertions.assertThat(result).usingRecursiveComparison();
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(TodoDomain.class));
	}

	@Test
	public void readAll() {
		List<TodoDTO> result = this.service.readAll();
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findAll();
	}

	@Test
	public void readTodo() {
		TodoDomain testTodo = new TodoDomain(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true, null);
		TodoDTO testDTO = this.mockedMapper.map(testTodo, TodoDTO.class);
		Mockito.when(this.mockedRepo.findById(testTodo.getId())).thenReturn(Optional.of(testTodo));
		TodoDTO result = this.service.readTodo(1L);
		Assertions.assertThat(result).isEqualTo(testDTO);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void updateTodo() {
		
		TodoDomain savedTodo = mockedRepo.save(new TodoDomain(1L, "Assignment", "finish project", Date.valueOf("2020-12-11"),
				true, null));
		Assertions.assertThat(savedTodo.getId()).isGreaterThan(0);
		TodoDTO testDTO = this.mockedMapper.map(savedTodo, TodoDTO.class);
		TodoDTO result = this.service.updateTodo(1L, savedTodo);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(TodoDomain.class));
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
		
//		TodoDTO testDTO = this.mockedMapper.map(savedTodo, TodoDTO.class);
//		TodoDTO result = this.service.updateTodo(1L, savedTodo);
//		
//		Mockito.when(this.mockedRepo.findById(testTodo.getId())).thenReturn(Optional.of(testTodo));
//		Mockito.when(this.mockedRepo.save(Mockito.any(TodoDomain.class))).thenReturn(testTodo);
//		Assertions.assertThat(result).isEqualTo(testDTO);
//		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(TodoDomain.class));
//		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
		
	}

	@Test
	public void delete() {
		boolean result = this.service.delete(1L);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).deleteById(1L);
	}

}
