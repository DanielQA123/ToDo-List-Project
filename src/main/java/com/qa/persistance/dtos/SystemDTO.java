package com.qa.persistance.dtos;

public class SystemDTO {
	
private Long id;
	
	private String objective;

	public SystemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemDTO(Long id, String objective) {
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
