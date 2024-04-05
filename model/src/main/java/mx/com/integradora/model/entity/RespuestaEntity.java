package mx.com.integradora.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HME_PREGUNTA_RESPUESTA")
public class RespuestaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="HME_PREGUNTA_RESPUESTA_GENERATOR", sequenceName="SEQUENCE1", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HME_PREGUNTA_RESPUESTA_GENERATOR")
	@Column(name = "ID_PREGUNTA_RESPUESTA", unique = true, nullable = false)
	private long idRespuesta;
	
	@Column(name = "ID_PREGUNTA")
	private long idPregunta;
	
	@Column(name = "RESPUESTA")
	private String respuesta;
	
	@Column(name = "ID_PERSONA")
	private long idPersona;

	public long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}
	
	

}
