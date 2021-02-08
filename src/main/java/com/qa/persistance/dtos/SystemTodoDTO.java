package com.qa.persistance.dtos;

public class SystemTodoDTO {
	
private Long id;
	
	private String objective;

	public SystemTodoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemTodoDTO(Long id, String objective) {
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

}
