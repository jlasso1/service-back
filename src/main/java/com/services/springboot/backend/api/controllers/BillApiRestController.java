package com.services.springboot.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.services.springboot.backend.api.model.entity.Factura;
import com.services.springboot.backend.api.models.services.FacturaServiceImpl;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class BillApiRestController{
	
	@Autowired
	private FacturaServiceImpl facturaS;
	
	@GetMapping("/facturas")
	public List<Factura> index(){
		return facturaS.findAll();
	}
	
	@GetMapping("/facturas/{id}")
	public Factura show(@PathVariable Long id) {
		return facturaS.findById(id);
	}
	
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura create(@RequestBody Factura miFactura) {
		return facturaS.save(miFactura);
	}
	
	/**@PutMapping("/clientes/{id}")
	public Client update(@RequestBody Client miCliente, @PathVariable Long id) {
		Client clienteActual = clienteS.findById(id);
		clienteActual.setNombre(miCliente.getNombre());
		clienteActual.setCelular(miCliente.getCelular());
		
		return clienteS.save(clienteActual);
	}*/
	
	@DeleteMapping("/facturas/{id}")
	public void delete(@PathVariable Long id) {
		facturaS.delete(id);
	}

}
