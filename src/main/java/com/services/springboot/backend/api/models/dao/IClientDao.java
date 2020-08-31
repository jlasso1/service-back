package com.services.springboot.backend.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.services.springboot.backend.api.model.entity.Client;

public interface IClientDao extends CrudRepository<Client, Long>{

}
