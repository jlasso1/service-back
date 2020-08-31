package com.services.springboot.backend.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.services.springboot.backend.api.model.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

}
