package es.unican.ps.hoteles.entities;

import java.util.List;
import java.util.Map;

import jakarta.persistence.*;

@Entity
public class Hotel {
	private String nombre;
	private String direccion;
	private String localidad;
	private List<TipoHabitacion> habitaciones;
	private Map<Long, Reserva> reservas;
	
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

	public Map<Long, Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Map<Long, Reserva> reservas) {
		this.reservas = reservas;
	}
}
