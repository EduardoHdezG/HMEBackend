package mx.com.integradora.model.dto;

public class PreguntaDto {
	
    private long idPregunta;
	private long idTipoEnfermedad;
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
