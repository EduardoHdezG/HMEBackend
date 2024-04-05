package mx.com.integradora.web.test.impl;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.integradora.common.constants.Constantes;
import mx.com.integradora.model.dto.PersonaDto;
import mx.com.integradora.web.controller.PersonaController;
import mx.com.integradora.web.test.ControllerTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControllerTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonaControllerTest {

	private static final Logger LOGGER = LogManager.getLogger(PersonaControllerTest.class);

	@Autowired
	private PersonaController personaController;

	@Test
	public void consultarPersonas() {
		ResponseEntity<List<PersonaDto>> listaPersonaDto;
		try {
			listaPersonaDto = personaController.consultarPersonas();

			if (listaPersonaDto != null && !listaPersonaDto.getBody().isEmpty()) {
				LOGGER.info("Total de registros encontrados: " + listaPersonaDto.getBody().size());
			} else {
				LOGGER.info("No se encontraron resultados");
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

//	@Test
	public void consultarPersonaPorId() {
		ResponseEntity<PersonaDto> personaDto = null;
		Long idPersona = 22L;
		try {
			personaDto = personaController.consultarPersonaPorId(idPersona);

			if (personaDto != null && personaDto.getBody() != null) {
				LOGGER.info("Persona ID [" + idPersona + "]: " + personaDto.getBody().getNombre() + " "
						+ personaDto.getBody().getApellidoPaterno());
			} else {
				LOGGER.info("No se encontraron resultados");
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

//	@Test
	public void guardarPersona() {
		ResponseEntity<Resource> response = null;
		PersonaDto personaDto;
		Long idPersona;

		try {
			personaDto = new PersonaDto();
			personaDto.setNombre("JUAN");
			personaDto.setApellidoPaterno("LOPEZ");
			personaDto.setApellidoMaterno("MARTINEZ");
			personaDto.setFechaRegistro(new Date());
			personaDto.setEstatus(Constantes.ESTATUS_ACTIVO);
			
			response = personaController.guardarPersona(personaDto);

			if (response.getHeaders() != null && !response.getHeaders().getValuesAsList("IdPersona").isEmpty()) {

				idPersona = Long.parseLong(response.getHeaders().getValuesAsList("IdPersona").get(0));
				LOGGER.info("Registro guardado correctamente. IdPersona: " + idPersona);
			} else {
				LOGGER.info("No se pudo guardar el registro");
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

//	@Test
	public void eliminarPersona() {
		ResponseEntity<Resource> response = null;
		Long idPersona = 28L;

		try {
			response = personaController.eliminarPersona(idPersona);

			if (response != null && response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				LOGGER.info("Persona eliminada correctamente");
			} else {
				LOGGER.info("La persona no existe");
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

//	@Test
	public void actualizarPersona() {
		ResponseEntity<Resource> response = null;
		PersonaDto personaDto;
		Long idPersona = 26L;

		try {
			personaDto = new PersonaDto();
			personaDto.setIdPersona(idPersona);
			personaDto.setEstatus(Constantes.ESTATUS_INACTIVO);

			response = personaController.actualizarPersona(personaDto);

			if (response != null && response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				LOGGER.info("Persona actualizada correctamente");
			} else {
				LOGGER.info("La persona no existe");
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

}
