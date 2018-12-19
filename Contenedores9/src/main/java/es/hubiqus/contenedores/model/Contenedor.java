package es.hubiqus.contenedores.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contenedor")
public class Contenedor {

	private Integer idcontenedor;
	private Integer tamanyo;
	private boolean disponibilidad;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdcontenedor() {
		return idcontenedor;
	}
	public void setIdcontenedor(Integer idcontenedor) {
		this.idcontenedor = idcontenedor;
	}
	public Integer getTamanyo() {
		return tamanyo;
	}
	public void setTamanyo(Integer tamanyo) {
		this.tamanyo = tamanyo;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
	
}
