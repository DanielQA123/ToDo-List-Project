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

import com.qa.persistance.domain.Todo;
import com.qa.persistance.dtos.TodoDTO;
import com.qa.services.SystemTodoService;
import com.qa.services.TodoService;

@RestController
@RequestMapping("/todoSystem")
public class TodoSystemController {

	private SystemTodoService service;

	@Autowired
	public TodoSystemController(SystemTodoService service) {
		super();
		this.service = service;
	}

//    private Long id = 0L;
//	private List<Todo> todoList = new ArrayList<>();

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world";
	}

	// GET

//	@GetMapping("/readAll")
//	public List<Todo> readAll() {
//		return todoList;
//	}

	@GetMapping("/readAll")
	public ResponseEntity<List<TodoDTO>> readAll() {
		return new ResponseEntity<List<TodoDTO>>(this.service.readAll(), HttpStatus.OK);
	}

//	@GetMapping("/read/{id}")
//	public Todo readTodo(@PathVariable("id") Long id) {
//		return todoList.get(id.intValue());
//	}

	@GetMapping("/read/{id}")
	public ResponseEntity<TodoDTO> readTodo(@PathVariable("id") Long id) {
		return new ResponseEntity<TodoDTO>(this.service.readTodo(id), HttpStatus.ACCEPTED);
	}

	// POST= CREATE

//	@PostMapping("/create")
//	public boolean createTodo(@RequestBody Todo todo) {
//		todo.setId(id);
//		id++;
//		
//		return todoList.add(todo);
//	}

	@PostMapping("/create")
	public ResponseEntity<TodoDTO> createTodo(@RequestBody Todo todo) {
		return new ResponseEntity<TodoDTO>(this.service.createTodo(todo), HttpStatus.CREATED);
	}

	// PUT = UPDATE
//	@PutMapping("/update/{id}")
//	public Todo updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
//		this.todoList.remove(id.intValue());
//		this.todoList.add(id.intValue(), todo);
//		return this.todoList.get(id.intValue());
//	}

	@PutMapping("/update/{id}")
	public ResponseEntity <TodoDTO> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
		return new ResponseEntity<TodoDTO>(this.service.updateTodo(id, todo), HttpStatus.ACCEPTED);
	}

	// DELETE
//	@DeleteMapping("/delete/{id}")
//	public Todo deleteTodo(@PathVariable("id") Long id) {
//		return todoList.remove(id.intValue());
//	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTodo(@PathVariable("id") Long id) {
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT): 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
