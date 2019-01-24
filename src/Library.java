

public class Library {
	private ComplexNumber suma,producto,resta,division;
	
	public Library(int[] num1, int[] num2) {
		ComplexNumber nume1 = new ComplexNumber(num1[0],num1[1]);
		ComplexNumber nume2 = new ComplexNumber(num2[0],num2[1]);
		suma(nume1,nume2);
		producto(nume1,nume2);
		resta(nume1,nume2);
		division(nume1,nume2);
	}
	
	public void suma(ComplexNumber num1, ComplexNumber num2) {
		double sumaR = num1.getPartR()+num2.getPartR();
		double sumaI = num1.getPartI()+num2.getPartI();
		suma = new ComplexNumber(sumaR,sumaI);
	}
	
	public void producto(ComplexNumber num1, ComplexNumber num2) {
		double multR = (num1.getPartR()*num2.getPartR())+(-1*(num1.getPartI()*num2.getPartI()));
		double multI = (num1.getPartR()*num2.getPartI())+(num1.getPartI()*num2.getPartR());
		producto = new ComplexNumber(multR,multI);
	}
	
	public void resta(ComplexNumber num1, ComplexNumber num2){
		double restaR = num1.getPartR()-num2.getPartR();
		double restaI = num1.getPartI()-num2.getPartI();
		resta = new ComplexNumber(restaR,restaI);
	}
	
	public void division(ComplexNumber num1, ComplexNumber num2) {
		double divisor =Math.pow(num1.getPartI(), 2)+  Math.pow(num2.getPartI(), 2);
		double mult1 = num1.getPartR()*num1.getPartI() + num2.getPartR()*num2.getPartI();
		double mult2 = num1.getPartI()*num2.getPartR() - num1.getPartR()*num2.getPartI();
		division = new ComplexNumber((mult1/divisor),(mult2/divisor));
	}
	
	public ComplexNumber demeSuma() {
		return suma;
	}
	
	public double modulo(ComplexNumber num) {
		return num.modulo();
	}
	
	public void cambiarForma(ComplexNumber num) {
		if (num.getForma() == ('C')){
			double temp1 = Math.pow(Math.pow(num.getPartI(), 2) + Math.pow(num.getPartR(), 2),0.5);
			double temp2 = Math.atan(num.getPartI()/num.getPartR());
			num.setPartR(temp1);
			num.setPartI(temp2);
			num.cambiarForma('P');
		}
		else {
			double temp1 = num.getPartR()* Math.cos(num.getPartI());
			double temp2 = num.getPartR()* Math.sin(num.getPartI());
			num.setPartR(temp1);
			num.setPartI(temp2);
			num.cambiarForma('C');
		}
	}
	
	public ComplexNumber conjugado(ComplexNumber num) {
		ComplexNumber c = new ComplexNumber(num.getPartR(),num.getPartI()*-1);
		return c;
	}
	
	public ComplexNumber demeResta() {
		return resta;
	}
	
	public ComplexNumber demeDivision() {
		return division;
	}
	public ComplexNumber demeProducto() {
		return producto;
	}
	
}
