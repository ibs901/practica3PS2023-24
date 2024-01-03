package es.unican.ps.hoteles.businessLayer;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.hoteles.entities.*;

public interface IGestionHotel {
	
	public List<Hotel> consultarDisponibilidad(String nombre, String localidad, LocalDate fechaIni, LocalDate fechaFin);
	public List<TipoHabitacion> consultarHotel(Hotel hotel);
}
