package es.unican.ps.hoteles.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Hoteles")
public class Hotel implements Serializable {
	
	// Generado para la capa de persistencia
	@Id 
	@GeneratedValue
	private Long id;
		
	private String nombre;
	private String direccion;
	private String localidad;
	
	@OneToMany 
	@JoinTable(name="Propiedad_Habitaciones",            
			joinColumns=@JoinColumn(name="Hot_FK"),
			inverseJoinColumns=@JoinColumn(name="Hab_FK"))
	private List<TipoHabitacion> habitaciones;
	
	@OneToMany 
	@JoinTable(name="Propiedad_Reservas",            
			joinColumns=@JoinColumn(name="Hot_FK"),
			inverseJoinColumns=@JoinColumn(name="Res_FK"))
	private List<Reserva> reservas;
	
	public Hotel() {
		
	}
	
	public Hotel(String nombre, String direccion, String localidad) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<TipoHabitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<TipoHabitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}
