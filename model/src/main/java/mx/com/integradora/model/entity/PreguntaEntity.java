package mx.com.integradora.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HME_CATALOGO_PREGUNTA")

public class PreguntaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CATALOGO_PREGUNTA")
	private long idPregunta;
	
	@Column(name = "ID_TIPO_ENFERMEDAD")
	private long idTipoEnfermedad;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public long getIdTipoEnfermedad() {
		return idTipoEnfermedad;
	}

	public void setIdTipoEnfermedad(long idTipoEnfermedad) {
		this.idTipoEnfermedad = idTipoEnfermedad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
