package app;

public class ComplexNumber {
	private double parteR, parteI, modulo, fase;
	private char forma;
	public ComplexNumber (double r , double i) {
		parteR = r;
		parteI = i;
		modulo = Math.pow(Math.pow(parteI, 2) + Math.pow(parteR, 2),0.5);
		forma = 'C';
	}
	
	/**
	 * Metodo que retorna la parte real del numero
	 * @return double que muestra la parte real del numero
	 */
	public double getPartR() {
		return parteR;
	}
	
	/**
	 * Metodo que retorna la parte imaginaria del numero
	 * @return double que muestra la parte imaginaria del numero
	 */
	public double getPartI() {
		return parteI;
	}
	
	/**
	 * Metodo que retorna la forma del numero
	 * @return double que muestra la forma del numero
	 */
	public char getForma() {
		return forma;
	}
	
	/**
	 * Metodo que cambia la parte imaginaria del numero
	 * @param a double por el cual se va a cambiar la parte imaginaria
	 */
	public void setPartI(double a) {
		parteI = a;
	}
	
	/**
	 * Metodo que cambia la parte real del numero
	 * @param a double por el cual se va a cambiar la parte real
	 */
	public void setPartR(double a) {
		parteR = a;
	}
	
	/**
	 * Metodo que cambia la forma del numero
	 * @param form forma por la cual se va a cambiar el numero 
	 */
	public void cambiarForma(char form) {
		forma = form;
	}
	
	/**
	 * Metodo que retorna el modulo del numero
	 * @return modulo double el cual dice el modulo del numero
	 */
	public double modulo() {
		return modulo;
	}
	
	/**
	 * Metodo que retorna la fase del numero
	 * @return fase double fase del numero
	 */
	public double fase() {
		if(forma == 'C') {
			fase = Math.atan(parteI/parteR);
			return fase;
		}
		else {
			fase = parteR;
			return fase;
		}
	}
	
	/**
	 * Metodo que compara si dos numeros complejos son iguales
	 * @param c Numero Complejo el cual se va a comparar
	 * @return Boolean que dice si el numero es igual al dado
	 */
	public boolean equals(ComplexNumber c) {
		if(c.getPartR() == parteR && c.getPartI() == parteI) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
