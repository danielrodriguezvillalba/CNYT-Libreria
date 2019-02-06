package app;


public class Library {
	
	public Library() {
	}
	
	/**
	 * Metodo que suma dos numeros complejos
	 * @param num1 numero 1 el cual se va a sumar
	 * @param num2 numero 2 el cual se va a sumar
	 * @return ComplexNumber resultante
	 */
	public static ComplexNumber suma(ComplexNumber num1, ComplexNumber num2) {
		double sumaR = num1.getPartR()+num2.getPartR();
		double sumaI = num1.getPartI()+num2.getPartI();
		ComplexNumber suma = new ComplexNumber(sumaR,sumaI,'C');
		return suma;
	}
	
	/**
	 * Metodo que realiza el producto de dos complejos
	 * @param num1 numero 1 el cual se va a multiplicar
	 * @param num2 numero 2 el cual se va a multiplicar
	 * @return ComplexNumber resultante
	 */
	public static ComplexNumber producto(ComplexNumber num1, ComplexNumber num2) {
		double multR = (num1.getPartR()*num2.getPartR())+(-1*(num1.getPartI()*num2.getPartI()));
		double multI = (num1.getPartR()*num2.getPartI())+(num1.getPartI()*num2.getPartR());
		ComplexNumber producto = new ComplexNumber(multR,multI,'C');
		return producto;
	}
	
	/**
	 * Metodo que realiza la resta de dos complejos
	 * @param num1 numero 1 el cual se va a restar
	 * @param num2	numero 2 el cual se va a restar
	 *  @return ComplexNumber resultante
	 */
	public static ComplexNumber resta(ComplexNumber num1, ComplexNumber num2){
		double restaR = num1.getPartR()-num2.getPartR();
		double restaI = num1.getPartI()-num2.getPartI();
		ComplexNumber resta = new ComplexNumber(restaR,restaI,'C');
		return resta;
	}
	
	/**
	 * Metodo que realiza la division de dos complejos
	 * @param num1 numero 1 el cual se va a dividir
	 * @param num2 numero 2 por el cual se va a dividir
	 * @return ComplexNumber resultante
	 */
	public static ComplexNumber division(ComplexNumber num1, ComplexNumber num2) {
		double divisor =Math.pow(num1.getPartI(), 2)+  Math.pow(num2.getPartI(), 2);
		double mult1 = num1.getPartR()*num1.getPartI() + num2.getPartR()*num2.getPartI();
		double mult2 = num1.getPartI()*num2.getPartR() - num1.getPartR()*num2.getPartI();
		ComplexNumber division = new ComplexNumber((mult1/divisor),(mult2/divisor),'C');
		return division;
	}
	
	/**
	 * Metodo que retorna la suma de los dos complejos
	 * @param numero el cual se le va a pedir su modulo
	 * @return numero double el cual es el modulo del numero dado
	 */
	public static double modulo(ComplexNumber num) {
		return num.modulo();
	}
	
	/**
	 * Metodo que cambia de forma el numero complejo, es decir si esta en coordenadas cartesianas las pasa a polares
	 * @param num numero al cual se le va a cambiar las coordenadas
	 */
	public static void cambiarForma(ComplexNumber num) {
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
	 * Metodo que suma dos vectores de complejos
	 * @param vector1 Vector 1 a ser sumado
	 * @param vector2 Vector 2 a ser sumado
	 * @return vector resultante de la suma de dos vectores dados
	 */
	public static ComplexNumber[][] sumaMatrices(ComplexNumber[][] matr1 ,ComplexNumber[][] matr2 ) {
		if(matr1.length == matr2.length && matr1[0].length == matr2[0].length ) {
			ComplexNumber[][] resultado = new ComplexNumber [matr1.length][matr1[0].length];
			for (int c = 0; c<matr1.length ; c++) {
				for (int f = 0; f<matr1[c].length ; f++) {
					ComplexNumber sum = suma(matr1[c][f],matr2[c][f]);
					resultado[c][f] = sum;
				}
			}
			return resultado;
		}
		else {
			return null;
		}
	}
	/**
	 * Metodo que retorna el inverso de un vector
	 * @param vector Vector de complejos el cual se va a sacar el inverso
	 * @return Vector inverso del vector dado
	 */
	public static ComplexNumber[][] inverso(ComplexNumber[][] vector) {
		if(vector.length > 0) {
			ComplexNumber[][] resultado = new ComplexNumber [vector.length][vector[0].length];
			for (int c = 0; c<vector.length ; c++) {
				for (int f = 0; f<vector[0].length ; f++) {
					ComplexNumber inv = inverso(vector[c][f]);
					resultado[c][f] = inv;
				}
			}
			return resultado;
		}
		else {
			return null;
		}
	}
	/**
	 * Metodo que retorna el inverso de un numero complejo
	 * @param c Numero complejo el cual se le va a sacar el inverso
	 * @return Numero complejo resultante del inverso del complejo dado
	 */
	private static ComplexNumber inverso(ComplexNumber c) {
		ComplexNumber inverso = new ComplexNumber(c.getPartR()*-1,c.getPartI()*-1,c.getForma());
		return inverso;
	}
	
	/**
	 * Metodo que retorna el conjugado del complejo dado
	 * @param num numero complejo al cual se le va a sacar su conjugado
	 * @return numero conjugado del numero dado
	 */
	public static ComplexNumber conjugado(ComplexNumber num) {
		ComplexNumber c = new ComplexNumber(num.getPartR(),num.getPartI()*-1,num.getForma());
		return c;
	}
	/**
	 * Metodo que hace el producto escalar entre un vector y un numero complejo
	 * @param vector Vector por el cual se va a multiplicar el escalar
	 * @param num Numero complejo por el cual se va a multiplicar el vector
	 * @return vector resultante de la multiplicacion escalar
	 */
	public static ComplexNumber[][] productoEscalar(ComplexNumber[][] vector, ComplexNumber num) {
		if(vector.length > 0) {
			ComplexNumber[][] resultado = new ComplexNumber [vector.length][vector[0].length];
			for (int c = 0; c<vector.length ; c++) {
				for (int f = 0; f<vector[0].length ; f++) {
					ComplexNumber prod = producto(vector[c][f], num);
					resultado[c][f] = prod;
				}
			}
			return resultado;
		}
		else return null;
	}
	
	public static ComplexNumber[][] productoEntreMatrices(ComplexNumber[][] matr1, ComplexNumber[][] matr2){
		if(matr1.length == matr2.length && matr1[0].length == matr2.length ) {
			ComplexNumber[][] resultado = new ComplexNumber [matr1.length][matr1.length];
			for (int cr = 0; cr<resultado.length ; cr++) {
				for (int fr = 0; fr<resultado[0].length ; fr++) {
					for (int m = 0; m<resultado.length ; m++) {
						
					}
					resultado[cr][fr]= null;
				}
			}
			return resultado;
		}
		else return null;
	}
}
