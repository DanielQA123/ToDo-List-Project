package com.qa.services;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistance.domain.TodoSystemDomain;
import com.qa.persistance.dtos.TodoSystemDTO;
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
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		Mockito.when(this.mockedRepo.save(Mockito.any(TodoSystemDomain.class))).thenReturn(testSystem);
		TodoSystemDTO result = this.service.createTodo(testSystem);
		Assertions.assertThat(result).isEqualTo(this.mockedMapper.map(testSystem, TodoSystemDTO.class));
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(TodoSystemDomain.class));
	}

	@Test
	public void readAll() {
	}

	@Test
	public void readTodo() {
	
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		Mockito.when(this.mockedRepo.findById(testSystem.getId())).thenReturn(Optional.of(testSystem));
		TodoSystemDTO result = this.service.readTodo(1L);
		TodoSystemDTO testDTO = this.mockedMapper.map(testSystem, TodoSystemDTO.class);
		Assertions.assertThat(result).isEqualTo(testDTO);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
	
	}

	@Test
	public void updateTodo() {
	}

	@Test
	public void delete() {
		boolean result = this.service.delete(1L);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).deleteById(1L);
	}

}
