package es.unican.ps.hoteles.daoLayer;

import java.util.List;

import es.unican.ps.hoteles.entities.Reserva;

public interface IReservasDAO {
	
	public Reserva creaReserva(Reserva reserva);
	public Reserva eliminaReserva(String idReserva);
	public Reserva actualizarReserva(Reserva reserva);
	public Reserva reserva(String idReserva);
	public List<Reserva> reservas();
}
