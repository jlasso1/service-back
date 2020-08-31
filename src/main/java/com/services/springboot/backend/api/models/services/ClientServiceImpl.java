package com.services.springboot.backend.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.services.springboot.backend.api.model.entity.Client;
import com.services.springboot.backend.api.models.dao.IClientDao;

@Service
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private IClientDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		
		return (List<Client>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client save(Client cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}
