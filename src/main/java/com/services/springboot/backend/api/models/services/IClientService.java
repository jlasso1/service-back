package com.services.springboot.backend.api.models.services;

import java.util.List;

import com.services.springboot.backend.api.model.entity.Client;

public interface IClientService {
	
	public List<Client> findAll();
	
	public Client findById(Long id);
	
	public Client save(Client cliente);
	
	public void delete(Long id);

}
