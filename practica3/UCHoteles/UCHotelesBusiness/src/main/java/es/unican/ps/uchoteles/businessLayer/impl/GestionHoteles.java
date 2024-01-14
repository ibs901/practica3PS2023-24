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
import es.unican.ps.uchoteles.entities.TipoHabitacion;
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
	
	public Habitacion anhadirTipoHabitacion(TipoHabitacion tipo, double precioPorNoche, int numDisponibles, Hotel hotel) {
		List<Habitacion> habitaciones = consultarHotel(hotel);
		Habitacion h = new Habitacion(tipo, precioPorNoche, numDisponibles);
		habitaciones.add(h);
		hotelesDAO.actualizarHotel(hotel);
		return h;
	}

	public boolean modificarPrecio(List<Habitacion> habitaciones, Hotel hotel) {
		List<Habitacion> habitacionesAntiguas = consultarHotel(hotel);
		
		if (habitacionesAntiguas == null) {
			return false;
		}
		
		for (int i = 0; i < habitaciones.size(); i++) {
			double precioAntiguo = habitacionesAntiguas.get(i).getPrecioPorNoche();
			double precioNuevo = habitaciones.get(i).getPrecioPorNoche();
			if (precioAntiguo != precioNuevo) {
				habitacionesAntiguas.get(i).setPrecioPorNoche(precioNuevo);
			}
		}
		
		hotelesDAO.actualizarHotel(hotel);
		
		return true;
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
		
		if (fechaFin.isBefore(fechaIni)) {
			return null;
		}

		return hotelesDAO.hotel(nombre, localidad).getHabitaciones();
	}

	public List<Habitacion> consultarHotel(Hotel hotel) {
		Hotel h = hotelesDAO.hotel(hotel.getNombre(), hotel.getLocalidad());
		if (h == null) {
			return null;
		}
		return h.getHabitaciones();
	}
}
