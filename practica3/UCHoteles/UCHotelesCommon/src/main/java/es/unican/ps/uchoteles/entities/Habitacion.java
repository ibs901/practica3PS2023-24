package es.unican.ps.uchoteles.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Habitaciones")
public class Habitacion implements Serializable {
	
	// Generado para la capa de persistencia
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoHabitacion tipo;
	
	private double precioPorNoche;
	private int disponibles;
	
	public Habitacion() {
		
	}
	
	public Habitacion(TipoHabitacion tipo, double precioPorNoche, int disponibles) {
		this.tipo = tipo;
		this.precioPorNoche = precioPorNoche;
		this.disponibles = disponibles;
	}
	
	public TipoHabitacion getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoHabitacion tipo) {
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
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Habitacion habitacion = (Habitacion) obj;
        return Objects.equals(id, habitacion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
