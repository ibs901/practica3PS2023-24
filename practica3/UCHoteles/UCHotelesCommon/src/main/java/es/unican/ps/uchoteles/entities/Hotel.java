package es.unican.ps.uchoteles.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Hoteles")
public class Hotel implements Serializable {

	@Id 		
	private String nombre;

	@Id
	private String localidad;

	private String direccion;

	@OneToMany
	@JoinTable(name = "Hotel_Habitaciones",
	joinColumns = {
			@JoinColumn(name = "hotel_nombre", referencedColumnName = "nombre"),
			@JoinColumn(name = "hotel_localidad", referencedColumnName = "localidad")
	},
	inverseJoinColumns = @JoinColumn(name = "Hab_FK"))
	private List<Habitacion> habitaciones;

	@OneToMany
	@JoinTable(name = "Hotel_Reservas",
	joinColumns = {
			@JoinColumn(name = "hotel_nombre", referencedColumnName = "nombre"),
			@JoinColumn(name = "hotel_localidad", referencedColumnName = "localidad")
	},
	inverseJoinColumns = @JoinColumn(name = "Res_FK"))
	private List<Reserva> reservas;


	public Hotel() {

	}

	public Hotel(String nombre, String localidad) {
		this.nombre = nombre;
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

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}
