package mx.com.integradora.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HME_USUARIO")
public class UsuarioEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_USUARIO")
	private long idUsuario;
	
	@Column(name = "ID_PERSONA")
	private long idPersona;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "CONTRASEÑA")
	private String contraseña;
	
	@Column(name = "ID_ROL")
	private long idRol;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}
	
	

}
