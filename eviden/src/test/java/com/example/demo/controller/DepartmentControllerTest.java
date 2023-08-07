package com.example.demo.controller;


import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

public class DepartmentControllerTest {

    @Mock
    private DepartmentService departmentService;

    @InjectMocks
    private DepartmentController departmentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
//add department positive
    @Test
    public void testSaveDepartment_PositiveScenario() {
        Department newDepartment = new Department("hr");
        Department savedDepartment = new Department("tester");
        
        when(departmentService.saveDepartment(any(Department.class))).thenReturn(savedDepartment);

        ResponseEntity<Department> responseEntity = departmentController.saveDepartment(newDepartment);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(savedDepartment, responseEntity.getBody());
    }
    
  //add department negative
    @Test
    public void testSaveDepartment_NegativeScenario_Failure() {
        Department newDepartment = new Department("hr");
        
        when(departmentService.saveDepartment(any(Department.class))).thenReturn(null);

        ResponseEntity<Department> responseEntity = departmentController.saveDepartment(newDepartment);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
    
    //get all departments positive
    @Test
    public void testGetAllDepartment_PositiveScenario() {
        List<Department> departments = Arrays.asList(
            new Department("developer"),
            new Department("tester")
        );
        
        when(departmentService.getAllDepartment()).thenReturn(departments);

        List<Department> result = departmentController.getAllDepartment();

        assertEquals(departments, result);
    }
    
  //get all departments negative
    @Test
    public void testGetAllDepartment_NegativeScenario_EmptyList() {
        when(departmentService.getAllDepartment()).thenReturn(Collections.emptyList());

        List<Department> result = departmentController.getAllDepartment();

        assertTrue(result.isEmpty());
    }
    
    
    //get all departments by id positive
    @Test
    public void testGetDepartmentById_PositiveScenario() {
        Long departmentId = 1L;
        Department department = new Department("developer");
        
        when(departmentService.getDepartmentById(departmentId)).thenReturn(Optional.of(department));

        Optional<Department> result = departmentController.getDepartmentById(departmentId);

        assertTrue(result.isPresent());
        assertEquals(department, result.get());
    }
    
  //get all departments by id negative
    @Test
    public void testGetDepartmentById_NegativeScenario_NotFound() {
        Long nonExistentDepartmentId = 999L;
        
        when(departmentService.getDepartmentById(nonExistentDepartmentId)).thenReturn(Optional.empty());

        Optional<Department> result = departmentController.getDepartmentById(nonExistentDepartmentId);

        assertFalse(result.isPresent());
    }
    
    //update department by id positive
    @Test
    public void testUpdateDepartment_PositiveScenario() {
        Long departmentId = 1L;
        Department updatedDepartment = new Department("cloud");
        
        when(departmentService.updateDepartment(eq(departmentId), any(Department.class))).thenReturn(updatedDepartment);

        Department result = departmentController.updateDepartment(departmentId, updatedDepartment);

        assertEquals(updatedDepartment, result);
    }
    
    
  //update department by id negative
    
    @Test
    public void testUpdateDepartment_NegativeScenario_Failure() {
        Long departmentId = 1L;
        Department updatedDepartment = new Department("sales");
        
        when(departmentService.updateDepartment(eq(departmentId), any(Department.class))).thenReturn(null);

        Department result = departmentController.updateDepartment(departmentId, updatedDepartment);

        assertNull(result);
    }
    //delete department positive
    @Test
    public void testDeleteDepartment_PositiveScenario() {
        Long departmentId = 1L;
        
        // Mock the service method to simulate successful deletion
        doNothing().when(departmentService).deleteDepartment(departmentId);

        // Call the controller method
        departmentController.deleteDepartment(departmentId);

        // Verify that the service method was called once
        verify(departmentService, times(1)).deleteDepartment(departmentId);
    }
    
  //delete department negative
    @Test
    public void testDeleteDepartment_NegativeScenario_Failure() {
        Long departmentId = 1L;
        
        // Mock the service method to simulate a failure
        doThrow(new RuntimeException("Failed to delete department")).when(departmentService).deleteDepartment(departmentId);

        // Call the controller method and expect an exception
        assertThrows(RuntimeException.class, () -> departmentController.deleteDepartment(departmentId));

        // Verify that the service method was called once
        verify(departmentService, times(1)).deleteDepartment(departmentId);
    }
}

