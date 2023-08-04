package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;




@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired(required=true)
    private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;

	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setEmpName(employee.getEmpName());
        
        employeeToUpdate.setEmpDob(employee.getEmpDob());
        employeeToUpdate.setSalary(employee.getSalary());
        employeeToUpdate.setMobile(employee.getMobile());
        employeeToUpdate.setDepartment(employee.getDepartment());
        employeeToUpdate.setManagerId(employee.getManagerId());
        
        return employeeRepository.save(employeeToUpdate);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
		
	}

	@Override
	public List<Employee> getAllManagers() {
		
		return employeeRepository.findByManagerIdNotNull();
	}

	@Override
	public List<Employee> findByManagerIdNotNull() {
		// TODO Auto-generated method stub
		return employeeRepository.findByManagerIdNotNull();
	}

}

