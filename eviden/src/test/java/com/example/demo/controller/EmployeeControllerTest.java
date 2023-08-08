package com.example.demo.controller;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import java.util.Optional;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;
    
    //@Mock
    //private DepartmentService DepartmentService;

    //@InjectMocks
    //private DepartmentController DepartmentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    
    //get employee by id positive
    @Test
    public void testGetEmployeeById_Positive() {
        Long empId = 1L;
        Employee mockEmployee = new Employee();
        mockEmployee.setEmp_name("suri");
        mockEmployee.setEmp_dob(new Date(1993-03-04));
        mockEmployee.setDepartment(2L);
        mockEmployee.setSalary(50000.0);
        mockEmployee.setManagerId(123L);
        mockEmployee.setMobile("1234567890");
        
        when(employeeService.getEmployeeById(empId)).thenReturn(Optional.of(mockEmployee));

        Optional<Employee> result = employeeController.getEmployeeById(empId);

        assertTrue(result.isPresent());
        assertEquals(mockEmployee, result.get());
    }
    
    
    //get employee by id negative
    @Test
    public void testGetEmployeeById_Negative() {
        Long nonExistentEmployeeId = 999L;
        
        
        when(employeeService.getEmployeeById(nonExistentEmployeeId)).thenReturn(Optional.empty());

        Optional<Employee> result = employeeController.getEmployeeById(nonExistentEmployeeId);

        assertFalse(result.isPresent());
        //assertEquals(nonExistentEmployeeId, result.get());
    }
    //get all employes positive
    @Test
    public void testGetAllEmployee_Positive() {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee("suri", new Date(1993-03-04), 2L, 50000.0, 123L, "1234567890"));
        mockEmployees.add(new Employee("shiva", new Date(1980-06-05), 2L, 60000.0, 1L, "9876543210"));
        
        when(employeeService.getAllEmployee()).thenReturn(mockEmployees);

        List<Employee> result = employeeController.getAllEmployee();

        assertEquals(mockEmployees, result);
    }
    
    
    //get all employees negative
   
    @Test
    public void testGetAllEmployee_Negative_EmptyList() {
        when(employeeService.getAllEmployee()).thenReturn(Collections.emptyList());

        List<Employee> result = employeeController.getAllEmployee();

        assertTrue(result.isEmpty());
    }
    
    //update employee positive
    @Test
    public void testUpdateEmployee_Positive() {
        Long employeeId = 1L;
        /* Set updated employee details */
        Employee updatedEmployee = new Employee("reddi", new Date(1995-02-02), 89l, 60000.0, 1L, "776567544");
        
        when(employeeService.updateEmployee(eq(employeeId), any(Employee.class))).thenReturn(updatedEmployee);

        Employee result = employeeController.updateEmployee(employeeId, updatedEmployee);

        assertEquals(updatedEmployee, result);
    }
    
    //update employee negative
    @Test
    public void testUpdateEmployee_Negative_Failure() {
        Long employeeId = 1L;
        Employee updatedEmployee = new Employee("prasad",new Date(1995-06-05), 12L, 70000.0, 1L, "889567544");
        
        when(employeeService.updateEmployee(eq(employeeId), any(Employee.class))).thenReturn(null);

        Employee result = employeeController.updateEmployee(employeeId, updatedEmployee);

        assertNull(result);
    }
    
    //delete employee positive
    @Test
    public void testDeleteEmployee_Positive() {
        Long employeeId = 1L;

        doNothing().when(employeeService).deleteEmployee(employeeId);

        employeeController.deleteEmployee(employeeId);

        verify(employeeService, times(1)).deleteEmployee(employeeId);
    }
    
    //delete employee negative
    @Test
    public void testDeleteEmployee_NegativeScenario_Failure() {
        Long invalidEmployeeId = 99L;

        doThrow(new RuntimeException("Failed to delete employee")).when(employeeService).deleteEmployee(invalidEmployeeId);

        assertThrows(RuntimeException.class, () -> employeeController.deleteEmployee(invalidEmployeeId));

        verify(employeeService, times(1)).deleteEmployee(invalidEmployeeId);
    }
    
    
  //add employee positive
    @Test
    public void testAddEmployee_PositiveScenario() {
    	Employee newEmployee = new Employee();
    	newEmployee.setEmp_name("Dhana");
    	newEmployee.setEmp_dob(new Date(1993-03-04));
    	newEmployee.setDepartment(2L);
    	newEmployee.setSalary(50000.0);
    	newEmployee.setManagerId(23L);
    	newEmployee.setMobile("1234567890");
        

        when(employeeService.saveEmployee(any(Employee.class))).thenReturn(newEmployee);

        ResponseEntity<Employee> response = employeeController.saveEmployee(newEmployee);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newEmployee, response.getBody());
    }

    


   //add employee negative
    @Test
    public void testSaveEmployee_NegativeScenario() {
        Employee newEmployee = new Employee(  );
        newEmployee.setEmp_name("Dhana");
    	newEmployee.setEmp_dob(new Date(1993-03-04));
    	newEmployee.setDepartment(2L);
    	newEmployee.setSalary(50000.0);
    	newEmployee.setManagerId(22L);
    	newEmployee.setMobile("1234567890");

        when(employeeService.saveEmployee(newEmployee)).thenReturn(null);

        ResponseEntity<Employee> response = employeeController.saveEmployee(newEmployee);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }
    
    

}


