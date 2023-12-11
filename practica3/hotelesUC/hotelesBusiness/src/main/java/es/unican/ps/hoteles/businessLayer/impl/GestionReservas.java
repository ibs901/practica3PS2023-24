package es.unican.ps.hoteles.businessLayer.impl;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.hoteles.businessLayer.IGestionReserva;
import es.unican.ps.hoteles.businessLayer.Usuario;
import es.unican.ps.hoteles.entities.Reserva;
import es.unican.ps.hoteles.entities.TipoHabitacion;

public class GestionReservas implements IGestionReserva {

	public Reserva consultarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean cancelarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return false;
	}

	public String reservar(int numReservas, TipoHabitacion tipo, Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> consultarReservas(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> consultarReservas(LocalDate fechaIni, LocalDate fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reserva modificarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return null;
	}

}
