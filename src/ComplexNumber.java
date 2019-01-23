
public class ComplexNumber {
	private int parteR, parteI;
	private double modulo;
	public ComplexNumber (int r , int i) {
		parteR = r;
		parteI = i;
		modulo = Math.pow(Math.pow(parteI, 2) + Math.pow(parteR, 2),0.5);
	}
	
	public int getPartR() {
		return parteR;
	}
	
	public int getPartI() {
		return parteI;
	}
	
	public void setPartI(int a) {
		parteI = a;
	}
	
	public void setPartR(int a) {
		parteR = a;
	}
	
	
	public double modulo() {
		return modulo;
	}
}
