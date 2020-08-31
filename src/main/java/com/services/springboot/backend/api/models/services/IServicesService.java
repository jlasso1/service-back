package com.services.springboot.backend.api.models.services;

import java.util.List;

import com.services.springboot.backend.api.model.entity.Service;

public interface IServicesService {
	
	public List<Service> findAll();
	
	public Service findById(Long id);
	
	public Service save(Service service);
	
	public void delete(Long id);


}
