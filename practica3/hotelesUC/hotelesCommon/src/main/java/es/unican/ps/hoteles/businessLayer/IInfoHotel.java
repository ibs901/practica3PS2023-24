package es.unican.ps.hoteles.businessLayer;

import java.util.List;

import es.unican.ps.hoteles.entities.*;

public interface IInfoHotel {

	public TipoHabitacion anhadirTipoHabitacion(String tipo, double precioPorNoche, int numDisponibles, Hotel hotel);
	public boolean modificarPrecio(List<TipoHabitacion> tiposHabitacion, Hotel hotel);
}
