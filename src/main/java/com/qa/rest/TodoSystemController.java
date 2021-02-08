package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistance.domain.TodoDomain;
import com.qa.persistance.domain.TodoSystemDomain;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.persistance.dtos.TodoSystemDTO;
import com.qa.services.TodoSystemService;
import com.qa.services.TodoService;

@RestController
@RequestMapping("/todoSystem")
public class TodoSystemController {

	private TodoSystemService service;

	@Autowired
	public TodoSystemController(TodoSystemService service) {
		super();
		this.service = service;
	}

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world";
	}

	// GET

	@GetMapping("/readAll")
	public ResponseEntity<List<TodoSystemDTO>> readAll() {
		return new ResponseEntity<List<TodoSystemDTO>>(this.service.readAll(), HttpStatus.OK);
	}


	@GetMapping("/read/{id}")
	public ResponseEntity<TodoSystemDTO> readTodo(@PathVariable("id") Long id) {
		return new ResponseEntity<TodoSystemDTO>(this.service.readTodo(id), HttpStatus.ACCEPTED);
	}

	// POST= CREATE


	@PostMapping("/create")
	public ResponseEntity<TodoSystemDTO> createTodo(@RequestBody TodoSystemDomain model) {
		return new ResponseEntity<TodoSystemDTO>(this.service.createTodo(model), HttpStatus.CREATED);
	}

	// PUT = UPDATE

	@PutMapping("/update/{id}")
	public ResponseEntity <TodoSystemDTO> updateTodo(@PathVariable("id") Long id, @RequestBody TodoSystemDomain model) {
		return new ResponseEntity<TodoSystemDTO>(this.service.updateTodo(id, model), HttpStatus.ACCEPTED);
	}

	// DELETE

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT): 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
