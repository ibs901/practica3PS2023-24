package es.unican.ps.calculadora.negocio;

import jakarta.ejb.Remote;

@Remote
public interface ICalculatorRemote {
	
	 public double add(double i, double j);
	 public double subtract(double i, double j);
	 public double multiply(double i, double j);
	 public double divide(double i, double j);
	 	 
}
