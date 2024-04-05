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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mx.com.integradora.model.dto.PreguntaDto;
import mx.com.integradora.model.dto.RespuestaDto;
import mx.com.integradora.model.exception.IntegradoraException;
import mx.com.integradora.service.PersonaService;
import mx.com.integradora.service.PreguntaService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/preguntas")
public class PreguntaController {
	private static final Logger LOGGER = LogManager.getLogger(PersonaController.class);
	
	@Autowired
	private PreguntaService preguntaService;
	@Autowired
	private PersonaService personaService;

	@PostMapping
	public ResponseEntity<Resource> guardarHistorial(@RequestBody List<RespuestaDto> respuestasDto) {
		ResponseEntity<Resource> response = null;
		HttpHeaders headers;
		boolean respuesta = false;

		try {
			respuesta = personaService.guardarHistorial(respuestasDto);

			if (respuesta) {
				headers = new HttpHeaders();
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
	public ResponseEntity<List<PreguntaDto>> consultarPreguntas() {
		ResponseEntity<List<PreguntaDto>> response = null;
		List<PreguntaDto> listaDto = new ArrayList<PreguntaDto>();
		try {

			listaDto = preguntaService.consultarPreguntas();

			if (listaDto != null && !listaDto.isEmpty()) {
				response = new ResponseEntity<List<PreguntaDto>>(listaDto, HttpStatus.OK);
			} else {
				response = new ResponseEntity<List<PreguntaDto>>(listaDto, HttpStatus.NO_CONTENT);
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
	
	@GetMapping("{idPersona}")
	public ResponseEntity<List<RespuestaDto>> consultarHistorial(@Valid @PathVariable Long idPersona) {
		ResponseEntity<List<RespuestaDto>> response = null;
		List<RespuestaDto> listaDto = new ArrayList<RespuestaDto>();
		try {

			listaDto = preguntaService.consultaHistorial(idPersona);

			if (listaDto != null && !listaDto.isEmpty()) {
				response = new ResponseEntity<List<RespuestaDto>>(listaDto, HttpStatus.OK);
			} else {
				response = new ResponseEntity<List<RespuestaDto>>(listaDto, HttpStatus.NO_CONTENT);
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
