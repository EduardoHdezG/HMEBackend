package mx.com.integradora.model.dto;

import java.util.Date;
public class ExpedienteDto {
    private long idHistorial;
	private long idUsuario;
	private Date fecha;
	public long getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(long idHistorial) {
		this.idHistorial = idHistorial;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
