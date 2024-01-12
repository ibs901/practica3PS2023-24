package es.unican.ps.uchoteles.web;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import es.unican.ps.uchoteles.businessLayer.IGestionHotelRemote;
import es.unican.ps.uchoteles.entities.Hotel;
import es.unican.ps.uchoteles.entities.TipoHabitacion;
import es.unican.ps.uchoteles.entities.Habitacion;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class GestionHotelesBean {
	
	@EJB
	private IGestionHotelRemote gestionHoteles;
	
	private String nombre;
	private String localidad;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private Date fechaIniDate;
	private Date fechaFinDate;
	private List<Hotel> hoteles;
	private List<Habitacion> habitaciones;
	
	
	public GestionHotelesBean() {
		
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
		this.nombre = "Torresport";
		this.localidad = "Torrelavega";
		habitaciones = gestionHoteles.consultarDisponibilidad(nombre, localidad, fechaIni, fechaFin);
		
		/*
		habitaciones.add(new Habitacion(TipoHabitacion.INDIVIDUAL, 50.0, 5));
		habitaciones.add(new Habitacion(TipoHabitacion.DOBLE, 100.0, 5));
		*/

	
		return "habitacionesHotel.xhtml";
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
}
