package com.services.springboot.backend.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.services.springboot.backend.api.model.entity.Client;
import com.services.springboot.backend.api.model.entity.Service;
import com.services.springboot.backend.api.models.dao.IClientDao;
import com.services.springboot.backend.api.models.dao.IServiceDao;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements IServicesService{
	
	@Autowired
	private IServiceDao serviceDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Service> findAll() {
		return (List<Service>) serviceDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Service findById(Long id) {
		return serviceDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Service save(Service service) {
		return serviceDao.save(service);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		serviceDao.deleteById(id);
	}

}
