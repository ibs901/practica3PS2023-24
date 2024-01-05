package es.unican.ps.hoteles.businessLayer.impl;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.hoteles.businessLayer.IGestionHotel;
import es.unican.ps.hoteles.businessLayer.IInfoHotel;
import es.unican.ps.hoteles.daoLayer.IHotelesDAO;
import es.unican.ps.hoteles.entities.Hotel;
import es.unican.ps.hoteles.entities.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionHoteles implements IGestionHotel, IInfoHotel {

	@EJB
	private IHotelesDAO hotelesDAO;
	
	public TipoHabitacion anhadirTipoHabitacion(String tipo, double precioPorNoche, int numDisponibles, Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modificarPrecio(List<TipoHabitacion> tiposHabitacion, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Hotel> consultarDisponibilidad(String nombre, String localidad, LocalDate fechaIni,
			LocalDate fechaFin) {
		
		if (fechaFin.isBefore(fechaIni)) {
			return null;
		}
		
		List<Hotel> hoteles = hotelesDAO.hoteles();
		
		if (nombre != null) {
			for(Hotel h : hoteles) {
				if (h.getNombre() != nombre) {
					hoteles.remove(h);
				}
			}
		}
		
		if (localidad != null) {
			for(Hotel h : hoteles) {
				if (h.getLocalidad() != localidad) {
					hoteles.remove(h);
				}
			}
		}
		
		return hoteles;
	}

	public List<TipoHabitacion> consultarHotel(Hotel hotel) {
		Hotel aux = null;
		
		if (hotel.getNombre() != null) {
			aux = hotelesDAO.hotelPorNombre(hotel.getNombre());
		} 
		
		if (hotel.getLocalidad() != null) {
			if (aux != null && 
					!aux.equals(hotelesDAO.hotelPorLocalidad(hotel.getLocalidad()))) {
				// Mensaje de error
				return null;
			}
			aux = hotelesDAO.hotelPorLocalidad(hotel.getLocalidad());
		}
		
		return aux.getHabitaciones();
	}	
}
