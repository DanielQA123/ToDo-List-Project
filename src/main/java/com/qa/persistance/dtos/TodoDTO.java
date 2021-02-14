package com.qa.persistance.dtos;

import java.sql.Date;

public class TodoDTO {

	private Long id;

	private String title;
	private String description;
	private Date date;
	private boolean done;

	public TodoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TodoDTO(String title, String description, Date date, boolean done) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.done = done;
	}



	public TodoDTO(Long id, String title, String description, Date date, boolean done) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.done = done;
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

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
