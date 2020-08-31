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
import com.services.springboot.backend.api.model.entity.Cuenta;
import com.services.springboot.backend.api.models.services.ClientServiceImpl;
import com.services.springboot.backend.api.models.services.CuentaServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AccountApiRestController {
	
	@Autowired
	private CuentaServiceImpl cuentaS;
	
	@GetMapping("/cuentas")
	public List<Cuenta> index(){
		return cuentaS.findAll();
	}
	
	@GetMapping("/cuentas/{id}")
	public Cuenta show(@PathVariable Long id) {
		return cuentaS.findById(id);
	}
	
	@PostMapping("/cuentas")
	@ResponseStatus(HttpStatus.CREATED)
	public Cuenta create(@RequestBody Cuenta miCuenta) {
		return cuentaS.save(miCuenta);
	}
	
	/**@PutMapping("/clientes/{id}")
	public Client update(@RequestBody Client miCliente, @PathVariable Long id) {
		Client clienteActual = clienteS.findById(id);
		clienteActual.setNombre(miCliente.getNombre());
		clienteActual.setCelular(miCliente.getCelular());
		
		return clienteS.save(clienteActual);
	}*/
	
	@DeleteMapping("/cuentas/{id}")
	public void delete(@PathVariable Long id) {
		cuentaS.delete(id);
	}

}
