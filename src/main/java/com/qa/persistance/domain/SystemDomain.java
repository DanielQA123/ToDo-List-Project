package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String objective;

	public SystemDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemDomain(Long id, String objective) {
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
