package mx.com.integradora.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HME_PERSONA")
public class PersonaEntity implements Serializable {

	private static final long serialVersionUID = -2883916650958290433L;

	@SequenceGenerator(name="HME_PERSONA_GEN", sequenceName="SEQUENCE3", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HME_PERSONA_GEN")
	@Id
	@Column(name = "ID_PERSONA", unique = true)
	private long idPersona;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "AP_PATERNO")
	private String apellidoPaterno;

	@Column(name = "AP_MATERNO")
	private String apellidoMaterno;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "ESTADO_CIVIL")
	private String estadoCivil;
	
	@Column(name = "TELEFONO_CEL")
	private String telefonoC;
	
	@Column(name = "TELEFONO_CASA")
	private String telefonoA;

	@Column(name = "IDENTIFICADOR")
	private String identificador;
	
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@Column(name = "ACTIVO")
	private int estatus;

	public PersonaEntity() {
		super();
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
	

}
