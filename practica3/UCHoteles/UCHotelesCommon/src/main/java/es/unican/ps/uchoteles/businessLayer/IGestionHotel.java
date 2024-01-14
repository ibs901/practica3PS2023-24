package es.unican.ps.uchoteles.businessLayer;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.uchoteles.entities.*;

public interface IGestionHotel {
	
	public List<Hotel> consultarHoteles(String nombre, String localidad);
	public List<Habitacion> consultarDisponibilidad(String nombre, String localidad, LocalDate fechaEntrada, LocalDate fechaSalida);
	public List<Habitacion> consultarHotel(Hotel hotel);
}
