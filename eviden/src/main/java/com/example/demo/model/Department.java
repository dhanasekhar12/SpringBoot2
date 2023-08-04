package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;
    private String deptName;
    
 
	public Department() {
	
	}


	public Department(String deptName) {
		super();
		
		this.deptName = deptName;
	}


	
	public Long getDeptId() {
		return deptId;
	}


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

	
}

