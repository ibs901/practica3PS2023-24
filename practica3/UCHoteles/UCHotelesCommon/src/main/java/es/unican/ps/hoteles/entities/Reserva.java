package es.unican.ps.hoteles.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Reservas")
public class Reserva implements Serializable {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	@OneToOne 
	@JoinColumn(name="cli_fk")
	private DatosCliente cliente;
	
	@OneToOne 
	@JoinColumn(name="tar_fk")
	private DatosPago tarjeta;
	
	@OneToMany(mappedBy="reserva")
	private List<ReservaTipoHabitacion> reservasPorTipo;
	
	private double importe;
	
	public Reserva() {
		
	}
	
	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;	
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
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}
