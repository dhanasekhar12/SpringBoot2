package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.model.ManagerId;
import com.example.demo.service.ManagerIdService;

@SpringBootTest
public class ManagerIdControllerTest {

    @Mock
    private ManagerIdService managerIdService;

    @InjectMocks
    private ManagerIdController managerIdController;

    @Test
    public void testGetAllManager_Positive() {
        // Prepare mock data
        ManagerId manager1 = new ManagerId("hr");
        ManagerId manager2 = new ManagerId("dev");
        List<ManagerId> mockManager = new ArrayList<>();
        mockManager.add(manager1);
        mockManager.add(manager2);

        
        when(managerIdService.getAllManager()).thenReturn(mockManager);

        
        List<ManagerId> result = managerIdController.getAllManager();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size()); 
        assertEquals(manager1, result.get(0)); 
        assertEquals(manager2, result.get(1)); 
    }
    
    
    @Test
    public void testGetAllManager_Negative() {
        when(managerIdService.getAllManager()).thenReturn(new ArrayList<>());
        List<ManagerId> result = managerIdController.getAllManager();
        assertNotNull(result);
        assertTrue(result.isEmpty()); 
    }
}



