package es.unican.ps.calculadora.web;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import es.unican.ps.calculadora.negocio.ICalculatorRemote;


@Named
@RequestScoped
public class CalculatorBean {
	
	@EJB
	private ICalculatorRemote myCalculator;
	
	private double op1;
	private double op2;
	private double result;
	
	

	public double getOp1() {
		return op1;
	}


	public void setOp1(double op1) {
		this.op1 = op1;
	}


	

	public double getOp2() {
		return op2;
	}


	public void setOp2(double op2) {
		this.op2 = op2;
	}


	public double getResult() {
		return result;
	}


	public void setResult(double result) {
		this.result = result;
	}


	public String add()  {
		result=  myCalculator.add(op1, op2);
		return "calculatorResult";
	}
	
	public String substract()  {
		result=  myCalculator.subtract(op1, op2);
		return "calculatorResult";
	}
	
	public String multiply()  {
		result=  myCalculator.multiply(op1, op2);
		return "calculatorResult";
	}
	
	public String divide()  {
		result=  myCalculator.divide(op1, op2);
		return "calculatorResult";
	}

}
