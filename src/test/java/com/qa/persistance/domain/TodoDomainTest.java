package com.qa.persistance.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoDomainTest {

	public static TodoDomain testDomain;
	
	@BeforeAll
	public static void setUpTest() {
		testDomain = new TodoDomain(1L, "Project", "Work", Date.valueOf("2020-12-11"), false, null);
	}

	@BeforeEach
	public void testBefore() {
		testDomain = new TodoDomain(1L, "Project", "Working", Date.valueOf("2020-12-11"), false, null);
	}

	@Test
	public void getSetIdTest() {
		testDomain.setId(2L);
		Long id = testDomain.getId();
		assertEquals(2L, id);
	}

	@Test
	public void getTitleTest() {
		testDomain.getTitle();
		assertEquals(testDomain.getTitle(), "Project");
	}

	@Test
	public void setTitleTest() {
		String title = testDomain.getTitle();
		testDomain.setTitle("Project");
		assertEquals("Project", title);
	}

	@Test
	public void getDescriptionTest() {
		testDomain.getDescription();
		assertEquals(testDomain.getDescription(), "Working");
	}

	@Test
	public void setDescriptionTest() {
		String description = testDomain.getDescription();
		testDomain.setDescription("Working");
		assertEquals("Working", description);
	}

	@Test
	public void getDateTest() {
		
	}

	@Test
	public void setDateTest() {
	}

	@Test
	public void isFinishTest() {
	}

	@Test
	public void setFinishTest() {
	}

	@Test
	public void getTheTodoTest() {
	}

	@Test
	public void setTheTodoTest() {
	}
	
	@Test
	public void emptyConstructorTest() {
		
	}

}
