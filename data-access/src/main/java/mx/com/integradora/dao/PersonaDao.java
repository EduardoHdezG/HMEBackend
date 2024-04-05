package mx.com.integradora.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.integradora.model.entity.PersonaEntity;

/**
 * DAO PersonaDao: De forma implicita, esta interface anota el estereotipo de Spring <Repository> 
 * y hereda los metodos genericos de CrudRepository, los cuales provee la misma interface.  
 */
public interface PersonaDao extends CrudRepository<PersonaEntity, Long> {

}
