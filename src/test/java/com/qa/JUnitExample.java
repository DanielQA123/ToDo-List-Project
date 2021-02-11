package com.qa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.persistance.dtos.TodoDTO;

public class JUnitExample {

	public static TodoDTO testDTO;
	
	
	
	@BeforeAll
	public static void startUp() {
		System.out.println("Start Of Tests");
		

		testDTO = new TodoDTO(1L, "Project", "Working", Date.valueOf("2020-12-11"), true);
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
	}
	
	@Test
	public void setTitleTest() {
		testDTO.setTitle("Cook");
	}
	
	
//	@AfterAll
//	public static void cleanUp() {
//		System.out.println("End Of Tests");
//	}
	
//	@AfterEach
//	public void testAfter() {
//		System.out.println("Test End");
//	}
	
}
