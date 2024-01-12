package es.unican.ps.uchoteles.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cli_fk")
	private DatosCliente cliente;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="tar_fk")
	private DatosPago tarjeta;
	
	@OneToMany(mappedBy="reserva", cascade = CascadeType.PERSIST)
	private List<ReservaHabitacion> reservasPorTipo = new ArrayList<ReservaHabitacion>();
	
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

	public List<ReservaHabitacion> getReservasPorTipo() {
		return reservasPorTipo;
	}

	public void setReservasPorTipo(List<ReservaHabitacion> reservasPorTipo) {
		this.reservasPorTipo = reservasPorTipo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}
