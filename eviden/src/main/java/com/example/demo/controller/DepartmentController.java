package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Optional;

@RestController
@JsonPropertyOrder
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService; 

    
    @PostMapping("/addDept")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }
        
    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
     
    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }
        
    @PutMapping("/updateDept/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }
      
    @DeleteMapping("/deleteDept/{id}")
    public void deleteDepartment(@PathVariable Long id){
    	departmentService.deleteDepartment(id);
    }
    
    
}
  

