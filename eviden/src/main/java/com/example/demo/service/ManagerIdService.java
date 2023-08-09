package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.ManagerId;

import lombok.AllArgsConstructor;


@Service
@Component
@AllArgsConstructor
public interface ManagerIdService {
	
	public List<ManagerId> getAllManager();
}
