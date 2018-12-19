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
@Table(name="factura")
public class Factura {

	private Integer idfactura;
	private Alquilar idalquilar;
	private Usuario idusuario;
	private boolean pagado;
	private Date fechaactual;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdfactura() {
		return idfactura;
	}
	public void setIdfactura(Integer idfactura) {
		this.idfactura = idfactura;
	}
	
	@ManyToOne
	@JoinColumn(name="idalquilar")
	public Alquilar getIdalquilar() {
		return idalquilar;
	}
	public void setIdalquilar(Alquilar idalquilar) {
		this.idalquilar = idalquilar;
	}
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}
	
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechaactual() {
		return fechaactual;
	}
	public void setFechaactual(Date fechaactual) {
		this.fechaactual = fechaactual;
	}
	
	
	
}
