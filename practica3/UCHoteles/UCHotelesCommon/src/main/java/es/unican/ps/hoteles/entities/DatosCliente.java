package es.unican.ps.hoteles.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="DatosClientes")
public class DatosCliente implements Serializable {
	
	// Generado para la capa de persistencia
	@Id 
	@GeneratedValue
	private Long id;
	
	private String dni;
	private String nombre;
	private String email;
	
	public DatosCliente() {
		
	}
	
	public DatosCliente(String dni, String nombre, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
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
