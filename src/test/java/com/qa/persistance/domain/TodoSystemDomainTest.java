package com.qa.persistance.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.persistance.dtos.TodoSystemDTO;

public class TodoSystemDomainTest {
	
	public static TodoSystemDomain testDomain;
	
	@BeforeAll
	public static void setUpTest() {
		testDomain = new TodoSystemDomain(1L, "Complete This Month", null);
	}
	
	@BeforeEach
	public void testBefore() {
		testDomain = new TodoSystemDomain(1L, "Complete This Week", null);
	}
	
	@Test
	public void getSetIdTest() {
		testDomain.setId(2L);
		Long id = testDomain.getId();
		assertEquals(2L, id);
	}

	@Test
	public void getObjective() {
		testDomain.getObjective();
		assertEquals(testDomain.getObjective(), "Complete This Week");
	}

	@Test
	public void setObjective() {
		String objective = testDomain.getObjective();
		testDomain.setObjective("Complete This Week");
		assertEquals("Complete This Week", objective);
	}

	@Test
	public void getTodoList() {
		testDomain.getTodoList();
	}

	@Test
	public void setTodoList() {
		testDomain.setTodoList(null);
	}
	
	@Test
	public void emptyConstructorTest() {
		TodoSystemDomain testDomain = new TodoSystemDomain();
		
	}
	

}
