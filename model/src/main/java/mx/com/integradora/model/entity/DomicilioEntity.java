package mx.com.integradora.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HME_DOMICILIO")

public class DomicilioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_DOMICILIO")
	private long idDomicilio;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "DETALLE1")
	private String detalle1;
	
	@Column(name = "DETALLE2")
	private String detalle2;
	
	@Column(name = "COLONIA")
	private String colonia;
	
	@Column(name = "ENTIDAD")
	private String entidad;
	
	@Column(name = "PERSONA")
	private long persona;

	public long getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(long idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getDetalle1() {
		return detalle1;
	}

	public void setDetalle1(String detalle1) {
		this.detalle1 = detalle1;
	}

	public String getDetalle2() {
		return detalle2;
	}

	public void setDetalle2(String detalle2) {
		this.detalle2 = detalle2;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public long getPersona() {
		return persona;
	}

	public void setPersona(long persona) {
		this.persona = persona;
	}
	
	

}
