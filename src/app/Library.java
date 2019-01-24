package app;


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
	
	/**
	 * Metodo que suma dos numeros complejos
	 * @param num1 numero 1 el cual se va a sumar
	 * @param num2 numero 2 el cual se va a sumar
	 */
	public void suma(ComplexNumber num1, ComplexNumber num2) {
		double sumaR = num1.getPartR()+num2.getPartR();
		double sumaI = num1.getPartI()+num2.getPartI();
		suma = new ComplexNumber(sumaR,sumaI);
	}
	
	/**
	 * Metodo que realiza el producto de dos complejos
	 * @param num1 numero 1 el cual se va a multiplicar
	 * @param num2 numero 2 el cual se va a multiplicar
	 */
	public void producto(ComplexNumber num1, ComplexNumber num2) {
		double multR = (num1.getPartR()*num2.getPartR())+(-1*(num1.getPartI()*num2.getPartI()));
		double multI = (num1.getPartR()*num2.getPartI())+(num1.getPartI()*num2.getPartR());
		producto = new ComplexNumber(multR,multI);
	}
	
	/**
	 * Metodo que realiza la resta de dos complejos
	 * @param num1 numero 1 el cual se va a restar
	 * @param num2	numero 2 el cual se va a restar
	 */
	public void resta(ComplexNumber num1, ComplexNumber num2){
		double restaR = num1.getPartR()-num2.getPartR();
		double restaI = num1.getPartI()-num2.getPartI();
		resta = new ComplexNumber(restaR,restaI);
	}
	
	/**
	 * Metodo que realiza la division de dos complejos
	 * @param num1 numero 1 el cual se va a dividir
	 * @param num2 numero 2 por el cual se va a dividir
	 */
	public void division(ComplexNumber num1, ComplexNumber num2) {
		double divisor =Math.pow(num1.getPartI(), 2)+  Math.pow(num2.getPartI(), 2);
		double mult1 = num1.getPartR()*num1.getPartI() + num2.getPartR()*num2.getPartI();
		double mult2 = num1.getPartI()*num2.getPartR() - num1.getPartR()*num2.getPartI();
		division = new ComplexNumber((mult1/divisor),(mult2/divisor));
	}
	
	/**
	 * Metodo que retorna la suma de los dos complejos
	 * @return numero complejo el cual es la suma de estos
	 */
	public ComplexNumber demeSuma() {
		return suma;
	}
	
	/**
	 * Metodo que retorna la suma de los dos complejos
	 * @param numero el cual se le va a pedir su modulo
	 * @return numero double el cual es el modulo del numero dado
	 */
	public double modulo(ComplexNumber num) {
		return num.modulo();
	}
	
	/**
	 * Metodo que cambia de forma el numero complejo, es decir si esta en coordenadas cartesianas las pasa a polares
	 * @param num numero al cual se le va a cambiar las coordenadas
	 */
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
	
	/**
	 * Metodo que retorna el conjugado del complejo dado
	 * @param num numero complejo al cual se le va a sacar su conjugado
	 * @return numero conjugado del numero dado
	 */
	public ComplexNumber conjugado(ComplexNumber num) {
		ComplexNumber c = new ComplexNumber(num.getPartR(),num.getPartI()*-1);
		return c;
	}
	
	/**
	 * Metodo que retorna la resta de los dos complejos
	 * @return numero complejo el cual es la resta de estos
	 */
	public ComplexNumber demeResta() {
		return resta;
	}
	
	/**
	 * Metodo que retorna la division de los dos complejos
	 * @return numero complejo el cual es la division de estos
	 */
	public ComplexNumber demeDivision() {
		return division;
	}
	
	/**
	 * Metodo que retorna el producto de los dos complejos
	 * @return numero complejo el cual es el producto de estos
	 */
	public ComplexNumber demeProducto() {
		return producto;
	}
	
}
