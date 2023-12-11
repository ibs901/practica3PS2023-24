package es.unican.ps.hoteles.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Reserva {
	
	
	private Long id;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}
	
	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
}
