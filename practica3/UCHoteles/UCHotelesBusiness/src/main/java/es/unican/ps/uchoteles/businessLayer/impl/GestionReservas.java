package es.unican.ps.uchoteles.businessLayer.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.unican.ps.uchoteles.businessLayer.IGestionReservaLocal;
import es.unican.ps.uchoteles.businessLayer.IGestionReservaRemote;
import es.unican.ps.uchoteles.daoLayer.IHotelesDAOLocal;
import es.unican.ps.uchoteles.daoLayer.IReservasDAOLocal;
import es.unican.ps.uchoteles.entities.DatosCliente;
import es.unican.ps.uchoteles.entities.DatosPago;
import es.unican.ps.uchoteles.entities.Hotel;
import es.unican.ps.uchoteles.entities.Reserva;
import es.unican.ps.uchoteles.entities.ReservaHabitacion;
import es.unican.ps.uchoteles.entities.Habitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionReservas implements IGestionReservaLocal, IGestionReservaRemote {

	@EJB
	private IReservasDAOLocal reservasDAO;

	@EJB
	private IHotelesDAOLocal hotelesDAO;

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

	
	public Reserva modificarReserva(Long idReserva, Map<Habitacion, Integer> reservasPorTipo,
			LocalDate fechaEntrada, LocalDate fechaSalida) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double reservar(Hotel hotel, Map<Habitacion, Integer> reservasPorTipo, LocalDate fechaEntrada,
			LocalDate fechaSalida) {
		
		double importe = 0.0;
		long noches = 0;
		
		// noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
		
		for (Entry<Habitacion, Integer> entry : reservasPorTipo.entrySet()) {
			Habitacion tipo = entry.getKey();
			int numReservas = entry.getValue();
			if (numReservas > tipo.getDisponibles()) {
				// Mostrar mensaje de error
				return -1;
			}
			importe += tipo.getPrecioPorNoche() * noches * numReservas;
		}
		
		return importe;
	}
	
	public long confirmarReserva(Hotel hotel, Map<Habitacion, Integer> reservasPorTipo, 
			DatosCliente datosUsuario, DatosPago datosPago, LocalDate fechaEntrada, 
			LocalDate fechaSalida, double importe) {
		
		// hotel = hotelesDAO.hotel(hotel.getNombre(), hotel.getLocalidad());
		hotel = hotelesDAO.hotel("Bahia", "Santander");
		
		
		
		
		
		
		

		for (Entry<Habitacion, Integer> entry : reservasPorTipo.entrySet()) {
			Habitacion tipo = entry.getKey();
			int numReservas = entry.getValue();
			if (numReservas > tipo.getDisponibles()) {
				// Mostrar mensaje de error
				return -1;
			}
		}
		
		
		
		
		
		
		
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.now().plusDays(8);
		
		
		
		
		
		
		
		
		
		Reserva reserva = new Reserva(fechaEntrada, fechaSalida);
		reserva.setCliente(datosUsuario);
		reserva.setTarjeta(datosPago);
		reserva.setImporte(importe);
		
		List<ReservaHabitacion> reservasTipoHabitacion = new ArrayList<ReservaHabitacion>();
		
		for (Entry<Habitacion, Integer> entry : reservasPorTipo.entrySet()) {
			Habitacion tipo = entry.getKey();
			int numReservas = entry.getValue();
			reservasTipoHabitacion.add(new ReservaHabitacion(numReservas, tipo, reserva));
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
