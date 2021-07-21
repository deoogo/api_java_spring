package com.example.ms.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms.model.Cliente;
import com.example.ms.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	// Ler os clientes
	@GetMapping("/cliente")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
		}
	
	// Consulta por ID
	@GetMapping("/cliente/{id}")
	public Cliente pegaClienteId(@PathVariable Long id) {
		return clienteRepository.findById(id).get();
		}
	
	// Insere cliente
	@PostMapping("/cliente")
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	// Remove cliente
	@DeleteMapping("/cliente/{id}")
	public void removeCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);

	}

}
