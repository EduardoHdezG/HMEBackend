package mx.com.integradora.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import mx.com.integradora.model.entity.ExpedienteEntity;
import mx.com.integradora.model.entity.RespuestaEntity;

public interface ExpedienteDao extends CrudRepository<ExpedienteEntity, Long>{
	@Query(value = "SELECT * FROM HME_EXPEDIENTE WHERE ID_USUARIO = ?1", nativeQuery = true)
	ExpedienteEntity existeHistorial(Long ID_USUARIO);


}
