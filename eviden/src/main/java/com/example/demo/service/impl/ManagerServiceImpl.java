package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ManagerId;
import com.example.demo.repository.ManagerIdRepository;
import com.example.demo.service.ManagerIdService;



@Service
public class ManagerServiceImpl implements ManagerIdService{
	
	@Autowired(required=true)
    private ManagerIdRepository managerIdRepository;
	
	public ManagerServiceImpl(ManagerIdRepository managerIdRepository) {
		super();
		this.managerIdRepository = managerIdRepository;

	}

	@Override
	public List<ManagerId> getAllManager() {
		// TODO Auto-generated method stub
		return managerIdRepository.findAll(Sort.by(Sort.Direction.DESC, "managerId"));
	}
}