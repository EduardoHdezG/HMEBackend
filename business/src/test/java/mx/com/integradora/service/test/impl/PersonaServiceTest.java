package mx.com.integradora.service.test.impl;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.integradora.common.constants.Constantes;
import mx.com.integradora.model.dto.PersonaDto;
import mx.com.integradora.model.exception.IntegradoraException;
import mx.com.integradora.service.PersonaService;
import mx.com.integradora.service.test.ServiceTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonaServiceTest {

	private static final Logger LOGGER = LogManager.getLogger(PersonaServiceTest.class);

	@Autowired
	private PersonaService personaService;

	@Test
	public void consultarPersonas() {
		List<PersonaDto> listaPersonaDto;
		try {
			listaPersonaDto = personaService.consultarPersonas();

			if (listaPersonaDto != null) {
				LOGGER.info("Total de registros encontrados: " + listaPersonaDto.size());
			} else {
				LOGGER.info("No se encontraron resultados");
			}
		} catch (IntegradoraException e) {
			LOGGER.error(e);
		}
	}

	// @Test
	public void consultarPersonaPorId() {
		PersonaDto personaDto;
		Long idPersona = 1L;
		try {
			personaDto = personaService.consultarPersonaPorId(idPersona);

			if (personaDto != null) {
				LOGGER.info("Persona ID [" + idPersona + "]: " + personaDto.getNombre() + " "
						+ personaDto.getApellidoPaterno());
			} else {
				LOGGER.info("No se encontraron resultados");
			}
		} catch (IntegradoraException e) {
			LOGGER.error(e);
		}
	}

	// @Test
	public void guardarPersona() {
		PersonaDto personaDto;
		Long idPersona;
		try {
			personaDto = new PersonaDto();
			personaDto.setNombre("JUAN");
			personaDto.setApellidoPaterno("LOPEZ");
			personaDto.setApellidoMaterno("MARTINEZ");
			personaDto.setFechaRegistro(new Date());
			personaDto.setEstatus(Constantes.ESTATUS_ACTIVO);

			idPersona = personaService.guardarPersona(personaDto);

			LOGGER.info("Registro guardado correctamente. IdPersona: " + idPersona);
		} catch (IntegradoraException e) {
			LOGGER.error(e);
		}
	}

	// @Test
	public void eliminarPersona() {
		boolean resultado = false;
		Long idPersona = 1L;
		try {

			resultado = personaService.eliminarPersona(idPersona);
			if (resultado) {
				LOGGER.info("Persona eliminada correctamente");
			} else {
				LOGGER.info("La persona no existe");
			}
		} catch (IntegradoraException e) {
			LOGGER.error(e);
		}
	}

	// @Test
	public void actualizarPersona() {
		PersonaDto personaDto;
		Long idPersona = 1L;
		boolean resultado = false;
		try {
			personaDto = new PersonaDto();
			personaDto.setIdPersona(idPersona);
			personaDto.setEstatus(Constantes.ESTATUS_INACTIVO);

			resultado = personaService.actualizarPersona(personaDto);

			if (resultado) {
				LOGGER.info("Persona actualizada correctamente");
			} else {
				LOGGER.info("La persona no existe");
			}
		} catch (IntegradoraException e) {
			LOGGER.error(e);
		}
	}

}
