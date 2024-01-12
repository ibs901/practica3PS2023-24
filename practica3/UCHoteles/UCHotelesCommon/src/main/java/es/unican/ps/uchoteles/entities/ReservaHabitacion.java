package es.unican.ps.uchoteles.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ReservaHabitaciones")
public class ReservaHabitacion implements Serializable {
	
	// Generado para la capa de persistencia
	@Id 
	@GeneratedValue
	private Long id;
	
	private int numHabitaciones;
	
	@OneToOne 
	@JoinColumn(name="hab_fk")
	private Habitacion tipoHabitacion;
	
	@ManyToOne 
	@JoinColumn(name="res_fk")
	private Reserva reserva;
	
	public ReservaHabitacion() {
		
	}
	
	public ReservaHabitacion(int numHabitaciones, Habitacion tipoHabitacion, Reserva reserva) {
		this.numHabitaciones = numHabitaciones;
		this.tipoHabitacion = tipoHabitacion;
		this.reserva = reserva;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public Habitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(Habitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
