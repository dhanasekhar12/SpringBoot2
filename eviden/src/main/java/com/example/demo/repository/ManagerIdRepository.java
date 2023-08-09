package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.example.demo.model.ManagerId;

@EnableJpaRepositories
public interface ManagerIdRepository extends JpaRepository<ManagerId, Long> {

}
