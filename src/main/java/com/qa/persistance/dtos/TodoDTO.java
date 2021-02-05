package com.qa.persistance.dtos;

import java.util.Date;

public class TodoDTO {

	private Long id;

	private String title;
	private String description;
	private Date date;
	private boolean finish;

	public TodoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TodoDTO(Long id, String title, String description, Date date, boolean finish) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.finish = finish;
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

}
