package com.qa.services;

import java.util.List;
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

		// RESOURCES:
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		
		// RULES:
		Mockito.when(this.mockedRepo.save(Mockito.any(TodoSystemDomain.class))).thenReturn(testSystem);
		
		// ACTION:
		TodoSystemDTO result = this.service.createTodo(testSystem);
		
		// ASSERTIONS:
		Assertions.assertThat(result).isEqualTo(this.mockedMapper.map(testSystem, TodoSystemDTO.class));
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(TodoSystemDomain.class));
	}

	@Test
	public void readAll() {

		// RESOURCES:
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		TodoSystemDomain testSystem2 = new TodoSystemDomain(2L, "Complete This Week", null);
		
		TodoSystemDTO testSystemDTO = new TodoSystemDTO(2L, "Complete This Week", null);
		TodoSystemDTO testSystemDTO2 = new TodoSystemDTO(2L, "Complete This Week", null);
		
		List<TodoSystemDomain> TodoSystem_List = List.of(testSystem, testSystem2);
		List<TodoSystemDTO> TodoSystemDTO_List = List.of(testSystemDTO, testSystemDTO2);
		
		// RULES:
		Mockito.when(this.mockedRepo.findAll()).thenReturn(TodoSystem_List);
		Mockito.when(this.mockedMapper.map(TodoSystemDTO_List, TodoSystemDTO.class)).thenReturn(testSystemDTO);
		
		// ACTION:
		List<TodoSystemDTO> result = this.service.readAll();
		
		// ASSERTION:
		Assertions.assertThat(result).isNotNull();
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findAll();
	}

	@Test
	public void readTodo() {

		// RESOURCES:
		TodoSystemDomain testSystem = new TodoSystemDomain(1L, "Complete This Month", null);
		
		// RULES:
		Mockito.when(this.mockedRepo.findById(testSystem.getId())).thenReturn(Optional.of(testSystem));
		
		// ACTION:
		TodoSystemDTO result = this.service.readTodo(1L);
		TodoSystemDTO testDTO = this.mockedMapper.map(testSystem, TodoSystemDTO.class);
		
		// ASSERTION:
		Assertions.assertThat(result).isEqualTo(testDTO);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
		
	}

	@Test
	public void updateTodo() {

		// RESOURCES:
		// RULES:
		// ACTION:
		// ASSERTION:
	}

	@Test
	public void delete() {

		// RESOURCES:
		// RULES:
		// ACTION:
		// ASSERTION:

		boolean result = this.service.delete(1L);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).deleteById(1L);
	}

}
