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
import com.services.springboot.backend.api.model.entity.Service;
import com.services.springboot.backend.api.models.services.ClientServiceImpl;
import com.services.springboot.backend.api.models.services.ServicesServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ServiceApiRestController {
	
	@Autowired
	private ServicesServiceImpl serviceS;
	
	@GetMapping("/services")
	public List<Service> index(){
		return serviceS.findAll();
	}
	
	@GetMapping("/services/{id}")
	public Service show(@PathVariable Long id) {
		return serviceS.findById(id);
	}
	
	@PostMapping("/services")
	@ResponseStatus(HttpStatus.CREATED)
	public Service create(@RequestBody Service service) {
		return serviceS.save(service);
	}
	
	@PutMapping("/services/{id}")
	public Service update(@RequestBody Service miService, @PathVariable Long id) {
		Service sActual = serviceS.findById(id);
		sActual.setNombre(miService.getNombre());
		sActual.setCosto(miService.getCosto());
		
		return serviceS.save(sActual);
	}
	
	@DeleteMapping("/services/{id}")
	public void delete(@PathVariable Long id) {
		serviceS.delete(id);
	}

}
