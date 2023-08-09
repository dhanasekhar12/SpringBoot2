
package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
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
    private String emp_name;
    private Date emp_dob;
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;
    
    private Double salary;
    
    
    @ManyToOne
    @JoinColumn(name = "managerId")
    private ManagerId managerId;
    
    private String mobile;
    //@Column(name = "deptId", insertable = false, updatable = false)
	//private Long deptId;
    //private Long managerId;
    public Long getId() {
        return id;
    }
    
public Employee() {
		
	}
    

	public Employee(String emp_name, Date emp_dob, Department department, Double salary, ManagerId managerId,
		String mobile) {
	super();
	
	this.emp_name = emp_name;
	this.emp_dob = emp_dob;
	this.department = department;
	this.salary = salary;
	this.managerId = managerId;
	this.mobile = mobile;
}

	public void setEmpId(Long id) {
        this.id = id;
    }
    public String getEmp_name() {
        return emp_name;
    }
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }
    public Date getEmp_dob() {
        return emp_dob;
    }
    public void setEmp_dob(Date emp_dob) {
        this.emp_dob = emp_dob;
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
    public ManagerId getManagerId() {
        return managerId;
    }
    public void setManagerId(ManagerId managerId) {
        this.managerId = managerId;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

	

}