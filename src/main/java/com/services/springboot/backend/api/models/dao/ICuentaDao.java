package com.services.springboot.backend.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.services.springboot.backend.api.model.entity.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Long> {

}
