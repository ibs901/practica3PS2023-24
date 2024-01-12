package es.unican.ps.uchoteles.web;

import java.time.LocalDate;
import java.util.Map;

import es.unican.ps.uchoteles.businessLayer.IGestionReservaRemote;
import es.unican.ps.uchoteles.entities.DatosCliente;
import es.unican.ps.uchoteles.entities.DatosPago;
import es.unican.ps.uchoteles.entities.Hotel;
import es.unican.ps.uchoteles.entities.Habitacion;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class GestionReservasBean {
	
	@EJB
	private IGestionReservaRemote gestionReservas;
	
	
	public String reservar(Hotel hotel, Map<Habitacion, Integer> reservasPorTipo,
			LocalDate fechaEntrada, LocalDate fechaSalida) {
		
		return "datosReserva";
	}
	
	public String confirmarReserva(Hotel hotel, Map<Habitacion, Integer> reservasPorTipo, 
			DatosCliente datosUsuario, DatosPago datosPago, LocalDate fechaEntrada,
			LocalDate fechaSalida , double importe) {
		
		return "confirmacionReserva";
	}
}
