package com.example.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
}
