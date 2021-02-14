package com.qa.persistance.dtos;

import java.util.List;

public class TodoSystemDTO {
	
    private Long id;
	
	private String objective;

	private List<TodoDTO> todoList;
	
	public TodoSystemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TodoSystemDTO(Long id, String objective, List<TodoDTO> todoList) {
		super();
		this.id = id;
		this.objective = objective;
		this.todoList = todoList;
	}

	public TodoSystemDTO(Long id, String objective) {
		super();
		this.id = id;
		this.objective = objective;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public List<TodoDTO> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<TodoDTO> todoList) {
		this.todoList = todoList;
	}
	
	
}


	