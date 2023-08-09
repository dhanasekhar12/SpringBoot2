package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ManagerId;
import com.example.demo.service.ManagerIdService;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;


@RestController
@JsonPropertyOrder
@RequestMapping("/api")
public class ManagerIdController {

    @Autowired
    private ManagerIdService managerIdService; 
    
    
    @GetMapping("/managerr")
    public List<ManagerId> getAllManager(){
        return managerIdService.getAllManager();
    }
}