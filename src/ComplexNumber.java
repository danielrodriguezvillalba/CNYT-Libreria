
public class ComplexNumber {
	private double parteR, parteI, modulo, fase;
	private char forma;
	public ComplexNumber (double r , double i) {
		parteR = r;
		parteI = i;
		modulo = Math.pow(Math.pow(parteI, 2) + Math.pow(parteR, 2),0.5);
		forma = 'C';
	}
	
	public double getPartR() {
		return parteR;
	}
	
	public double getPartI() {
		return parteI;
	}
	
	public char getForma() {
		return forma;
	}
	
	public void setPartI(double a) {
		parteI = a;
	}
	
	public void setPartR(double a) {
		parteR = a;
	}
	
	public void cambiarForma(char form) {
		forma = form;
	}
	public double modulo() {
		return modulo;
	}
	public double fase() {
		if(forma == 'C') {
			fase = Math.atan(parteI/parteR);
			return fase;
		}
		else {
			return fase;
		}
	}
}
