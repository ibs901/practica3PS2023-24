package es.unican.ps.uchoteles.businessLayer.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.unican.ps.uchoteles.businessLayer.IGestionHotelLocal;
import es.unican.ps.uchoteles.businessLayer.IGestionHotelRemote;
import es.unican.ps.uchoteles.businessLayer.IInfoHotelLocal;
import es.unican.ps.uchoteles.businessLayer.IInfoHotelRemote;
import es.unican.ps.uchoteles.daoLayer.IHotelesDAOLocal;
import es.unican.ps.uchoteles.entities.Hotel;
import es.unican.ps.uchoteles.entities.Habitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionHoteles implements IGestionHotelLocal, IGestionHotelRemote, IInfoHotelLocal, IInfoHotelRemote {
	
	@EJB
	private IHotelesDAOLocal hotelesDAO;
	
	public GestionHoteles() {
		
	}
	
	public GestionHoteles(IHotelesDAOLocal hotelesDAO) {
		this.hotelesDAO = hotelesDAO;
	}
	
	public Habitacion anhadirTipoHabitacion(String tipo, double precioPorNoche, int numDisponibles, Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modificarPrecio(List<Habitacion> habitaciones, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Hotel> consultarHoteles(String nombre, String localidad) {
		
		List<Hotel> hoteles = hotelesDAO.hoteles();
		List<Hotel> hotelesCopia = new ArrayList<Hotel>(hoteles);
		
		if (nombre != null && !nombre.isEmpty()) {
			for(Hotel h : hoteles) {
				if (!h.getNombre().equals(nombre)) {
					hotelesCopia.remove(h);
				}
			}
		}
		
		if (localidad != null && !localidad.isEmpty() ) {
			for(Hotel h : hoteles) {
				if (!h.getLocalidad().equals(localidad)) {
					hotelesCopia.remove(h);
				}
			}
		}
		
		return hotelesCopia;
	}

	public List<Habitacion> consultarDisponibilidad(String nombre, String localidad, LocalDate fechaIni, LocalDate fechaFin) {
		/*
		if (fechaFin.isBefore(fechaIni)) {
			return null;
		}
		*/
		return hotelesDAO.hotel(nombre, localidad).getHabitaciones();
	}

	public List<Habitacion> consultarHotel(Hotel hotel) {
		return hotelesDAO.hotel(hotel.getNombre(), hotel.getLocalidad()).getHabitaciones();
	}
}
