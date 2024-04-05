package mx.com.integradora.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "HME_CATALOGO_ENFERMEDADES")
public class EnfermedadEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CAT_ENFERMEDAD")
	private long idCatEnfermedad;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ELIMINADO")
	private int eliminado;
	
	public EnfermedadEntity() {
		super();
	}

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
