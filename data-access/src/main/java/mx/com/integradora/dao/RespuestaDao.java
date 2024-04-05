package mx.com.integradora.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.com.integradora.model.entity.PreguntaEntity;
import mx.com.integradora.model.entity.RespuestaEntity;

public interface RespuestaDao extends CrudRepository<RespuestaEntity, Long>{

	@Query(value = "SELECT hme_pregunta_respuesta.id_persona, hme_pregunta_respuesta.id_pregunta, hme_pregunta_respuesta.id_pregunta_respuesta, hme_pregunta_respuesta.respuesta FROM HME_EXPEDIENTE "
			+ "INNER JOIN hme_pregunta_respuesta on "
			+ "hme_pregunta_respuesta.id_persona = HME_EXPEDIENTE.ID_USUARIO WHERE HME_EXPEDIENTE.ID_USUARIO = ?1", nativeQuery = true)
	List<RespuestaEntity> consutlarHistorial(Long ID_USUARIO);
}
