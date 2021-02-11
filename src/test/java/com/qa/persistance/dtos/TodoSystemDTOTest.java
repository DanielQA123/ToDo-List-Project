package com.qa.persistance.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoSystemDTOTest {
	
	public static TodoSystemDTO testDTO;
	
	@BeforeAll
	public static void setUpTest() {
		testDTO = new TodoSystemDTO(1L, "Complete This Month", null);
	}
	
	@BeforeEach
	public void testBefore() {
		testDTO = new TodoSystemDTO(1L, "Complete This Week", null);
	}

	@Test
	public void getSetIdTest() {
		testDTO.setId(2L);
		Long id = testDTO.getId();
		assertEquals(2L, id);
	}

	@Test
	public void getObjective() {
		testDTO.getObjective();
		assertEquals(testDTO.getObjective(), "Complete This Week");
	}

	@Test
	public void setObjective() {
		String objective = testDTO.getObjective();
		testDTO.setObjective("Complete This Week");
		assertEquals("Complete This Week", objective);
	
	}

	@Test
	public void getTodoList() {
		testDTO.getTodoList();
	}

	@Test
	public void setTodoList() {
		testDTO.setTodoList(null);
	}
	
	@Test
	public void emptyConstructorTest() {
		TodoSystemDTO testDTO = new TodoSystemDTO();
		
	}
	
}
