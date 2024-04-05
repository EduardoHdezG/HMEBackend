package mx.com.integradora.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mx.com.integradora.model.dto.EnfermedadDto;
import mx.com.integradora.model.exception.IntegradoraException;
import mx.com.integradora.service.EnfermedadService;
import mx.com.integradora.service.PersonaService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/enfermedades")
public class EnfermedadController {
	
private static final Logger LOGGER = LogManager.getLogger(PersonaController.class);
	@Autowired
	private PersonaService personaService;
	@Autowired
	private EnfermedadService enfermedadService;
	@GetMapping
	public ResponseEntity<List<EnfermedadDto>> consultarEnfermedades() {
		ResponseEntity<List<EnfermedadDto>> response = null;
		List<EnfermedadDto> listaDto = new ArrayList<EnfermedadDto>();
		try {

			listaDto = enfermedadService.consultarenfermedades();

			if (listaDto != null && !listaDto.isEmpty()) {
				response = new ResponseEntity<List<EnfermedadDto>>(listaDto, HttpStatus.OK);
			} else {
				response = new ResponseEntity<List<EnfermedadDto>>(listaDto, HttpStatus.NO_CONTENT);
			}

		} catch (IntegradoraException e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCode(), e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
		return response;
	}

}
