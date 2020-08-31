package com.services.springboot.backend.api.models.services;

import java.util.List;

import com.services.springboot.backend.api.model.entity.Client;
import com.services.springboot.backend.api.model.entity.Cuenta;

public interface ICuentaService {
	
	public List<Cuenta> findAll();
	
	public Cuenta findById(Long id);
	
	public Cuenta save(Cuenta cuenta);
	
	public void delete(Long id);

}
