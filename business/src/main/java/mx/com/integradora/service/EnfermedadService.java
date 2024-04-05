package mx.com.integradora.service;

import java.util.List;

import mx.com.integradora.model.dto.EnfermedadDto;
import mx.com.integradora.model.exception.IntegradoraException;

public interface EnfermedadService {
	
	List<EnfermedadDto> consultarenfermedades() throws IntegradoraException;
}
