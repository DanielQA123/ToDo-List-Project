package com.qa.persistance.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title; 
	
	@Size(min = 15, message="Enter Your Objectives")
	private String description;
	private Date date;
	private boolean finish;
	
	//Creating Constructor
	//No Args: 
	
	public Todo() {
		super();
	}

	//With Args: 
	public Todo(Long id, String title, @Size(min = 15, message = "Enter Your Objectives") String description, Date date,
			boolean finish) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.finish = finish;
	}

	//Method => Getters and Setters
	
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
	
	
	
	
	
	
	
	
	
	
}
