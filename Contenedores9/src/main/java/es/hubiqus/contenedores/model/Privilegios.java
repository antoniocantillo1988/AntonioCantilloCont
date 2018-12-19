package es.hubiqus.contenedores.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="privilegios")
public class Privilegios {

	private Integer idprivilegios;
	private String tipo;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdprivilegios() {
		return idprivilegios;
	}
	public void setIdprivilegios(Integer idprivilegios) {
		this.idprivilegios = idprivilegios;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	
	
}
