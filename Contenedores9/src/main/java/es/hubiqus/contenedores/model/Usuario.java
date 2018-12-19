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
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="usuarios")
public class Usuario {

	private Integer idusuarios;
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fechaalta ;
	private String direccion;
	private int telefono;
	private Privilegios privilegios;
	private String correoelectronico;
	private String contrasenya;
	private String claveRepetida;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdusuarios() {
		return idusuarios;
	}
	public void setIdusuarios(Integer idusuarios) {
		this.idusuarios = idusuarios;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}	

	@Temporal(TemporalType.DATE)
	public Date getFechaalta() {
		return fechaalta;
	}
	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	

	public String getCorreoelectronico() {
		return correoelectronico;
	}
	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}
	
	@Digits(integer=9, fraction = 0)
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@ManyToOne
	@JoinColumn(name="privilegios")
	public Privilegios getPrivilegios() {
		return privilegios;
	}
	public void setPrivilegios(Privilegios privilegios) {
		this.privilegios = privilegios;
	}

	@NotEmpty
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	@Override
	public String toString() {
		return "Usuario [idusuarios=" + idusuarios + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fechaalta=" + fechaalta + ", direccion=" + direccion + ", telefono=" + telefono + ", privilegios="
				+ privilegios + ", correoelectronico=" + correoelectronico + ", clave=" + contrasenya + "]";
	}
	
	@Transient
	public String getClaveRepetida() {
		return claveRepetida;
	}
	public void setClaveRepetida(String claveRepetida) {
		this.claveRepetida = claveRepetida;
	}
	
	
}
