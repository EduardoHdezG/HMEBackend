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

@Entity
@Table(name = "HME_EXPEDIENTE")

public class ExpedienteEntity implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="HME_EXPEDIENTE_GENERATOR", sequenceName="SEQUENCEEXPEDIENTE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HME_EXPEDIENTE_GENERATOR")
	@Id
	@Column(name = "ID_HISTORIAL", unique = true, nullable = false)
	private long idHistorial;
	
	@Column(name = "ID_USUARIO")
	private long idUsuario;
	
	@Column(name = "FECHA")
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
