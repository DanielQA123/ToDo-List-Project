package com.qa.rest;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class TodoSystemControllerIntegrationTest {

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

		// Resources:
		TodoDomain contentBody = new TodoDomain("Shopping", "Buy Pjs", Date.valueOf("2021-01-11"), true, null);
		TodoDTO expectedResult = mapToDTO(contentBody);
		expectedResult.setId(6L);

		// Set Up request:
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, "http://localhost:8080/todo/create").contentType(MediaType.APPLICATION_JSON)
				.content(jsonifier.writeValueAsBytes(contentBody)).accept(MediaType.APPLICATION_JSON);

		// Set up expectation:
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));

		// perform/action
		this.mock.perform(mockRequest).andExpect(matchStatus);
		this.mock.perform(mockRequest).andExpect(matchContent);

	}

	@Test
	public void readAll() throws Exception {
		
		
		
		
		
	}

	@Test
	public void readTodo() throws Exception {
		TodoDTO expectedResult = new TodoDTO(1L,"Assignment", "complete project work", Date.valueOf("2020-12-11"),
				true);

		// Set Up request:
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				"http://localhost:8080/todo/read/" + ID);

		// Set up expectation:
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
		// perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
		this.mock.perform(mockRequest).andExpect(matchContent);
	}

	@Test
	public void updateTodo() throws Exception {

//		// Resources:
//		TodoDomain contentBody = new TodoDomain("The dog", "Long walk", Date.valueOf("2021-02-01"), true, null);
//		TodoDTO expectedResult = mapToDTO(contentBody);
//		//expectedResult.getId();
//
//		// Set Up request:
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
//				.request(HttpMethod.PUT, "http://localhost:8080/todo/update/" + 6).contentType(MediaType.APPLICATION_JSON)
//				.content(jsonifier.writeValueAsBytes(contentBody)).accept(MediaType.APPLICATION_JSON);
//
//		// Set up expectation:
//		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
//		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
//
//		// perform/action
//		this.mock.perform(mockRequest).andExpect(matchStatus);
//		this.mock.perform(mockRequest).andExpect(matchContent);

	}

	@Test
	public void deleteTodoSuccessful() throws Exception {

		// Set Up request:
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"http://localhost:8080/todo/delete/" + ID);

		// Set up expectation:
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		// perform
		this.mock.perform(mockRequest).andExpect(matchStatus);

	}

	@Test
	public void deleteTodoUnsuccessful() throws Exception {

//		// Set Up request:
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
//				"http://localhost:8080/todo/delete/" + ID);
//
//		// Set up expectation:
//		ResultMatcher matchStatus = MockMvcResultMatchers.status().is(500);
//		
//		// perform
//		this.mock.perform(mockRequest).andExpect(matchStatus);

	}

}
