package com.qa.persistance.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoDTOTest {

	public static TodoDTO testDTO;

	@BeforeAll
	public static void setUpTest() {
		testDTO = new TodoDTO(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"), true);
	}

	@BeforeEach
	public void testBefore() {

		testDTO = new TodoDTO(1L, "Project", "Working", Date.valueOf("2020-12-11"), true);
		System.out.println("Start Test");
	}

	@Test
	public void getSetIdTest() {
		testDTO.setId(2L);
		Long id = testDTO.getId();
		assertEquals(2L, id);
	}

	@Test
	public void getTitleTest() {
		testDTO.getTitle();
		assertEquals(testDTO.getTitle(), "Project");
	}

	@Test
	public void setTitleTest() {
		String title = testDTO.getTitle();
		testDTO.setTitle("Project");
		assertEquals("Project", title);
	}

	@Test
	public void getDescriptionTest() {
		testDTO.getDescription();
		assertEquals("Working", testDTO.getDescription());
	}

	@Test
	public void setDescriptionTest() {
		String description = testDTO.getDescription();
		testDTO.setDescription("yo");
		assertEquals("Working", description);
	}

	@Test
	public void getDateTest() {
		testDTO.getDate();
		assertEquals(Date.valueOf("2020-12-11"), testDTO.getDate());
		
	}

	@Test
	public void setDateTest() {
		Date date = testDTO.getDate();
		testDTO.setDate(Date.valueOf("2020-12-11"));
		assertEquals(Date.valueOf("2020-12-11"), date);
	}

	@Test
	public void isFinishTest() {
		testDTO.isFinish();
		assertEquals(true, testDTO.isFinish());
	}

	@Test
	public void setFinishTest() {
		boolean finish = testDTO.isFinish();
		testDTO.setFinish(true);
		assertEquals(true, finish);
	}

	@Test
	public void emptyConstructorTest() {
		TodoDTO testDTO = new TodoDTO();
	}

}
