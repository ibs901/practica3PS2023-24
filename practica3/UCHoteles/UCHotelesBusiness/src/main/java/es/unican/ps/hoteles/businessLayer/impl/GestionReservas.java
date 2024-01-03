package es.unican.ps.hoteles.businessLayer.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.unican.ps.hoteles.businessLayer.IGestionReserva;
import es.unican.ps.hoteles.daoLayer.IReservasDAO;
import es.unican.ps.hoteles.entities.DatosCliente;
import es.unican.ps.hoteles.entities.DatosPago;
import es.unican.ps.hoteles.entities.Reserva;
import es.unican.ps.hoteles.entities.ReservaTipoHabitacion;
import es.unican.ps.hoteles.entities.TipoHabitacion;
import jakarta.ejb.EJB;

public class GestionReservas implements IGestionReserva {

	@EJB
	private IReservasDAO reservasDAO;
	
	public Reserva consultarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean cancelarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return false;
	}

	public long reservar(Map<TipoHabitacion, Integer> reservasPorTipo, 
			DatosCliente datosUsuario, DatosPago datosPago, LocalDate fechaEntrada, LocalDate fechaSalida) {
		// TODO Auto-generated method stub
		Reserva reserva = new Reserva(fechaEntrada, fechaSalida);
		reserva.setCliente(datosUsuario);
		reserva.setTarjeta(datosPago);
		
		List<ReservaTipoHabitacion> reservasTipoHabitacion = new ArrayList<ReservaTipoHabitacion>();
		
		for (Entry<TipoHabitacion, Integer> entry : reservasPorTipo.entrySet()) {
			TipoHabitacion tipo = entry.getKey();
			int numReservas = entry.getValue();
			if (numReservas > tipo.getDisponibles()) {
				// Mostrar mensaje de error
				return -1;
			}
			reservasTipoHabitacion.add(new ReservaTipoHabitacion(numReservas, tipo, reserva));
		}
		reserva.setReservasPorTipo(reservasTipoHabitacion);
		reservasDAO.creaReserva(reserva);
		return reserva.getId();
	}
	
	public List<Reserva> consultarReservas(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> consultarReservas(LocalDate fechaEntrada, LocalDate fechaSalida) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reserva modificarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return null;
	}
}
