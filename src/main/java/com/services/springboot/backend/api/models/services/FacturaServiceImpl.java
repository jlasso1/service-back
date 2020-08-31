package com.services.springboot.backend.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.services.springboot.backend.api.model.entity.Client;
import com.services.springboot.backend.api.model.entity.Factura;
import com.services.springboot.backend.api.models.dao.IClientDao;
import com.services.springboot.backend.api.models.dao.IFacturaDao;

@Service
public class FacturaServiceImpl implements IFacturaService{
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		
		return (List<Factura>) facturaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facturaDao.deleteById(id);
	}
	
	

}
