package es.unican.ps.uchoteles.businessLayer;

import java.util.List;

import es.unican.ps.uchoteles.entities.*;

public interface IInfoHotel {

	public Habitacion anhadirTipoHabitacion(String tipo, double precioPorNoche, int numDisponibles, Hotel hotel);
	public boolean modificarPrecio(List<Habitacion> tiposHabitacion, Hotel hotel);
}
