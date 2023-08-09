package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 
@Entity

public class ManagerId {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    

    private Long managerId;

    private String manager_name;

    public ManagerId() {

    }

    public ManagerId(String manager_name) {

        super();

        

        this.manager_name = manager_name;

    }

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	
    
}

