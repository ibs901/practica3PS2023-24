package es.unican.ps.hoteles.businessLayer;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import es.unican.ps.hoteles.entities.*;

public interface IGestionReserva {
	
	public Reserva consultarReserva(Long idReserva);
	public boolean cancelarReserva(Long idReserva);
	public long reservar(Map<TipoHabitacion, Integer> reservasPorTipo, 
			DatosCliente datosUsuario, DatosPago datosPago, LocalDate fechaEntrada, LocalDate fechaSalida);
	public List<Reserva> consultarReservas(LocalDate fecha);
	public List<Reserva> consultarReservas(LocalDate fechaEntrada, LocalDate fechaSalida);
	public Reserva modificarReserva(Long idReserva);
}
