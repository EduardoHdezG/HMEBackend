package mx.com.integradora.model.dto;

public class RespuestaDto {
    private long idRespuesta;
	private long idPregunta;
	private String respuesta;
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
