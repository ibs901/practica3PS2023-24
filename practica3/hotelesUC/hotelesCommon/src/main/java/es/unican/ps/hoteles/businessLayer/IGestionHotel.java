package es.unican.ps.hoteles.businessLayer;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.hoteles.entities.*;

public interface IGestionHotel {
	
	public List<TipoHabitacion> consultarDisponibilidadPorLocaliad(String localidad, LocalDate fechaIni, LocalDate fechaFin);
	public List<TipoHabitacion> consultarDisponibilidadPorNombre(String nombre, LocalDate fechaIni, LocalDate fechaFin);
	public List<Hotel> consultarHoteles();
}
