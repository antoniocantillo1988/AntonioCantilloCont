package es.hubiqus.contenedores.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="alquilar")
public class Alquilar {

	private Integer idalquilar;
	private Usuario idusuarios;
	private Contenedor idcontenedor;
	private Date fechaalquiler ;
	private int precio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdalquilar() {
		return idalquilar;
	}
	public void setIdalquilar(Integer idalquilar) {
		this.idalquilar = idalquilar;
	}
	


	@ManyToOne
	@JoinColumn(name="idusuarios")
	public Usuario getIdusuarios() {
		return idusuarios;
	}
	public void setIdusuarios(Usuario idusuarios) {
		this.idusuarios = idusuarios;
	}
	
	@ManyToOne
	@JoinColumn(name="idcontenedor")
	public Contenedor getIdcontenedor() {
		return idcontenedor;
	}
	public void setIdcontenedor(Contenedor idcontenedor) {
		this.idcontenedor = idcontenedor;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechaalquiler() {
		return fechaalquiler;
	}
	public void setFechaalquiler(Date fechaalquiler) {
		this.fechaalquiler = fechaalquiler;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}