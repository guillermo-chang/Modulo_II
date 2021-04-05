package mx.init.escuela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="turma")
public class turma {
	
	@Id
	@Column(name="idTurma")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTurma;
	
	@Column(name="descripcion", nullable=false, length=45)
	private String descripcion;
	
	@Column(name="fkidParticipante")
	private Integer fkidParticipante;
	
	@Column(name="tipo", length=45)
	private String tipo;

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getFkidParticipante() {
		return fkidParticipante;
	}

	public void setFkidParticipante(Integer fkidParticipante) {
		this.fkidParticipante = fkidParticipante;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
