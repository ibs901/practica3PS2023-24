package es.unican.ps.hoteles.businessLayer;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.hoteles.entities.*;

public interface IGestionReserva {
	
	public Reserva consultarReserva(Long idReserva);
	public boolean cancelarReserva(Long idReserva);
	public String reservar(int numReservas, TipoHabitacion tipo, Usuario usuario);
	public List<Reserva> consultarReservas(LocalDate fecha);
	public List<Reserva> consultarReservas(LocalDate fechaIni, LocalDate fechaFin);
	public Reserva modificarReserva(Long idReserva);
}
