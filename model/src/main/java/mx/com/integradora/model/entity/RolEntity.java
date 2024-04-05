package mx.com.integradora.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HME_ROL")

public class RolEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "ID_ROL")
	private long rol;

	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "ELIMINADO")
	private long eliminado;

	public long getRol() {
		return rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getEliminado() {
		return eliminado;
	}

	public void setEliminado(long eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
