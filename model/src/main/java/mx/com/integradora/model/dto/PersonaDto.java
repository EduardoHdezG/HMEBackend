package mx.com.integradora.model.dto;

import java.util.Date;

import javax.persistence.Column;

public class PersonaDto {

	private long idPersona;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaRegistro;
	private String sexo;
	private String estadoCivil;
	private String telefonoC;
	private String telefonoA;
	private String identificador;
	private int estatus;
	private int historial;
	private DomicilioDto domicilio;

	public PersonaDto() {
		super();
	}

	public PersonaDto(long idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaRegistro,
			String sexo, String estadoCivil, String telefonoC, String telefonoA, String identificador, int estatus) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaRegistro = fechaRegistro;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.telefonoC = telefonoC;
		this.telefonoA = telefonoA;
		this.identificador = identificador;
		this.estatus = estatus;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefonoC() {
		return telefonoC;
	}

	public void setTelefonoC(String telefonoC) {
		this.telefonoC = telefonoC;
	}

	public String getTelefonoA() {
		return telefonoA;
	}

	public void setTelefonoA(String telefonoA) {
		this.telefonoA = telefonoA;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public DomicilioDto getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDto domicilio) {
		this.domicilio = domicilio;
	}

	public int getHistorial() {
		return historial;
	}

	public void setHistorial(int historial) {
		this.historial = historial;
	}
	
	
}
