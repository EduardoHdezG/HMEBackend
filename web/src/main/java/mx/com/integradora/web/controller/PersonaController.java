package mx.com.integradora.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mx.com.integradora.model.dto.DomicilioDto;
import mx.com.integradora.model.dto.PersonaDto;
import mx.com.integradora.model.dto.RespuestaDto;
import mx.com.integradora.model.exception.IntegradoraException;
import mx.com.integradora.service.PersonaService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/persona")
public class PersonaController {

	private static final Logger LOGGER = LogManager.getLogger(PersonaController.class);

	@Autowired
	private PersonaService personaService;

	@PostMapping
	public ResponseEntity<Resource> guardarPersona(@RequestBody PersonaDto personaDto) {
		ResponseEntity<Resource> response = null;
		HttpHeaders headers;
		Long idPersona = null;

		try {
			idPersona = personaService.guardarPersona(personaDto);

			if (idPersona != null) {
				headers = new HttpHeaders();
				headers.add("IdPersona", idPersona.toString());
				response = new ResponseEntity<Resource>(headers, HttpStatus.CREATED);
				
			} else {
				response = new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST);
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
	
	@GetMapping
	public String test() {
		return ("Hola Mundo");
	}
	
	
//	@GetMapping
//	public ResponseEntity<List<PersonaDto>> consultarPersonas() {
//		ResponseEntity<List<PersonaDto>> response = null;
//		List<PersonaDto> listaPersonaDto = new ArrayList<PersonaDto>();
//		try {
//
//			listaPersonaDto = personaService.consultarPersonas();
//
//			if (listaPersonaDto != null && !listaPersonaDto.isEmpty()) {
//				response = new ResponseEntity<List<PersonaDto>>(listaPersonaDto, HttpStatus.OK);
//			} else {
//				response = new ResponseEntity<List<PersonaDto>>(listaPersonaDto, HttpStatus.NO_CONTENT);
//			}
//
//		} catch (IntegradoraException e) {
//			LOGGER.error(e);
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCode(), e);
//		} catch (Exception e) {
//			LOGGER.error(e);
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
//		}
//		return response;
//	}

	@GetMapping("{idPersona}")
	public ResponseEntity<PersonaDto> consultarPersonaPorId(@Valid @PathVariable Long idPersona) {
		ResponseEntity<PersonaDto> response = null;
		PersonaDto personaDto = null;
		try {
			personaDto = personaService.consultarPersonaPorId(idPersona);

			if (personaDto != null) {
				response = new ResponseEntity<PersonaDto>(personaDto, HttpStatus.OK);
			} else {
				response = new ResponseEntity<PersonaDto>(personaDto, HttpStatus.NO_CONTENT);
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

	@DeleteMapping("{idPersona}")
	public ResponseEntity<Resource> eliminarPersona(@PathVariable Long idPersona) {
		ResponseEntity<Resource> response = null;
		boolean resultado = false;
		try {
			resultado = personaService.eliminarPersona(idPersona);

			if (resultado) {
				response = new ResponseEntity<Resource>(HttpStatus.ACCEPTED);
			} else {
				response = new ResponseEntity<Resource>(HttpStatus.NO_CONTENT);
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

	@PutMapping
	public ResponseEntity<Resource> actualizarPersona(@Valid @RequestBody PersonaDto personaDto) {
		ResponseEntity<Resource> response = null;
		boolean resultado = false;

		try {
			resultado = personaService.actualizarPersona(personaDto);

			if (resultado) {
				response = new ResponseEntity<Resource>(HttpStatus.ACCEPTED);
			} else {
				response = new ResponseEntity<Resource>(HttpStatus.NO_CONTENT);
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
