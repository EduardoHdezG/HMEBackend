package mx.com.integradora.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.integradora.dao.EnfermedadDao;
import mx.com.integradora.model.dto.EnfermedadDto;
import mx.com.integradora.model.entity.EnfermedadEntity;
import mx.com.integradora.model.exception.IntegradoraException;
import mx.com.integradora.service.EnfermedadService;

@Service
public class EnfermedadServiceImpl implements EnfermedadService{
	private static final Logger LOGGER = LogManager.getLogger(EnfermedadServiceImpl.class);
	@Autowired
	private EnfermedadDao enfermedadDao;
	
	public List<EnfermedadDto> consultarenfermedades() throws IntegradoraException {
		List<EnfermedadDto> listaDto = null;
		Iterable<EnfermedadEntity> listaEntity;
		EnfermedadDto enfermedadDto;

		try {
			listaEntity = enfermedadDao.findAll();

			if (listaEntity != null) {

				listaDto = new ArrayList<EnfermedadDto>();

				for (EnfermedadEntity entity : listaEntity) {

					enfermedadDto = new EnfermedadDto();
					enfermedadDto.setNombre(entity.getNombre());
					enfermedadDto.setEliminado(entity.getEliminado());
					enfermedadDto.setIdCatEnfermedad(entity.getIdCatEnfermedad());
					listaDto.add(enfermedadDto);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return listaDto;
	}
}
