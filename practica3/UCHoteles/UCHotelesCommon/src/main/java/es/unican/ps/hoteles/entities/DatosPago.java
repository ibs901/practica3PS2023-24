package es.unican.ps.hoteles.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="DatosPagos")
public class DatosPago implements Serializable {
	
	private int numTarjeta;
	private int cvc;
	private int mesCaducidad;
	private int anhoCaducidad;
	
	@Enumerated(EnumType.STRING)
	private TipoTarjeta tipo;
	
	public DatosPago() {
		
	}
	
	public DatosPago(int numTarjeta, int cvc, int mesCaducidad, int anhoCaducidad) {
		this.numTarjeta = numTarjeta;
		this.cvc = cvc;
		this.mesCaducidad = mesCaducidad;
		this.anhoCaducidad = anhoCaducidad;
	}
	
	public int getNumTarjeta() {
		return numTarjeta;
	}
	
	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	
	public int getCvc() {
		return cvc;
	}
	
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	
	public int getMesCaducidad() {
		return mesCaducidad;
	}
	
	public void setMesCaducidad(int mesCaducidad) {
		this.mesCaducidad = mesCaducidad;
	}
	
	public int getAnhoCaducidad() {
		return anhoCaducidad;
	}
	
	public void setAnhoCaducidad(int anhoCaducidad) {
		this.anhoCaducidad = anhoCaducidad;
	}

	public TipoTarjeta getTipo() {
		return tipo;
	}

	public void setTipo(TipoTarjeta tipo) {
		this.tipo = tipo;
	}
}
