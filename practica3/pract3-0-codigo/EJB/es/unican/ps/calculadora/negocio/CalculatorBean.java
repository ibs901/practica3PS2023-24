package es.unican.ps.calculadora.negocio;

import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class CalculatorEJB
 */
@Stateless
public class CalculatorBean implements ICalculatorRemote {

	/**
	 * Default constructor.
	 */
	public CalculatorBean() {

	}

	public double add(double i, double j) {
		return i + j;
	}

	public double subtract(double i, double j) {
		return i - j;
	}
	public double multiply(double i, double j) {
		return i * j;
	}

	public double divide(double i, double j) {
		return i / j;
	}

}
