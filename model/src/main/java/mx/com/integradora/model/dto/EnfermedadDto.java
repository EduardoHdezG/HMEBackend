package mx.com.integradora.model.dto;

public class EnfermedadDto {

	private long idCatEnfermedad;	
	private String nombre;
	private int eliminado;
	
	public long getIdCatEnfermedad() {
		return idCatEnfermedad;
	}
	public void setIdCatEnfermedad(long idCatEnfermedad) {
		this.idCatEnfermedad = idCatEnfermedad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEliminado() {
		return eliminado;
	}
	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
	}
	
}
