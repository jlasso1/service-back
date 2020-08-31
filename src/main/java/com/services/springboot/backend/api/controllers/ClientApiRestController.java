package com.services.springboot.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.services.springboot.backend.api.model.entity.Client;
import com.services.springboot.backend.api.models.services.ClientServiceImpl;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClientApiRestController {
	
	@Autowired
	private ClientServiceImpl clienteS;
	
	@GetMapping("/clientes")
	public List<Client> index(){
		return clienteS.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Client show(@PathVariable Long id) {
		return clienteS.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client miCliente) {
		return clienteS.save(miCliente);
	}
	
	@PutMapping("/clientes/{id}")
	public Client update(@RequestBody Client miCliente, @PathVariable Long id) {
		Client clienteActual = clienteS.findById(id);
		clienteActual.setNombre(miCliente.getNombre());
		clienteActual.setCelular(miCliente.getCelular());
		
		return clienteS.save(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void delete(@PathVariable Long id) {
		clienteS.delete(id);
	}

}
