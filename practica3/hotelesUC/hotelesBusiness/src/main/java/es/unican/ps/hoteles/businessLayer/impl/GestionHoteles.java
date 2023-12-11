package es.unican.ps.hoteles.businessLayer.impl;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.hoteles.businessLayer.IGestionHotel;
import es.unican.ps.hoteles.businessLayer.IInfoHotel;
import es.unican.ps.hoteles.entities.Hotel;
import es.unican.ps.hoteles.entities.TipoHabitacion;

public class GestionHoteles implements IGestionHotel, IInfoHotel {

	public TipoHabitacion anhadirTipoHabitacion(String tipo, double precioPorNoche, int numDisponibles, Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modificarPrecio(List<TipoHabitacion> tiposHabitacion, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<TipoHabitacion> consultarDisponibilidadPorLocaliad(String localidad, LocalDate fechaIni,
			LocalDate fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TipoHabitacion> consultarDisponibilidadPorNombre(String nombre, LocalDate fechaIni,
			LocalDate fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Hotel> consultarHoteles() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
