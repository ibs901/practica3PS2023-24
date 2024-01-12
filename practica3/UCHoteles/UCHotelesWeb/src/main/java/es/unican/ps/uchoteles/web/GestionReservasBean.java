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
	private Map<Habitacion, Integer> reservasPorTipo = new HashMap<Habitacion, Integer>();
	private String nombre;
	private String dni;
	private int numTarjeta;
	private double importe;

	
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
		importe = gestionReservas.reservar(hotel, reservasPorTipo, fechaEntrada, fechaSalida);
		return "datosReserva.xhtml";
	}
	
	public String confirmarReserva() {
		DatosCliente datosCliente = new DatosCliente(dni, nombre);
		DatosPago datosPago = new DatosPago(numTarjeta);
		gestionReservas.confirmarReserva(hotel, reservasPorTipo, datosCliente, datosPago, fechaEntrada, fechaSalida, importe);
		return "confirmacionReserva.xhtml";
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public Map<Habitacion, Integer> getReservasPorTipo() {
		return reservasPorTipo;
	}
	
	public void setReservasPorTipo(Map<Habitacion, Integer> reservasPorTipo) {
		this.reservasPorTipo = reservasPorTipo;
	}
	
	public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaIni(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}
