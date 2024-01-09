package es.unican.ps.uchoteles.businessLayer;

import java.util.List;

import es.unican.ps.uchoteles.entities.*;

public interface IInfoHotel {

	public TipoHabitacion anhadirTipoHabitacion(String tipo, double precioPorNoche, int numDisponibles, Hotel hotel);
	public boolean modificarPrecio(List<TipoHabitacion> tiposHabitacion, Hotel hotel);
}
