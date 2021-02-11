package com.qa.persistance.dtos;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoDTOTest {

	private TodoDTO todo;
	
	@BeforeEach
	public void setUp() {
		todo = new TodoDTO(1L, "Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true);	
	}
	
	@Test
	public void settersTest() {
		
	}
	
	@Test
	public void emptyConstructor() {
		
	}
	
	

}
