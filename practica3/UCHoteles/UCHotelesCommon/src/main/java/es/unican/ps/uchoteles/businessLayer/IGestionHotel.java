package es.unican.ps.uchoteles.businessLayer;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.uchoteles.entities.*;

public interface IGestionHotel {
	
	public List<Hotel> consultarDisponibilidad(String nombre, String localidad, LocalDate fechaIni, LocalDate fechaFin);
	public List<TipoHabitacion> consultarHotel(Hotel hotel);
}
