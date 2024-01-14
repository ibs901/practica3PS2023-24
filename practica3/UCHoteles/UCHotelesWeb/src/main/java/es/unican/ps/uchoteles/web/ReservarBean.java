package es.unican.ps.uchoteles.web;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.unican.ps.uchoteles.businessLayer.IGestionHotelRemote;
import es.unican.ps.uchoteles.businessLayer.IGestionReservaRemote;
import es.unican.ps.uchoteles.entities.DatosCliente;
import es.unican.ps.uchoteles.entities.DatosPago;
import es.unican.ps.uchoteles.entities.Habitacion;
import es.unican.ps.uchoteles.entities.Hotel;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ReservarBean {
	
	@EJB
	private IGestionHotelRemote gestionHoteles;
	
	@EJB
	private IGestionReservaRemote gestionReservas;
	
	private String nombre;
	private String localidad;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private Date fechaIniDate;
	private Date fechaFinDate;
	private List<Hotel> hoteles;
	private List<Habitacion> habitaciones;
	
	private double importe;
	private Hotel hotel;
	private Map<Habitacion, Integer> reservasPorTipo = new HashMap<Habitacion, Integer>();
	private String dni;
	private int numTarjeta;
	private long idReserva;
	
	public ReservarBean() {
		
	}
	
	public String consultarHoteles() {
		hoteles = gestionHoteles.consultarHoteles(nombre, localidad);
		return "listaHoteles.xhtml";
	}
	
	public String consultarDisponibilidad(String nombre, String localidad) {
		this.nombre = nombre;
		this.localidad = localidad;
		habitaciones = gestionHoteles.consultarDisponibilidad(nombre, localidad, fechaIni, fechaFin);
		return "habitacionesHotel.xhtml";
	}
	
	public String consultarDisponibilidad() {
		this.nombre = "Bahia";
		this.localidad = "Santander";
		habitaciones = gestionHoteles.consultarDisponibilidad(nombre, localidad, fechaIni, fechaFin);
		
		return "habitacionesHotel.xhtml";
	}

	public String reservar() {
		hotel = new Hotel(nombre, localidad);
		importe = gestionReservas.reservar(hotel, reservasPorTipo, fechaIni, fechaFin);
		return "datosReserva.xhtml";
	}
	
	public String confirmarReserva() {
		DatosCliente datosCliente = new DatosCliente(dni, nombre);
		DatosPago datosPago = new DatosPago(numTarjeta);
		
		System.out.println("reservasPorTipoBean:" + reservasPorTipo);

		setIdReserva(gestionReservas.confirmarReserva(hotel, reservasPorTipo, datosCliente, datosPago, fechaIni, fechaFin, importe));
		return "confirmacionReserva.xhtml";
	}
	
	public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public Date getFechaIniDate() {
        return fechaIniDate;
    }

    public void setFechaIniDate(Date fechaIniDate) {
    	this.fechaIniDate = fechaIniDate;
        this.fechaIni = fechaIniDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public Date getFechaFinDate() {
        return fechaFinDate;
    }

    public void setFechaFinDate(Date fechaFinDate) {
    	this.fechaFinDate = fechaFinDate;
        this.fechaFin = fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}
	
	public Map<Habitacion, Integer> getReservasPorTipo() {
		return reservasPorTipo;
	}
	
	public void setReservasPorTipo(Map<Habitacion, Integer> reservasPorTipo) {
		this.reservasPorTipo = reservasPorTipo;
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
}
