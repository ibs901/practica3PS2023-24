package es.unican.ps.hoteles.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Reserva {
	private Long id;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private DatosCliente cliente;
	private DatosPago tarjeta;
	private List<ReservaTipoHabitacion> reservasPorTipo;
	private double importe;
	private boolean importeCargado;
	
	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;	
		this.importeCargado = false;
	}
	
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

	public DatosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DatosCliente cliente) {
		this.cliente = cliente;
	}

	public DatosPago getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(DatosPago tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<ReservaTipoHabitacion> getReservasPorTipo() {
		return reservasPorTipo;
	}

	public void setReservasPorTipo(List<ReservaTipoHabitacion> reservasPorTipo) {
		this.reservasPorTipo = reservasPorTipo;
	}
	
	public double getImporte() {
		if (!importeCargado) {
			importe = this.calcularImporte();
			importeCargado = true;
		}
		return importe;
	}
	
	public double calcularImporte() {
		double aux = 0.0;
		for (ReservaTipoHabitacion r : reservasPorTipo) {
			aux += r.getNumHabitaciones() * r.getTipoHabitacion().getPrecioPorNoche();
		}
		return aux;		
	}

}
