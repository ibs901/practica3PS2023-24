package es.unican.ps.hoteles.entities;

import jakarta.persistence.Entity;

@Entity
public class TipoHabitacion {
	private String tipo;
	private double precioPorNoche;
	private int disponibles;
	
	public TipoHabitacion(String tipo, double precioPorNoche, int disponibles) {
		this.tipo = tipo;
		this.precioPorNoche = precioPorNoche;
		this.disponibles = disponibles;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	public int getDisponibles() {
		return disponibles;
	}
	
	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
}
