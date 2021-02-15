package com.qa.rest;

import java.sql.Date;
import java.util.List;

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
import com.qa.persistance.domain.TodoSystemDomain;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.persistance.dtos.TodoSystemDTO;

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

	private final long ID = 1L;

	private TodoSystemDTO mapToDTO(TodoSystemDomain model) {
		return this.mapper.map(model, TodoSystemDTO.class);
	}

	@Test
	public void createTodo() throws Exception {

		// Resources:
		TodoSystemDomain contentBody = new TodoSystemDomain(1L, "Complete This Month", null);
		TodoSystemDTO expectedResult = mapToDTO(contentBody);
		expectedResult.setId(1L);

		// Set Up request:
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, "http://localhost:8080/todoSystem/create").contentType(MediaType.APPLICATION_JSON)
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
//		//Resources: 
//
//		List<TodoSystemDTO> expectedResults = List.of( new TodoSystemDTO (1L, "Complete This Month"), 
//				new TodoSystemDTO (2L, "Complete This Month"), 
//				new TodoSystemDTO (3L, "Complete This Week"),
//				new TodoSystemDTO (4L, "Complete Today"));
//		
//		//Set Up Request:
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
//				"http://localhost:8080/todoSystem/readAll");
//		
//		//Set Up Expectations: 
//		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
//		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResults));
//		
//		//Perform: 
//		this.mock.perform(mockRequest).andExpect(matchStatus);
//		this.mock.perform(mockRequest).andExpect(matchContent);
		
	}

	@Test
	public void readTodo() throws Exception {
//		TodoSystemDTO expectedResult = new TodoSystemDTO(1L,"Complete This Month");
//
//		// Set Up request:
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
//				"http://localhost:8080/todo/read/" + ID);
//
//		// Set up expectation:
//		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
//		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
//		
//		// perform
//		this.mock.perform(mockRequest).andExpect(matchStatus);
//		this.mock.perform(mockRequest).andExpect(matchContent);
	}

	@Test
	public void updateTodo() throws Exception {

		// Resources:
		TodoSystemDomain contentBody = new TodoSystemDomain(3L,"Complete This Month", null);
		TodoSystemDTO expectedResult = mapToDTO(contentBody);

		// Set Up request:
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, "http://localhost:8080/todoSystem/update/3").contentType(MediaType.APPLICATION_JSON)
				.content(jsonifier.writeValueAsBytes(contentBody)).accept(MediaType.APPLICATION_JSON);

		// Set up expectation:
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));

		// perform/action
		this.mock.perform(mockRequest).andExpect(matchStatus);
		this.mock.perform(mockRequest).andExpect(matchContent);

	}

	@Test
	public void deleteTodoSuccessful() throws Exception {

		// Set Up request:
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"http://localhost:8080/todoSystem/delete/" + ID);

		// Set up expectation:
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		// perform
		this.mock.perform(mockRequest).andExpect(matchStatus);

	}

	@Test
	public void deleteTodoUnsuccessful() throws Exception {

		// Set Up request:
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"http://localhost:8080/todoSystem/delete/" + ID);

		// Set up expectation:
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();
		
		// perform
		this.mock.perform(mockRequest).andExpect(matchStatus);

	}

}
