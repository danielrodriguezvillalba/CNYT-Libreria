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
	 * Metodo que suma dos Matrices de complejos
	 * @param matr1 Matriz 1 a ser sumado
	 * @param matr2 Matriz 2 a ser sumado
	 * @return Matriz resultante de la suma de dos vectores dados
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
	 * Metodo que resta dos matrices de complejos
	 * @param vector1 Matriz 1 a ser restado
	 * @param vector2 Matriz 2 a ser restado
	 * @return vector resultante de la resta de dos vectores dados
	 */
	public static ComplexNumber[][] restaMatrices(ComplexNumber[][] vect1 ,ComplexNumber[][] vect2 ) {
		if(vect1.length == vect2.length && vect1[0].length == vect2[0].length) {
			ComplexNumber[][] resultado = new ComplexNumber [vect1.length][vect2[0].length];
			for (int c = 0; c<vect1.length ; c++) {
				for (int f = 0; f<vect1[0].length ; f++) {
					ComplexNumber res = resta(vect1[c][f],vect2[c][f]);
					resultado[c][f] = res;
				}
			}
			return resultado;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Metodo que resta dos vectores de complejos
	 * @param vector1 vector 1 a ser restado
	 * @param vector2 vector 2 a ser restado
	 * @return vector resultante de la resta de dos vectores dados
	 */
	public static ComplexNumber[] restaVectores(ComplexNumber[] vect1 ,ComplexNumber[]vect2 ) {
		if(vect1.length == vect2.length) {
			ComplexNumber[] resultado = new ComplexNumber [vect1.length];
			for (int c = 0; c<vect1.length ; c++) {
					ComplexNumber res = resta(vect1[c],vect2[c]);
					resultado[c] = res;
			}
			return resultado;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Metodo que retorna el inverso de una matriz
	 * @param matr Matriz de complejos el cual se va a sacar el inverso
	 * @return Matriz inversa de la dada
	 */
	public static ComplexNumber[][] inverso(ComplexNumber[][] matr) {
		if(matr.length > 0) {
			ComplexNumber[][] resultado = new ComplexNumber [matr.length][matr[0].length];
			for (int c = 0; c<matr.length ; c++) {
				for (int f = 0; f<matr[0].length ; f++) {
					ComplexNumber inv = inverso(matr[c][f]);
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
	
	
	/**
	 * Metodo que multiplica dos matrices dadas
	 * @param matr1 Matriz 1 a multiplicar 
	 * @param matr2 Matriz 2 a multiplicar
	 * @return Matriz resultante de la multiplicacion de las dos dadas, null si no se pueden multiplicar
	 */
	public static ComplexNumber[][] productoEntreMatrices(ComplexNumber[][] matr1, ComplexNumber[][] matr2){
		if(matr1.length == matr2.length && matr1[0].length == matr2.length ) {
			ComplexNumber [][] resultado= new ComplexNumber [matr1.length][matr2[0].length];
			if (matr1[0].length == matr2.length) {
		        for (int i = 0; i < matr1.length; i++) {
		            for (int j = 0; j < matr2[0].length; j++) {
		                for (int k = 0; k < matr1[0].length; k++) {
		                	if (resultado[i][j] == null) {
		                		ComplexNumber num = new ComplexNumber(0,0,'C');
		                		resultado[i][j] = suma(num,producto(matr1[i][k], matr2[k][j]));
		                	}
		                	else { resultado[i][j] = suma(resultado[i][j],producto(matr1[i][k], matr2[k][j]));}
		                }
		            }
		        }
		    }
			return resultado;
		}
		else return null;
	}
	
	/**
	 * Metodo que multiplica dos vectores dadas
	 * @param vect1 Vector 1 a multiplicar 
	 * @param vect2 Vector 2 a multiplicar
	 * @return Matriz resultante de la multiplicacion de las dos dadas, null si no se pueden multiplicar
	 */
	public static ComplexNumber[] productoEntreVectores(ComplexNumber[] vect1, ComplexNumber[] vect2){
		if(vect1.length == vect2.length) {
			ComplexNumber [] resultado= new ComplexNumber [vect1.length];
		        for (int i = 0; i < vect1.length; i++) {
		            resultado[i] = producto(vect1[i], vect2[i]);
		       }	
			return resultado;
		}
		else return null;
	}
	
	/**
	 * Metodo que encuentra el estado siguiente dado un estado inicial
	 * @param matrBool Matriz a ver su comportamiento
	 * @param vect Estado inicial el cual inicia
	 */
	public static ComplexNumber[] accionVectorMatriz(double[][] matrBool, ComplexNumber[] vect) {
		if (vect.length == matrBool[0].length) {
			ComplexNumber[] resultado = new ComplexNumber[matrBool[0].length];
	        for (int i = 0; i < matrBool.length; i++) {
	        	ComplexNumber temp = new ComplexNumber(0,0,'C');;
	            for (int j = 0; j < matrBool[0].length; j++) {
	            	ComplexNumber var = new ComplexNumber(matrBool[i][j],0,'C');
	            	temp = suma(temp, producto(var, vect[j]));
	            }
	            resultado[i] = temp;
	        }
	        return resultado;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Metodo que encuentra el estado siguiente dado un estado inicial
	 * @param matrBool Matriz a ver su comportamiento
	 * @param vect Estado inicial el cual inicia
	 */
	public static ComplexNumber[] accionVectorMatriz(ComplexNumber[][] matrBool, ComplexNumber[] vect) {
		if (vect.length == matrBool[0].length) {
			ComplexNumber[] resultado = new ComplexNumber[matrBool[0].length];
	        for (int i = 0; i < matrBool.length; i++) {
	        	ComplexNumber temp = new ComplexNumber(0,0,'C');;
	            for (int j = 0; j < matrBool[0].length; j++) {
	            	temp = suma(temp, producto(matrBool[i][j], vect[j]));
	            }
	            resultado[i] = temp;
	        }
	        return resultado;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Metodo que calcula el producto interno de dos matrices 
	 * @param vect1 matriz 1 a multiplicar
	 * @param vect2 matriz 2 a multiplicar
	 * @return Numero complejo el cual es el producto interno de los matrices
	 */
	public static ComplexNumber productoInterno(ComplexNumber[][] vect1 , ComplexNumber[][] vect2 ) {
		if(vect1.length == vect2.length && vect1[0].length == vect2[0].length) {
			ComplexNumber[][] conjugado1 = conjugada(vect1);
			ComplexNumber acum = new ComplexNumber(0,0,'C');
	        for (int i = 0; i < vect1.length; i++) {
	        	for (int j = 0;j  < vect1[0].length; j++) {
	        		acum = suma(acum, producto(conjugado1[i][j], vect2[i][j]));
	        	}
	        }
	        return acum;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Metodo que retorna el conjugado de un vector
	 * @param vector Vector a operar
	 * @return Vector conjugado del dado
	 */
	public static ComplexNumber[] conjugadoVector(ComplexNumber[] vector) {
		ComplexNumber[] conjugado = new ComplexNumber[vector.length];
		for (int i = 0; i < vector.length; i++) {
			conjugado[i] = conjugado(vector[i]);
		}
		return conjugado;
	}
	/**
	 * Metodo que calcula el producto interno de dos matrices 
	 * @param vect1 vector 1 a multiplicar
	 * @param vect2 vector 2 a multiplicar
	 * @return Numero complejo el cual es el producto interno de los matrices
	 */
	public static ComplexNumber productoInterno(ComplexNumber[] vect1 , ComplexNumber[] vect2 ) {
		if(vect1.length == vect2.length) {
			ComplexNumber[] conjugado1 = conjugadoVector(vect1);
			ComplexNumber acum = new ComplexNumber(0,0,'C');
	        for (int i = 0; i < vect1.length; i++) {
	        		acum = suma(acum, producto(conjugado1[i], vect2[i]));
	        }
	        return acum;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Metodo que Retorna la norma de un vector de complejos
	 * @param vect Vector de complejos a sacar su norma
	 * @return Norma del vector dado
	 */
	public static double normaMatriz(ComplexNumber[][] vect) {
		if (vect.length != 0) {
			ComplexNumber norma = productoInterno(vect, vect) ;
			double res = Math.pow(norma.getPartR(),0.5);
			return res;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Metodo que Retorna la norma de un vector de complejos
	 * @param vect Vector de complejos a sacar su norma
	 * @return Norma del vector dado
	 */
	public static double normaVector(ComplexNumber[] vect) {
		if (vect.length != 0) {
			double res = 0;
			for (int i=0; i<vect.length;i++) {
				res += Math.pow(vect[i].getPartR(),2);
				res += Math.pow(vect[i].getPartI(),2);
			}
			double norm = Math.pow(res,0.5);
			return norm;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Metodo que da la distancia entre dos matrices complejos
	 * @param vect1 matriz 1 a sacar la distancia
	 * @param vect2 matriz 2 a sacar la distancia
	 * @return Complejo que indica la distancia entre las matrices
	 */
	public static double distancia(ComplexNumber[][] vect1,ComplexNumber[][] vect2) {
		if(vect1.length == vect2.length) {
			ComplexNumber[][] resta = restaMatrices(vect1, vect2);
			double inner = normaMatriz(resta);
			return inner;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Metodo que retorna la matriz transpuesta de la dada
	 * @param matr Matriz a transponer
	 * @return Matriz traspuesta de la dada
	 */
	public static ComplexNumber[][] transpuesta(ComplexNumber[][] matr){
		if (matr.length == matr[0].length ) {
			ComplexNumber[][] temp = new ComplexNumber [matr.length][matr[0].length];
			for (int i = 0; i < matr.length; i++) {
		        for (int j = 0; j < matr[0].length; j++) {
		        	temp[i][j] = matr[j][i];
		        }
			}
			return temp;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Metodo que retorna si una matriz es unitaria
	 * @param matr Matriz a verificar
	 * @return Booleano que dice si la matriz es o no unitaria
	 */
	public static boolean esUnitaria (ComplexNumber[][] matr){
		boolean var = true;
		if (matr.length == matr[0].length ) {
			for (int i = 0; i < matr.length; i++) {
		        for (int j = 0; j < matr[0].length; j++) {
		        	if(i == j) {
		        		ComplexNumber temp = new ComplexNumber(1,1,'C');
		        		if (!temp.equals(matr[i][j])) {
		        			var = false;
		        		}
		        	}
		        	else {
		        		ComplexNumber temp = new ComplexNumber(0,0,'C');
		        		if (!temp.equals(matr[i][j])) {
		        			var = false;
		        		}
		        	}
		        }
			}
			
			return var;
		}
		else {return false;}
	}
	
	/**
	 * Metodo que retorna si una matriz es Hermitiana
	 * @param matr Matriz a verificar
	 * @return Booleano que dice si la matriz es o no Hermitiana
	 */
	public static boolean esHermitiana (ComplexNumber[][] matr){
		ComplexNumber[][] her = adjunta(matr);
		boolean var = true;
		for (int i = 0; i < matr.length; i++) {
	        for (int j = 0; j < matr[0].length; j++) {
	        	if(!matr[i][j].equals(her[i][j])) {
	        		var = false;
	        	}
	        }
		}
		return var;
	}
	
	/**
	 * Metodo que retorna el producto tensor de dos matrices
	 * @param matr1 Matriz 1 a sacar su producto tensor
	 * @param matr2 Matriz 2 a sacar su producto tensor
	 * @return Matriz resultante del producto tensor
	 */
	public static ComplexNumber[][] productoTenssor (ComplexNumber[][] matr1,ComplexNumber[][] matr2){
		ComplexNumber[][] prod = new ComplexNumber [matr1.length*matr2.length][matr1[0].length*matr2[0].length];
	    for (int i = 0; i < matr1.length; i++) { 
	        for (int k = 0; k < matr1[i].length; k++) { 
	            for (int j = 0; j < matr2.length; j++) { 
	                for (int l = 0; l < matr2[j].length; l++) {
	                	prod[matr2.length*i + j ][ matr2[j].length*k + l] = producto(matr1[i][k], matr2[j][l]);	                     
	                } 
	            }
	        } 
	    }
		return prod;
	}
	
	/**
	 * Metodo que retorna la conjugada de una matriz dada
	 * @param matr Matriz sacar su conjugada
	 * @return Matriz transpuesta de la dada
	 */
	public static ComplexNumber[][] conjugada(ComplexNumber[][] matr){
		ComplexNumber[][] temp = new ComplexNumber [matr.length][matr[0].length];
		for (int i = 0; i < matr.length; i++) { 
		       for (int k = 0; k < matr[0].length; k++) {
		    	   temp[i][k] = conjugado(matr[i][k]);
		       }
		 }
		return temp ;
	}
	
	/**
	 * Metodo que retorna la adjunta de una matriz dada
	 * @param matr Matriz a la cual devolver su adjunta
	 * @return Matriz adjunta de la dada
	 */
	public static ComplexNumber[][] adjunta (ComplexNumber[][] matr){
		ComplexNumber[][] temp = transpuesta(matr);
		temp = conjugada(temp);
		return temp;
	}
	
	/**
	 * Metodo que calcula el estado de las canicas en el numero de clicks dado
	 * @param matrBool Matriz Booleana en la cual se conocen los caminos de las canicas
	 * @param initialState Estado inicial de las canicas 
	 * @param clicks Numero de clicks en los cuales se va a calcular su estado
	 * @return Estado final de las canicas despues de n Clicks
	 */
	public static ComplexNumber[] canicasCoeficientesComplejos(double[][] matrBool,ComplexNumber[] initialState,int clicks ) {
		ComplexNumber[] res ;
			ComplexNumber[] temp = initialState;
			for (int i = 0; i < clicks; i++) { 
				res = accionVectorMatriz(matrBool, temp);
				temp = res;
			}
		return temp;
	}
	
	/**
	 * Metodo que dice si una matriz es booleana
	 * @param matr Matriz A verificar 
	 * @return Booleano que indica si la matriz es booleana o no
	 */
	private static boolean esBooleana(int[][] matr) {
		boolean bandera = true;
		for (int i = 0; i < matr.length; i++) { 
	        for (int j = 0; j < matr[0].length; j++) {
	        	if(matr[i][j]==0 || matr[i][j]==1 ) {
	        	}
	        	else {
	        		bandera = false;
	        	}
	        }
		}
		return bandera;
	}
	
	/**
	 * Metodo que simula el experimento de multiples rendijas
	 * @param matr Matriz de probabilidades para que pase por dicho camino 
	 * @param numClicks numero de clicks que se quiere hacer la simulacion
	 * @param target Numero de objetivos a los cuales le daran las balas
	 * * @param state estado inicial de el experimento
	 * @return Matriz de probabilidades resultante despues de el numero de clicks dados
	 */
	public static ComplexNumber[] multiplesRendijas(double[][] matr,int numClicks,int target,ComplexNumber[] state){
		//if() {
		double[][] temp = matr;
		for (int i = 0; i < target; i++) { 
			temp = multiplicacionEntreMatricesDeProbabilidades(temp, matr);
		}
		ComplexNumber[] result = state;
		for (int i = 0; i < numClicks; i++) {
			result = accionVectorMatriz(temp,result);
		}
		return result;
	}
	
	/**
	 * Metodo que multiplica dos matrices de probabilidades dadas
	 * @param matr1 Matriz 1 a multiplicar 
	 * @param matr2 Matriz 2 a multiplicar 
	 * @return Matriz resultante de la multiplicacion de las dos dadas
	 */
	private static double[][] multiplicacionEntreMatricesDeProbabilidades(double[][] matr1,double[][] matr2){
		double [][] resultado= new double [matr1.length][matr2[0].length];
		if (matr1[0].length == matr2.length) {
	        for (int i = 0; i < matr1.length; i++) {
	            for (int j = 0; j < matr2[0].length; j++) {
	                for (int k = 0; k < matr1[0].length; k++) {
	                	if (resultado[i][j] == 0) {
	                		double num = 0;
	                		resultado[i][j] = num+(matr1[i][k]* matr2[k][j]);
	                	}
	                	else { resultado[i][j] = resultado[i][j]+(matr1[i][k]* matr2[k][j]);}
	                }
	            }
	        }
	    }
		return resultado;
	}
	
	/**
	 * Metodo que simula el experimento de multiples rendijas con complejos
	 * @param matr Matriz de probabilidades para que pase por dicho camino 
	 * @param numClicks numero de clicks que se quiere hacer la simulacion
	 * @param target Numero de objetivos a los cuales le daran las balas
	 * @param state estado inicial de el experimento
	 * @return Matriz de probabilidades resultante despues de el numero de clicks dados
	 */
	public static ComplexNumber[] multiplesRendijasComplejos(ComplexNumber[][] matr,int numClicks,int target,ComplexNumber[] state){
		ComplexNumber[][] temp = matr;
		for (int i = 0; i < target; i++) { 
			temp = productoEntreMatrices(temp, matr);
		}
		ComplexNumber[] result = state;
		for (int i = 0; i < numClicks; i++) {
			result = accionVectorMatriz(temp,result);
		}
		return result;
	}
	
	/**
	 * Metodo que calcula la probabilidad de que una particula se encuentre en la posicion dada
	 * @param cantPosiciones Cantidad de posiciones que va a tener el ket dado
	 * @param posicion Posicion en la cual se calculara la probabilidad de la particula
	 * @param ket Estado inicial de la particula
	 * @return Probabilidad de que la particula este en la posicion dada
	 */
	public static double calcularProbabilidadDeParticulaEnUnaPosicionDeSistemaCuantico(int cantPosiciones, int posicion, ComplexNumber[] ket){
		double[] todasProba =calcularProbabilidadDeParticulaEnCadaPosicion(cantPosiciones,ket);
		double prob = todasProba[posicion];
		return prob;
	}
	
	/**
	 * Metodo que calcula la las probabilidades de cada posicion del ket
	 * @param numPosiciones numero de posiciones que tiene el ket
	 * @param ket Estado inicial de la particula
	 * @return arreglo de probabilidades de un ket
	 */
	public static double[] calcularProbabilidadDeParticulaEnCadaPosicion(int numPosiciones, ComplexNumber[] ket) {
		double norm = normaVector(ket);
		double[] prob = new double[ket.length];
		for(int i=0; i<ket.length; i++) {
			prob[i] = Math.pow(ket[i].modulo(),2)/Math.pow(norm,2);
		}
		return prob;
		
	}
	
	/**
	 * Metodo que calcula la distancia entre dos kets dados
	 * @param ket1 Primer ket a medir su distancia
	 * @param ket2 Segundo ket al cual se le va a medir la distancia respecto al 1
	 * @return Numero complejo resultante de la distancia de los dos kets dados
	 */
	public static double calcularDistanciaEntreKets(ComplexNumber[] ket1,ComplexNumber[] ket2) {
		if(ket1.length == ket2.length) {
			ComplexNumber[] resta = restaVectores(ket1, ket2);
			ComplexNumber amplit = productoInterno(resta, resta);
			double distancia =  Math.pow(amplit.getPartR(),0.5);
			return distancia;
		}
		else {return 0;}
	}
	
	/**
	 * Metodo que calcula la media de una matriz  y un vector
	 * @param matr Matriz hermitiana dada 
	 * @param ket Ket dado para hallar la media 
	 * @return Numero complejo el cual indica la media entre la matriz y el vector dado
	 */
	public static ComplexNumber calcularLaMedia(ComplexNumber[][] matr, ComplexNumber[] ket) {
		if(esHermitiana(matr)) {
			ComplexNumber[] res = accionVectorMatriz(matr, ket);
			ComplexNumber media = productoInterno(res, ket);
			return media;
		}
		else return null;
	}
	
	/**
	 * Metodo que retorna la varianza de un observable y un ket
	 * @param observable Observable dado para hacer el calculo
	 * @param ket ket dado para hacer el calculo
	 * @return Varianza calculada entre el observable y el ket
	 */
	public static ComplexNumber calcularVarianza(ComplexNumber[][] observable, ComplexNumber[] ket) {
		if(esHermitiana(observable)) {
			ComplexNumber media = calcularLaMedia(observable, ket);
			ComplexNumber[][] identidad = productoEscalar(observable, media);
			ComplexNumber[][] temp1 = sumaMatrices(observable,inverso(identidad));
			ComplexNumber[][] temp2 = productoEntreMatrices(temp1, temp1);
			ComplexNumber varianza = calcularLaMedia(temp2, ket);
			return varianza;
		}
		else return null;
	}
	
	/**
	 * Metodo que calcula la matriz identidad de una dada
	 * @param matriz Matriz a calcular su identidad
	 * @return Matriz identidad de la dada
	 */
	public static ComplexNumber[][] calcularMatrizIdentidad(ComplexNumber[][] matriz) {
		ComplexNumber[][] identidad = new ComplexNumber[matriz.length][matriz.length];
		if(matriz[0].length == matriz.length) {
			for(int i = 0; i<identidad.length; i++) {
				for(int j = 0; j<identidad.length; j++) {
					if(i==j) identidad[i][j] = new ComplexNumber(1,0,'C');
					else identidad[i][j] = new ComplexNumber(0,0,'C');
				}
				
			}
			return identidad;
		}
		else return null;
	}
	
}
