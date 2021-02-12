package com.qa.persistance.domain;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TodoDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String title;

//	@Size(min = 15, message="Enter Your Objectives")

	@NotNull
	private String description;

	@NotNull
	private Date date;
	private boolean finish;

	@ManyToOne
	private TodoSystemDomain theTodo;

	// Creating Constructor
	// No Args:

	public TodoDomain() {
		super();
	}

	public TodoDomain(Long id, String title, String description, Date date, boolean finish,
			TodoSystemDomain theTodo) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.finish = finish;
		this.theTodo = theTodo;
	}

	public TodoDomain(String title, String description, Date date, boolean finish,
			TodoSystemDomain theTodo) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.finish = finish;
		this.theTodo = theTodo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public TodoSystemDomain getTheTodo() {
		return theTodo;
	}

	public void setTheTodo(TodoSystemDomain theTodo) {
		this.theTodo = theTodo;
	}

}
