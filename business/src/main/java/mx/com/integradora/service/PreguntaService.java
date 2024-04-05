package mx.com.integradora.service;

import java.util.List;

import mx.com.integradora.model.dto.PreguntaDto;
import mx.com.integradora.model.dto.RespuestaDto;
import mx.com.integradora.model.exception.IntegradoraException;

public interface PreguntaService {

	Long guardarPregunta(PreguntaDto preguntaDto) throws IntegradoraException;

	List<PreguntaDto> consultarPreguntas() throws IntegradoraException;
	
	List<RespuestaDto> consultaHistorial(long idPersona) throws IntegradoraException;
}
