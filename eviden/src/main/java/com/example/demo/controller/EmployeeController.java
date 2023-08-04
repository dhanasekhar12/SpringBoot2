package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; 

    
    @PostMapping("/addemployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
        
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
     
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
        
    @PutMapping("/updateEmp/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
      
    @DeleteMapping("/deleteemp/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
    
    @GetMapping("/managers")
    public List<Employee> getAllManagers() {
        return employeeService.findByManagerIdNotNull();
    }
}
  

