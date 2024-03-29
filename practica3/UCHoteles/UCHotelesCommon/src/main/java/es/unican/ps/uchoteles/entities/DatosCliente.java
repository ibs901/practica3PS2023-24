package es.unican.ps.uchoteles.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Embeddable
public class DatosCliente implements Serializable {
	
	private String dni;
	private String nombre;
	private String email;
	
	public DatosCliente() {
		
	}
	
	public DatosCliente(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
