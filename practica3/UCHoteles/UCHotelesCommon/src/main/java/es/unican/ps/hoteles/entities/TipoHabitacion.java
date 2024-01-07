package es.unican.ps.hoteles.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TipoHabitaciones")
public class TipoHabitacion implements Serializable {
	
	// Generado para la capa de persistencia
	@Id 
	@GeneratedValue
	private Long id;
	
	private String tipo;
	private double precioPorNoche;
	private int disponibles;
	
	public TipoHabitacion() {
		
	}
	
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
