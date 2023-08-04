package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired(required=true)
    private DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;

	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public List<Department> getAllDepartment() {
		
		return departmentRepository.findAll(Sort.by(Sort.Direction.DESC, "deptId"));
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department departmentToUpdate = departmentRepository.findById(id).orElseThrow();
		departmentToUpdate.setDeptName(department.getDeptName());
        
        //employeeToUpdate.setEmpDob(employee.getEmpDob());
        
        
        return departmentRepository.save(departmentToUpdate);
	}

	@Override
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
		
		
	}


}

