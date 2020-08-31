package com.services.springboot.backend.api.models.services;

import java.util.List;

import com.services.springboot.backend.api.model.entity.Client;
import com.services.springboot.backend.api.model.entity.Factura;

public interface IFacturaService {
	
	public List<Factura> findAll();
	
	public Factura findById(Long id);
	
	public Factura save(Factura factura);
	
	public void delete(Long id);

}
