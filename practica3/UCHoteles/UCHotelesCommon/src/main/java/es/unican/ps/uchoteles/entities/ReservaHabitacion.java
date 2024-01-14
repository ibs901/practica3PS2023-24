package es.unican.ps.uchoteles.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int numHabitaciones;
	
	@OneToOne 
	@JoinColumn(name="hab_fk")
	private Habitacion habitacion;
	
	@ManyToOne 
	@JoinColumn(name="res_fk")
	private Reserva reserva;
	
	public ReservaHabitacion() {
		
	}
	
	public ReservaHabitacion(int numHabitaciones, Habitacion habitacion, Reserva reserva) {
		this.numHabitaciones = numHabitaciones;
		this.habitacion = habitacion;
		this.reserva = reserva;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
