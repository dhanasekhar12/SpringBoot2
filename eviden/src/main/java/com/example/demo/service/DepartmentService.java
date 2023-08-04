package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Department;


public interface DepartmentService {
	public Department saveDepartment(Department department);
    public Optional<Department> getDepartmentById(Long id);
    public List<Department> getAllDepartment();
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
    
    
}
