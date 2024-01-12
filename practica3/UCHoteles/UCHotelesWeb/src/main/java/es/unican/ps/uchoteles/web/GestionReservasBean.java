package es.unican.ps.uchoteles.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import es.unican.ps.uchoteles.businessLayer.IGestionReservaRemote;
import es.unican.ps.uchoteles.entities.DatosCliente;
import es.unican.ps.uchoteles.entities.DatosPago;
import es.unican.ps.uchoteles.entities.Hotel;
import es.unican.ps.uchoteles.entities.Habitacion;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class GestionReservasBean {
	
	@Inject
	private GestionHotelesBean hotelesBean;
	
	@EJB
	private IGestionReservaRemote gestionReservas;
	
	
	private Hotel hotel;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	
	public GestionReservasBean() {
		
	}
	
	@PostConstruct
	public void inicializaHotel()
	{ 
		fechaEntrada = hotelesBean.getFechaIni();
		fechaSalida = hotelesBean.getFechaFin(); 
		hotel = new Hotel(hotelesBean.getNombre(), hotelesBean.getLocalidad());
	}
	
	public String reservar() {
		Map<Habitacion, Integer> reservasPorTipo = new HashMap<Habitacion, Integer>();
		gestionReservas.reservar(hotel, reservasPorTipo, fechaEntrada, fechaSalida);
		return "datosReserva.xhtml";
	}
	
	public String confirmarReserva(Hotel hotel, Map<Habitacion, Integer> reservasPorTipo, 
			DatosCliente datosUsuario, DatosPago datosPago, LocalDate fechaEntrada,
			LocalDate fechaSalida , double importe) {
		
		return "confirmacionReserva.xhtml";
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
