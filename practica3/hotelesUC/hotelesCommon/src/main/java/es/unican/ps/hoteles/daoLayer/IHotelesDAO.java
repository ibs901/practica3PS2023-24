package es.unican.ps.hoteles.daoLayer;

import java.util.List;

import es.unican.ps.hoteles.entities.Hotel;

public interface IHotelesDAO {

	public Hotel creaHotel(Hotel hotel);
	public Hotel eliminaHotel(String idHotel);
	public Hotel actualizarHotel(Hotel hotel);
	public Hotel hotel(String idHotel);
	public List<Hotel> hoteles();
}
