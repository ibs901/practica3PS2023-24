package es.unican.ps.hoteles.businessLayer.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.unican.ps.hoteles.businessLayer.IGestionReserva;
import es.unican.ps.hoteles.daoLayer.IHotelesDAO;
import es.unican.ps.hoteles.daoLayer.IReservasDAO;
import es.unican.ps.hoteles.entities.DatosCliente;
import es.unican.ps.hoteles.entities.DatosPago;
import es.unican.ps.hoteles.entities.Hotel;
import es.unican.ps.hoteles.entities.Reserva;
import es.unican.ps.hoteles.entities.ReservaTipoHabitacion;
import es.unican.ps.hoteles.entities.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionReservas implements IGestionReserva {

	@EJB
	private IReservasDAO reservasDAO;

	@EJB
	private IHotelesDAO hotelesDAO;

	public Reserva consultarReserva(Long idReserva) {
		return reservasDAO.reserva(idReserva);
	}

	public boolean cancelarReserva(Long idReserva) {
		Reserva r = consultarReserva(idReserva);
		long dias = ChronoUnit.DAYS.between(LocalDate.now(), r.getFechaEntrada());
		if (dias < 2) {
			return false;
		}
		reservasDAO.eliminaReserva(idReserva);
		return true;
	}

	
	public Reserva modificarReserva(Long idReserva, Map<TipoHabitacion, Integer> reservasPorTipo,
			LocalDate fechaEntrada, LocalDate fechaSalida) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double reservar(Hotel hotel, Map<TipoHabitacion, Integer> reservasPorTipo, LocalDate fechaEntrada,
			LocalDate fechaSalida) {
		
		double importe = 0.0;
		
		long noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
		
		for (Entry<TipoHabitacion, Integer> entry : reservasPorTipo.entrySet()) {
			TipoHabitacion tipo = entry.getKey();
			int numReservas = entry.getValue();
			if (numReservas > tipo.getDisponibles()) {
				// Mostrar mensaje de error
				return -1;
			}
			importe += tipo.getPrecioPorNoche() * noches;
		}
		
		return importe;
	}
	
	public long confirmarReserva(Hotel hotel, Map<TipoHabitacion, Integer> reservasPorTipo, 
			DatosCliente datosUsuario, DatosPago datosPago, LocalDate fechaEntrada, 
			LocalDate fechaSalida, double importe) {

		for (Entry<TipoHabitacion, Integer> entry : reservasPorTipo.entrySet()) {
			TipoHabitacion tipo = entry.getKey();
			int numReservas = entry.getValue();
			if (numReservas > tipo.getDisponibles()) {
				// Mostrar mensaje de error
				return -1;
			}
		}
		
		Reserva reserva = new Reserva(fechaEntrada, fechaSalida);
		reserva.setCliente(datosUsuario);
		reserva.setTarjeta(datosPago);
		reserva.setImporte(importe);
		
		List<ReservaTipoHabitacion> reservasTipoHabitacion = new ArrayList<ReservaTipoHabitacion>();
		
		for (Entry<TipoHabitacion, Integer> entry : reservasPorTipo.entrySet()) {
			TipoHabitacion tipo = entry.getKey();
			int numReservas = entry.getValue();
			reservasTipoHabitacion.add(new ReservaTipoHabitacion(numReservas, tipo, reserva));
			tipo.setDisponibles(tipo.getDisponibles() - numReservas);
		}
		
		reserva.setReservasPorTipo(reservasTipoHabitacion);
		reservasDAO.creaReserva(reserva);
		hotel.getReservas().add(reserva);
		hotelesDAO.actualizarHotel(hotel);
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
}
