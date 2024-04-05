package mx.com.integradora.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.integradora.dao.DomicilioDao;
import mx.com.integradora.dao.ExpedienteDao;
import mx.com.integradora.dao.PersonaDao;
import mx.com.integradora.dao.RespuestaDao;
import mx.com.integradora.model.dto.DomicilioDto;
import mx.com.integradora.model.dto.PersonaDto;
import mx.com.integradora.model.dto.RespuestaDto;
import mx.com.integradora.model.entity.DomicilioEntity;
import mx.com.integradora.model.entity.ExpedienteEntity;
import mx.com.integradora.model.entity.PersonaEntity;
import mx.com.integradora.model.entity.PreguntaEntity;
import mx.com.integradora.model.entity.RespuestaEntity;
import mx.com.integradora.model.exception.IntegradoraException;
import mx.com.integradora.service.PersonaService;

/**
 * Servicio PersonaServiceImpl: Esta clase anota el estereotipo de Spring <Service> 
 * e impementa los metodos expuestos en su interface PersonaService. Invoca los operaciones
 * del DAO PersonaDao, heredadas de la interface CrudRepository.
 */
@Service
public class PersonaServiceImpl implements PersonaService {

	private static final Logger LOGGER = LogManager.getLogger(PersonaServiceImpl.class);
	
	@Autowired
	private PersonaDao personaDao;
	@Autowired
	private RespuestaDao respuestaDao;
	@Autowired
	private ExpedienteDao expedienteDao;
	@Autowired
	private DomicilioDao domicilioDao;

	public Long guardarPersona(PersonaDto personaDto) throws IntegradoraException {
		Long idPersona = null;
		PersonaEntity personaEntity;
		DomicilioEntity domicilioEntity;

		try {
			if (personaDto != null) {
				personaEntity = new PersonaEntity();
				personaEntity.setNombre(personaDto.getNombre());
				personaEntity.setApellidoPaterno(personaDto.getApellidoPaterno());
				personaEntity.setApellidoMaterno(personaDto.getApellidoMaterno());
				personaEntity.setEstatus(1);
				Date fecha = new java.util.Date();
				personaEntity.setFechaRegistro(fecha);
				personaEntity.setEstadoCivil(personaDto.getEstadoCivil());
				personaEntity.setSexo(personaDto.getSexo());
				personaEntity.setIdentificador(personaDto.getIdentificador());
				personaEntity.setTelefonoA(personaDto.getTelefonoA());
				personaEntity.setTelefonoC(personaDto.getTelefonoC());
				personaDao.save(personaEntity);

				idPersona = personaEntity.getIdPersona();
				
				if (idPersona != null) {
					domicilioEntity = new DomicilioEntity();
					domicilioEntity.setCalle(personaDto.getDomicilio().getCalle());
					domicilioEntity.setColonia(personaDto.getDomicilio().getColonia());
					domicilioEntity.setDetalle1(personaDto.getDomicilio().getDetalle1());
					domicilioEntity.setDetalle2(personaDto.getDomicilio().getDetalle2());
					domicilioEntity.setEntidad(personaDto.getDomicilio().getEntidad());
					domicilioEntity.setPersona(idPersona);
					domicilioDao.save(domicilioEntity);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return idPersona;
	}

	public List<PersonaDto> consultarPersonas() throws IntegradoraException {
		List<PersonaDto> listaPersonaDto = null;
		Iterable<PersonaEntity> listaPersonaEntity;
		PersonaDto personaDto;
		ExpedienteEntity expediente;

		try {
			listaPersonaEntity = personaDao.findAll();

			if (listaPersonaEntity != null) {

				listaPersonaDto = new ArrayList<PersonaDto>();

				for (PersonaEntity entity : listaPersonaEntity) {

					personaDto = new PersonaDto();
					personaDto.setIdPersona(entity.getIdPersona());
					personaDto.setApellidoPaterno(entity.getApellidoPaterno());
					personaDto.setApellidoMaterno(entity.getApellidoMaterno());
					personaDto.setNombre(entity.getNombre());
					personaDto.setEstatus(entity.getEstatus());
					personaDto.setFechaRegistro(entity.getFechaRegistro());
					personaDto.setIdentificador(entity.getIdentificador());

					if (personaDto.getIdPersona() != 0) {
						expediente = expedienteDao.existeHistorial(personaDto.getIdPersona());
						if (expediente != null) {
							personaDto.setHistorial(1);
						}else {
							personaDto.setHistorial(0);
						}
					}
					listaPersonaDto.add(personaDto);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return listaPersonaDto;
	}

	public PersonaDto consultarPersonaPorId(long idPersona) throws IntegradoraException {
		PersonaDto personaDto = null;
		Optional<PersonaEntity> personaEntity;

		try {
			personaEntity = personaDao.findById(idPersona);

			if (personaEntity.isPresent()) {

				personaDto = new PersonaDto();
				personaDto.setIdPersona(personaEntity.get().getIdPersona());
				personaDto.setApellidoPaterno(personaEntity.get().getApellidoPaterno());
				personaDto.setApellidoMaterno(personaEntity.get().getApellidoMaterno());
				personaDto.setNombre(personaEntity.get().getNombre());
				personaDto.setEstatus(personaEntity.get().getEstatus());
				personaDto.setFechaRegistro(personaEntity.get().getFechaRegistro());
				personaDto.setSexo(personaEntity.get().getSexo());
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return personaDto;
	}

	public boolean actualizarPersona(PersonaDto personaDto) throws IntegradoraException {
		boolean resultado = false;
		Optional<PersonaEntity> personaEntity;

		try {
			if (personaDto != null) {
				personaEntity = personaDao.findById(personaDto.getIdPersona());

				if (personaEntity.isPresent()) {

					if (personaDto.getNombre() != null) {
						personaEntity.get().setNombre(personaDto.getNombre());
					}
					if (personaDto.getApellidoPaterno() != null) {
						personaEntity.get().setApellidoPaterno(personaDto.getApellidoPaterno());
					}
					if (personaDto.getApellidoMaterno() != null) {
						personaEntity.get().setApellidoMaterno(personaDto.getApellidoMaterno());
					}
					personaEntity.get().setEstatus(personaDto.getEstatus());

					if (personaDto.getFechaRegistro() != null) {
						personaEntity.get().setFechaRegistro(personaDto.getFechaRegistro());
					}
					personaDao.save(personaEntity.get());
					resultado = true;
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return resultado;
	}

	public boolean eliminarPersona(long idPersona) throws IntegradoraException {
		boolean resultado = false;
		Optional<PersonaEntity> personaEntity;

		try {
			personaEntity = personaDao.findById(idPersona);

			if (personaEntity.isPresent()) {
				personaDao.delete(personaEntity.get());
				resultado = true;
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return resultado;
	}

	public boolean guardarHistorial(List<RespuestaDto> respuestasDto) throws IntegradoraException {
		boolean resultado = false;
		RespuestaEntity respuesta;
		ExpedienteEntity expediente;
		long idPersona = 0;
		try {
			for (RespuestaDto respuestaDto : respuestasDto) {
				if (respuestaDto != null) {
					respuesta = new RespuestaEntity();
					respuesta.setIdPersona(respuestaDto.getIdPersona());
					respuesta.setIdPregunta(respuestaDto.getIdPregunta());
					if (respuestaDto.getRespuesta() == null | respuestaDto.getRespuesta().isEmpty()) {
						respuesta.setRespuesta("N/A");
					}else{
						respuesta.setRespuesta(respuestaDto.getRespuesta());
					}
					idPersona = respuestaDto.getIdPersona();
					respuestaDao.save(respuesta);
				}
				
			}
			resultado = true;
			if (resultado) {
				expediente = new ExpedienteEntity();
				expediente.setIdUsuario(idPersona);
				Date fecha = new java.util.Date();
				expediente.setFecha(fecha);
				expedienteDao.save(expediente);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return resultado;
	}
	
}
