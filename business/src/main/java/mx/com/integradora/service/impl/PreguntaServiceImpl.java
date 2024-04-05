package mx.com.integradora.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.integradora.dao.ExpedienteDao;
import mx.com.integradora.dao.PreguntaDao;
import mx.com.integradora.dao.RespuestaDao;
import mx.com.integradora.model.dto.PreguntaDto;
import mx.com.integradora.model.dto.RespuestaDto;
import mx.com.integradora.model.entity.ExpedienteEntity;
import mx.com.integradora.model.entity.PreguntaEntity;
import mx.com.integradora.model.entity.RespuestaEntity;
import mx.com.integradora.model.exception.IntegradoraException;
import mx.com.integradora.service.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService{

	private static final Logger LOGGER = LogManager.getLogger(PersonaServiceImpl.class);
	
	@Autowired
	private PreguntaDao preguntaDao;
	@Autowired
	private ExpedienteDao expedienteDao;
	@Autowired
	private RespuestaDao respuestaDao;
	
	
	public Long guardarPregunta(PreguntaDto preguntaDto) throws IntegradoraException {
		Long idPregunta = null;
		PreguntaEntity preguntaEntity;
		try {
			if (preguntaDto != null) {

				preguntaEntity = new PreguntaEntity();
				preguntaEntity.setIdTipoEnfermedad(preguntaDto.getIdTipoEnfermedad());
				preguntaEntity.setDescripcion(preguntaDto.getDescripcion());
				
				preguntaDao.save(preguntaEntity);

				idPregunta = preguntaEntity.getIdPregunta();
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return idPregunta;
	}
	
	public List<PreguntaDto> consultarPreguntas() throws IntegradoraException {
		List<PreguntaDto> listaDto = null;
		Iterable<PreguntaEntity> listaEntity;
		PreguntaDto preguntaDto;

		try {
			listaEntity = preguntaDao.findAll();

			if (listaEntity != null) {

				listaDto = new ArrayList<PreguntaDto>();

				for (PreguntaEntity entity : listaEntity) {

					preguntaDto = new PreguntaDto();
					preguntaDto.setIdPregunta(entity.getIdPregunta());
					preguntaDto.setIdTipoEnfermedad(entity.getIdTipoEnfermedad());
					preguntaDto.setDescripcion(entity.getDescripcion());

					listaDto.add(preguntaDto);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return listaDto;
	}
	
	public List<RespuestaDto> consultaHistorial(long idPersona) throws IntegradoraException {
		ExpedienteEntity expediente;
		List<RespuestaDto> listaDto = null;
		List<RespuestaEntity> historial;
		RespuestaDto respuestaDto = null ;
		
		try {
			if (idPersona != 0) {
				expediente = expedienteDao.existeHistorial(idPersona);
				if (expediente != null) {
					historial = respuestaDao.consutlarHistorial(idPersona);
					if (!historial.isEmpty()) {
						listaDto = new ArrayList<RespuestaDto>();
						for (RespuestaEntity preguntaEntity2 : historial) {
							respuestaDto = new RespuestaDto();
							respuestaDto.setIdPregunta(preguntaEntity2.getIdPregunta());
							respuestaDto.setRespuesta(preguntaEntity2.getRespuesta());
							respuestaDto.setIdRespuesta(preguntaEntity2.getIdRespuesta());
							respuestaDto.setIdPersona(preguntaEntity2.getIdPersona());
							listaDto.add(respuestaDto);
						}
					}
				}
		
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return listaDto;
	}

//	public PreguntaDto consultarPersonaPorId(long idPersona) throws IntegradoraException {
//		PreguntaDto pregutnaDto = null;
//		Optional<PreguntaEntity> preguntaEntity;
//
//		try {
//			personaEntity = personaDao.findById(idPersona);
//
//			if (personaEntity.isPresent()) {
//
//				preguntaDto = new PreguntaDto();
//				preguntaDto.setIdPregunta(entity.getIdPregunta());
//				preguntaDto.setIdTipoEnfermedad(entity.getIdTipoEnfermedad());
//				preguntaDto.setDescripcion(entity.getDescripcion());
//			}
//
//		} catch (Exception e) {
//			LOGGER.error(e);
//		}
//		return personaDto;
//	}
//
//	public boolean actualizarPersona(PersonaDto personaDto) throws IntegradoraException {
//		boolean resultado = false;
//		Optional<PersonaEntity> personaEntity;
//
//		try {
//			if (personaDto != null) {
//				personaEntity = personaDao.findById(personaDto.getIdPersona());
//
//				if (personaEntity.isPresent()) {
//
//					if (personaDto.getNombre() != null) {
//						personaEntity.get().setNombre(personaDto.getNombre());
//					}
//					if (personaDto.getApellidoPaterno() != null) {
//						personaEntity.get().setApellidoPaterno(personaDto.getApellidoPaterno());
//					}
//					if (personaDto.getApellidoMaterno() != null) {
//						personaEntity.get().setApellidoMaterno(personaDto.getApellidoMaterno());
//					}
//					personaEntity.get().setEstatus(personaDto.getEstatus());
//
//					if (personaDto.getFechaRegistro() != null) {
//						personaEntity.get().setFechaRegistro(personaDto.getFechaRegistro());
//					}
//					personaDao.save(personaEntity.get());
//					resultado = true;
//				}
//			}
//		} catch (Exception e) {
//			LOGGER.error(e);
//		}
//		return resultado;
//	}

	public boolean eliminarPersona(long idPregunta) throws IntegradoraException {
		boolean resultado = false;
		Optional<PreguntaEntity> entity;

		try {
			entity = preguntaDao.findById(idPregunta);

			if (entity.isPresent()) {
				preguntaDao.delete(entity.get());
				resultado = true;
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return resultado;
	}
}
