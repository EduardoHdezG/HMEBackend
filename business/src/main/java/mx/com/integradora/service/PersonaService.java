package mx.com.integradora.service;

import java.util.List;

import mx.com.integradora.model.dto.DomicilioDto;
import mx.com.integradora.model.dto.PersonaDto;
import mx.com.integradora.model.dto.RespuestaDto;
import mx.com.integradora.model.exception.IntegradoraException;

public interface PersonaService {

	Long guardarPersona(PersonaDto personaDto) throws IntegradoraException;

	List<PersonaDto> consultarPersonas() throws IntegradoraException;

	PersonaDto consultarPersonaPorId(long idPersona) throws IntegradoraException;

	boolean actualizarPersona(PersonaDto personaDto) throws IntegradoraException;

	boolean eliminarPersona(long idPersona) throws IntegradoraException;

	boolean guardarHistorial(List<RespuestaDto> respuestasDto) throws IntegradoraException;;

}
