package es.unican.ps.uchoteles.daoLayer;

import java.util.List;

import es.unican.ps.uchoteles.entities.Hotel;

public interface IHotelesDAO {

	public Hotel creaHotel(Hotel hotel);
	public Hotel eliminaHotel(String nombre, String localidad);
	public Hotel actualizarHotel(Hotel hotel);
	public Hotel hotel(String nombre, String localidad);
	public List<Hotel> hoteles();
}
