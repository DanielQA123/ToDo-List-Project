package com.qa.rest;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistance.domain.TodoDomain;
import com.qa.persistance.dtos.TodoDTO;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class TodoControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private final int ID = 1;
	
	private TodoDTO mapToDTO(TodoDomain model) {
		return this.mapper.map(model, TodoDTO.class);
	}
	
	@Test
	public void createTodo() throws Exception {
	}
	
	@Test
	public void readAll() throws Exception {
	}

	@Test
	public void readTodo() throws Exception {
		
		//Set Up request: 
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8080/todo/read/" + ID);
		
		//Set up expectation: 
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		
		//perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
		
	}

	@Test
	public void updateTodo() throws Exception{
	}

	@Test
	public void deleteTodo() throws Exception{
	}

}
