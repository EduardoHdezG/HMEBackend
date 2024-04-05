package mx.com.integradora.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.integradora.model.entity.EnfermedadEntity;

public interface EnfermedadDao extends CrudRepository<EnfermedadEntity, Long> {

}
