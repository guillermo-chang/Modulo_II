package mx.init.escuela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="participante")
public class participante {
	
	@Id
	@Column(name="idParticipante")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idParticipante;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	@Column(name="email", length=45)
	private String email;
	
	@Column(name="observaciones", length=45)
	private String observaciones;
	
	@Column(name="fkidTurma")
	private Integer fkidTurma;
		

	public Integer getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(Integer idParticipante) {
		this.idParticipante = idParticipante;
	}
	public Integer getFkidTurma() {
		return fkidTurma;
	}
	public void setFkidTurma(Integer fkidTurma) {
		this.fkidTurma = fkidTurma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
