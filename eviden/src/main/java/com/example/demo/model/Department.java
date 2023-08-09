package com.example.demo.model;

//import java.util.List;
//import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long deptId;
    private String dept_name;
    public Department() {

    }

    public Department(String dept_name) {

        super();
        this.dept_name = dept_name;

    }


    public Long getDeptId() {
    	return deptId;

    }

    public void setDeptId(Long deptId) {
    	this.deptId = deptId;

    }

    public String getDept_name() {
    	return dept_name;

    }


    public void setDept_name(String dept_name) {
    	this.dept_name = dept_name;

    }

    @Override
    public String toString() {

        return "Department [deptId=" + deptId + ", dept_name=" + dept_name + "]";

    }

}

