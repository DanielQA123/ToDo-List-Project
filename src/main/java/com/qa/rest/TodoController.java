package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistance.domain.Todo;

@RestController
@RequestMapping("/todo")
public class TodoController {

	private List<Todo> todoList = new ArrayList<>();

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world";
	}

	// GET

	@GetMapping("/getTodo")
	public List<Todo> readAll() {
		return todoList;
	}

	// POST= CREATE

	@PostMapping("/create")
	public boolean createTodo(@RequestBody Todo todo) {
		return todoList.add(todo);
	}

	// PUT = UPDATE
	@PutMapping("/update/{id}")
	public Todo updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
		this.todoList.remove(id.intValue());
		this.todoList.add(id.intValue(), todo);
		return this.todoList.get(id.intValue());
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public Todo deleteTodo(@PathVariable("id") Long id) {
		return todoList.remove(id.intValue());
	}

}
