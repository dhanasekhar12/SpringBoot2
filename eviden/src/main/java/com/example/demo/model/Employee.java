package com.example.demo.model;

import java.util.Date;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

 

@Entity

 
@Table(name="employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empName;
    private Date empDob;
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;
    private Double salary;
    private Long managerId;
    private String mobile;
    public Long getId() {
        return id;
    }
    
public Employee() {
		
	}
    
    
    public Employee(String empName, Date empDob, Department department, Double salary, Long managerId,
		String mobile) {
	super();
	
	this.empName = empName;
	this.empDob = empDob;
	this.department = department;
	this.salary = salary;
	this.managerId = managerId;
	this.mobile = mobile;
}

	public void setEmpId(Long id) {
        this.id = id;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public Date getEmpDob() {
        return empDob;
    }
    public void setEmpDob(Date empDob) {
        this.empDob = empDob;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Long getManagerId() {
        return managerId;
    }
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}