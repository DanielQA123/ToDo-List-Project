package com.qa.persistance.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class TodoSystemDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String objective;
	
	@OneToMany(mappedBy = "theTodo", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<TodoDomain> todoList;

	public TodoSystemDomain() {
		super();
	}

	public TodoSystemDomain(Long id, String objective, List<TodoDomain> todoList) {
		super();
		this.id = id;
		this.objective = objective;
		this.todoList = todoList;
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

	public List<TodoDomain> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<TodoDomain> todoList) {
		this.todoList = todoList;
	}
	
	

	
	
	

}
