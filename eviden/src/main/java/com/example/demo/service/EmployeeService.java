package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
    public Optional<Employee> getEmployeeById(Long id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getAllManagers();
    List<Employee> findByManagerIdNotNull();
}
