package app;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pruebas {

	@Test
	void test() {
	}

	@Test
	public void deberiaSumar() {
		ComplexNumber num1 = new ComplexNumber(3,-1,'C');
		ComplexNumber num2 = new ComplexNumber(1,4,'C');
		ComplexNumber res = Library.suma(num1,num2);
		assertEquals(4,res.getPartR());
		assertEquals(3,res.getPartI());
	}
	
	@Test
	public void deberiaSacarElProducto() {
		ComplexNumber num1 = new ComplexNumber(3,-1,'C');
		ComplexNumber num2 = new ComplexNumber(1,4,'C');
		ComplexNumber res = Library.producto(num1, num2);
		assertEquals(7,res.getPartR());
		assertEquals(11,res.getPartI());
	}
	
	@Test
	public void deberiaRestar() {
		ComplexNumber num1 = new ComplexNumber(3,-1,'C');
		ComplexNumber num2 = new ComplexNumber(1,4,'C');
		ComplexNumber res = Library.resta(num1,num2);
		assertEquals(2,res.getPartR());
		assertEquals(-5,res.getPartI());
	}
	
	@Test
	public void deberiaDividir() {
		ComplexNumber num1 = new ComplexNumber(-2,1,'C');
		ComplexNumber num2 = new ComplexNumber(1,2,'C');
		ComplexNumber res = Library.division(num1,num2);
		assertEquals(0,res.getPartR());
		assertEquals(1,res.getPartI());
	}
	
	@Test
	public void deberiaSacarElModulo() {
		ComplexNumber num1 = new ComplexNumber(1,-1,'C');
		assertEquals(Math.pow(2, 0.5),num1.modulo());
	}
	
	@Test
	public void deberiaSacarElconjugado() {
		ComplexNumber num = new ComplexNumber(1,-1,'C');
		ComplexNumber con = Library.conjugado(num);
		assertEquals(1,con.getPartR());
		assertEquals(1,con.getPartI());
	}
	
	@Test
	public void deberiaCambiarLasCoordenadasAPolares() {
		ComplexNumber num = new ComplexNumber(1,1,'C');
		Library.cambiarForma(num);
		assertEquals(Math.pow(2, 0.5),num.getPartR());
		assertEquals(Math.atan(1),num.getPartI());
	}
	
	@Test
	public void deberiaCambiarLasCoordenadasACardinales() {
		ComplexNumber num = new ComplexNumber(Math.pow(2, 0.5),Math.atan(1),'P');
		num.cambiarForma('P');
		Library.cambiarForma(num);
		assertEquals(1,(int)(num.getPartR()));
		assertEquals(1,(int)(num.getPartI()));
	}
	
	@Test
	public void deberiaDarFaseDeUnNumeroCartesianas() {
		ComplexNumber num = new ComplexNumber(1,1,'C');
		assertEquals(Math.atan(1),num.fase());
	}
	     
	@Test
	public void deberiaDarFaseDeUnNumeroPolares() {
		ComplexNumber num = new ComplexNumber(60,1,'P');
		num.cambiarForma('P');
		assertEquals(60,num.fase());
	}
	
	@Test
	public void deberiaSumarDosMatrices() {
		ComplexNumber num1 = new ComplexNumber(1,1,'C');
		ComplexNumber num2 = new ComplexNumber(2,1,'C');
		ComplexNumber num3 = new ComplexNumber(3,2,'C');
		ComplexNumber num4 = new ComplexNumber(4,-1,'C');
		ComplexNumber num5 = new ComplexNumber(2,4,'C');
		ComplexNumber num6 = new ComplexNumber(2,6,'C');
		ComplexNumber num7 = new ComplexNumber(5,1,'C');
		ComplexNumber num8 = new ComplexNumber(12,5,'C');
		ComplexNumber num9 = new ComplexNumber(-11,5,'C');
		ComplexNumber num10 = new ComplexNumber(4,10,'C');
		ComplexNumber num11 = new ComplexNumber(5,11,'C');
		ComplexNumber num12 = new ComplexNumber(1,64,'C');
		ComplexNumber[][] matr1 = new ComplexNumber [2][3];
		ComplexNumber[][] matr2 = new ComplexNumber [2][3];
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[1][0] = num4;
		matr1[1][1] = num5;
		matr1[1][2] = num6;
		matr2[0][0] = num7;
		matr2[0][1] = num8;
		matr2[0][2] = num9;
		matr2[1][0] = num10;
		matr2[1][1] = num11;
		matr2[1][2] = num12;
		ComplexNumber[][] res = Library.sumaMatrices(matr1, matr2);
		assertEquals(6,res[0][0].getPartR());
		assertEquals(2,res[0][0].getPartI());
		assertEquals(14,res[0][1].getPartR());
		assertEquals(6,res[0][1].getPartI());
		assertEquals(-8,res[0][2].getPartR());
		assertEquals(7,res[0][2].getPartI());
		assertEquals(8,res[1][0].getPartR());
		assertEquals(9,res[1][0].getPartI());
		assertEquals(7,res[1][1].getPartR());
		assertEquals(15,res[1][1].getPartI());
		assertEquals(3,res[1][2].getPartR());
		assertEquals(70,res[1][2].getPartI());
	}
	
	@Test
	public void deberiaSacarInvesoDeUnVector() {
		ComplexNumber num1 = new ComplexNumber(1,1,'C');
		ComplexNumber num2 = new ComplexNumber(-2,3,'C');
		ComplexNumber[][] vect1 = new ComplexNumber [2][1];
		vect1[0][0] = num1;
		vect1[1][0] = num2;
		ComplexNumber[][] res = Library.inverso(vect1);
		assertEquals(-1,res[0][0].getPartR());
		assertEquals(-1,res[0][0].getPartI());
		assertEquals(2,res[1][0].getPartR());
		assertEquals(-3,res[1][0].getPartI());
	}
	
	@Test
	public void deberiaHacerMultiplicacionEscalar() {
		ComplexNumber num1 = new ComplexNumber(1,1,'C');
		ComplexNumber num2 = new ComplexNumber(2,1,'C');
		ComplexNumber num3 = new ComplexNumber(3,2,'C');
		ComplexNumber num4 = new ComplexNumber(4,-1,'C');
		ComplexNumber num5 = new ComplexNumber(2,4,'C');
		ComplexNumber num6 = new ComplexNumber(2,6,'C');
		ComplexNumber numMult = new ComplexNumber(1,3,'C');
		ComplexNumber[][] matr1 = new ComplexNumber [2][3];
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[1][0] = num4;
		matr1[1][1] = num5;
		matr1[1][2] = num6;
		ComplexNumber[][] res = Library.productoEscalar(matr1, numMult);
		assertEquals(-2,res[0][0].getPartR());
		assertEquals(4,res[0][0].getPartI());
		assertEquals(-1,res[0][1].getPartR());
		assertEquals(7,res[0][1].getPartI());
		assertEquals(-3,res[0][2].getPartR());
		assertEquals(11,res[0][2].getPartI());
		assertEquals(7,res[1][0].getPartR());
		assertEquals(11,res[1][0].getPartI());
		assertEquals(-10,res[1][1].getPartR());
		assertEquals(10,res[1][1].getPartI());
		assertEquals(-16,res[1][2].getPartR());
		assertEquals(12,res[1][2].getPartI());
	}
	
	@Test 
	public void deberiaMultiplicarDosMatrices() {
		ComplexNumber num1 = new ComplexNumber(3,2,'C');
		ComplexNumber num2 = new ComplexNumber(0,0,'C');
		ComplexNumber num3 = new ComplexNumber(5,-6,'C');
		ComplexNumber num4 = new ComplexNumber(1,0,'C');
		ComplexNumber num5 = new ComplexNumber(4,2,'C');
		ComplexNumber num6 = new ComplexNumber(0,1,'C');
		ComplexNumber num7 = new ComplexNumber(4,-1,'C');
		ComplexNumber num8 = new ComplexNumber(0,0,'C');
		ComplexNumber num9 = new ComplexNumber(4,0,'C');
		
		ComplexNumber num10 = new ComplexNumber(5,0,'C');
		ComplexNumber num11 = new ComplexNumber(2,-1,'C');
		ComplexNumber num12 = new ComplexNumber(6,-4,'C');
		ComplexNumber num13 = new ComplexNumber(0,0,'C');
		ComplexNumber num14 = new ComplexNumber(4,5,'C');
		ComplexNumber num15 = new ComplexNumber(2,0,'C');
		ComplexNumber num16 = new ComplexNumber(7,-4,'C');
		ComplexNumber num17 = new ComplexNumber(2,7,'C');
		ComplexNumber num18 = new ComplexNumber(0,0,'C');
		
		ComplexNumber[][] matr1 = new ComplexNumber [3][3];
		ComplexNumber[][] matr2 = new ComplexNumber [3][3];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[1][0] = num4;
		matr1[1][1] = num5;
		matr1[1][2] = num6;
		matr1[2][0] = num7;
		matr1[2][1] = num8;
		matr1[2][2] = num9;
		matr2[0][0] = num10;
		matr2[0][1] = num11;
		matr2[0][2] = num12;
		matr2[1][0] = num13;
		matr2[1][1] = num14;
		matr2[1][2] = num15;
		matr2[2][0] = num16;
		matr2[2][1] = num17;
		matr2[2][2] = num18	;	
		
		ComplexNumber[][] res = Library.productoEntreMatrices(matr1, matr2);
		
		assertEquals(26,res[0][0].getPartR());
		assertEquals(-52,res[0][0].getPartI());
		assertEquals(60,res[0][1].getPartR());
		assertEquals(24,res[0][1].getPartI());
		assertEquals(26,res[0][2].getPartR());
		assertEquals(0,res[0][2].getPartI());
		assertEquals(9,res[1][0].getPartR());
		assertEquals(7,res[1][0].getPartI());
		assertEquals(1,res[1][1].getPartR());
		assertEquals(29,res[1][1].getPartI());
		assertEquals(14,res[1][2].getPartR());
		assertEquals(0,res[1][2].getPartI());
		assertEquals(20,res[2][2].getPartR());
		assertEquals(-22,res[2][2].getPartI());
	}
	
	@Test 
	public void deberiaDarLaAccionSiguiente() {
		int num1 = 0;
		int num2 = 1;
		int num3 = 0;
		int num4 = 0;
		int num5 = 1;
		int num6 = 0;
		int num7 = 0;
		int num8 = 1;
		
		ComplexNumber num10 = new ComplexNumber(5,-1,'C');
		ComplexNumber num11 = new ComplexNumber(2,-1,'C');
		ComplexNumber num12 = new ComplexNumber(6,-4,'C');
		ComplexNumber num13 = new ComplexNumber(0,0,'C');

		int[][] matr1 = new int [2][4];
		ComplexNumber[] vect1 = new ComplexNumber[4];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[0][3] = num4;
		matr1[1][0] = num5;
		matr1[1][1] = num6;
		matr1[1][2] = num7;
		matr1[1][3] = num8;
		
		vect1[0] = num10;
		vect1[1] = num11;
		vect1[2] = num12;
		vect1[3] = num13;
		
		ComplexNumber[] res = Library.accionVectorMatriz(matr1, vect1);
		
		assertEquals(2,res[0].getPartR());
		assertEquals(-1,res[0].getPartI());
		assertEquals(5,res[1].getPartR());
		assertEquals(-1,res[1].getPartI());
	}
	
	@Test 
	public void deberiaCalcularElProductoInterno() {
		ComplexNumber num1 = new ComplexNumber(4,3,'C');
		ComplexNumber num2 = new ComplexNumber(6,-4,'C');
		ComplexNumber num3 = new ComplexNumber(12,-7,'C');
		ComplexNumber num4 = new ComplexNumber(0,13,'C');
		
		ComplexNumber num10 = new ComplexNumber(4,3,'C');
		ComplexNumber num11 = new ComplexNumber(6,-4,'C');
		ComplexNumber num12 = new ComplexNumber(12,-7,'C');
		ComplexNumber num13 = new ComplexNumber(0,13,'C');
		
		ComplexNumber[][] vect1 = new ComplexNumber[4][1];
		ComplexNumber[][] vect2 = new ComplexNumber[4][1];
		
		vect1[0][0] = num1;
		vect1[1][0] = num2;
		vect1[2][0] = num3;
		vect1[3][0] = num4;
		
		vect2[0][0] = num10;
		vect2[1][0] = num11;
		vect2[2][0] = num12;
		vect2[3][0] = num13;
		
		ComplexNumber res = Library.productoInterno(vect1, vect2);
		
		assertEquals(-47,res.getPartR());
		assertEquals(-192,res.getPartI());
	}
	
	@Test
	public void deberiaSacarLaNormaDeUnVectorComplejo() {
		ComplexNumber num1 = new ComplexNumber(4,3,'C');
		ComplexNumber num2 = new ComplexNumber(6,-4,'C');
		ComplexNumber num3 = new ComplexNumber(12,-7,'C');
		ComplexNumber num4 = new ComplexNumber(0,13,'C');
		
		ComplexNumber[][] vect1 = new ComplexNumber[4][1];
		
		vect1[0][0] = num1;
		vect1[1][0] = num2;
		vect1[2][0] = num3;
		vect1[3][0] = num4;
		
		ComplexNumber res = Library.normaMatriz(vect1);
		
		assertEquals(Math.pow(-192,0.5),res.getPartI());
		assertEquals(Math.pow(-47,0.5),res.getPartR());
		
	}
	
	@Test
	public void deberiaSacarLaDistanciaEntreVectores() {
		ComplexNumber num1 = new ComplexNumber(4,3,'C');
		ComplexNumber num2 = new ComplexNumber(6,-4,'C');
		ComplexNumber num3 = new ComplexNumber(12,-7,'C');
		ComplexNumber num4 = new ComplexNumber(0,13,'C');
		
		ComplexNumber num10 = new ComplexNumber(3,2,'C');
		ComplexNumber num11 = new ComplexNumber(-5,-5,'C');
		ComplexNumber num12 = new ComplexNumber(1,-8,'C');
		ComplexNumber num13 = new ComplexNumber(12,-3,'C');
		
		ComplexNumber[][] vect1 = new ComplexNumber[4][1];
		ComplexNumber[][] vect2 = new ComplexNumber[4][1];
		
		vect1[0][0] = num1;
		vect1[1][0] = num2;
		vect1[2][0] = num3;
		vect1[3][0] = num4;
		
		vect2[0][0] = num10;
		vect2[1][0] = num11;
		vect2[2][0] = num12;
		vect2[3][0] = num13;
		
		ComplexNumber res = Library.distancia(vect1, vect2);
		
		assertEquals(Math.pow(-338,0.5),res.getPartI());
		assertEquals(Math.pow(128,0.5),res.getPartR());
		
	}
	
	@Test
	public void deberiaSacarLaTranspuesta() {
		ComplexNumber num1 = new ComplexNumber(3,-2,'C');
		ComplexNumber num2 = new ComplexNumber(1,1,'C');
		ComplexNumber num3 = new ComplexNumber(5,-6,'C');
		ComplexNumber num4 = new ComplexNumber(0,1,'C');
		ComplexNumber num5 = new ComplexNumber(4,2,'C');
		ComplexNumber num6 = new ComplexNumber(3,-1,'C');
		ComplexNumber num7 = new ComplexNumber(4,-1,'C');
		ComplexNumber num8 = new ComplexNumber(2,-2,'C');
		ComplexNumber num9 = new ComplexNumber(1,-2,'C');

		ComplexNumber[][] matr1 = new ComplexNumber [3][3];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[1][0] = num5;
		matr1[1][1] = num6;
		matr1[1][2] = num7;
		matr1[2][0] = num8;
		matr1[2][1] = num4;
		matr1[2][2] = num9;
		
		ComplexNumber[][] res = Library.transpuesta(matr1);
		
		assertEquals(num1,res[0][0]);
		assertEquals(num2,res[1][0]);
		assertEquals(num3,res[2][0]);
		assertEquals(num5,res[0][1]);
		assertEquals(num6,res[1][1]);
		assertEquals(num7,res[2][1]);
		assertEquals(num8,res[0][2]);
		assertEquals(num4,res[1][2]);
		assertEquals(num9,res[2][2]);
	}
	
	@Test
	public void deberiaDecirSiEsUnaMatrizUnitaria() {
		ComplexNumber num1 = new ComplexNumber(1,1,'C');
		ComplexNumber num2 = new ComplexNumber(0,0,'C');
		ComplexNumber num3 = new ComplexNumber(0,0,'C');
		ComplexNumber num4 = new ComplexNumber(0,0,'C');
		ComplexNumber num5 = new ComplexNumber(0,0,'C');
		ComplexNumber num6 = new ComplexNumber(1,1,'C');
		ComplexNumber num7 = new ComplexNumber(0,0,'C');
		ComplexNumber num8 = new ComplexNumber(0,0,'C');
		ComplexNumber num9 = new ComplexNumber(1,1,'C');

		ComplexNumber[][] matr1 = new ComplexNumber [3][3];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[1][0] = num5;
		matr1[1][1] = num6;
		matr1[1][2] = num7;
		matr1[2][0] = num8;
		matr1[2][1] = num4;
		matr1[2][2] = num9;
		
		boolean res = Library.esUnitaria(matr1);
		assertTrue(res);
	}
	
	@Test
	public void deberiaSacarElProductoTensor() {
		ComplexNumber num1 = new ComplexNumber(3,-2,'C');
		ComplexNumber num2 = new ComplexNumber(1,1,'C');
		ComplexNumber num3 = new ComplexNumber(5,-6,'C');
		ComplexNumber num4 = new ComplexNumber(0,1,'C');
		ComplexNumber num5 = new ComplexNumber(4,2,'C');
		ComplexNumber num6 = new ComplexNumber(3,-1,'C');
		ComplexNumber num7 = new ComplexNumber(4,-1,'C');
		ComplexNumber num8 = new ComplexNumber(2,-2,'C');
		ComplexNumber num9 = new ComplexNumber(1,-2,'C');
		
		ComplexNumber num10 = new ComplexNumber(5,-1,'C');
		ComplexNumber num11 = new ComplexNumber(2,-1,'C');

		ComplexNumber[][] matr1 = new ComplexNumber [3][3];
		ComplexNumber[][] vect1 = new ComplexNumber[2][1];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[1][0] = num4;
		matr1[1][1] = num5;
		matr1[1][2] = num6;
		matr1[2][0] = num7;
		matr1[2][1] = num8;
		matr1[2][2] = num9;
		
		vect1[0][0] = num10;
		vect1[1][0]= num11;
		
		ComplexNumber[][] res = Library.productoTenssor(matr1, vect1);
		
		assertEquals(13,res[0][0].getPartR());
		assertEquals(-13,res[0][0].getPartI());
		assertEquals(6,res[0][1].getPartR());
		assertEquals(4,res[0][1].getPartI());
		assertEquals(19,res[0][2].getPartR());
		assertEquals(-35,res[0][2].getPartI());
		assertEquals(4,res[1][0].getPartR());
		assertEquals(-7,res[1][0].getPartI());
		assertEquals(3,res[1][1].getPartR());
		assertEquals(1,res[1][1].getPartI());
		assertEquals(4,res[1][2].getPartR());
		assertEquals(-17,res[1][2].getPartI());
		assertEquals(1,res[2][0].getPartR());
		assertEquals(5,res[2][0].getPartI());
		assertEquals(22,res[2][1].getPartR());
		assertEquals(6,res[2][1].getPartI());
		assertEquals(14,res[2][2].getPartR());
		assertEquals(-8,res[2][2].getPartI());
	}
	@Test
	public void deberiaSacarLaConjugadaDeUnaMatriz() {
		ComplexNumber num1 = new ComplexNumber(3,-2,'C');
		ComplexNumber num2 = new ComplexNumber(1,1,'C');
		ComplexNumber num3 = new ComplexNumber(5,-6,'C');
		ComplexNumber num4 = new ComplexNumber(0,1,'C');
		
		ComplexNumber[][] matr1 = new ComplexNumber [2][2];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[1][0] = num3;
		matr1[1][1] = num4;
		
		ComplexNumber[][]res = Library.conjugada(matr1);
		
		assertEquals(3,res[0][0].getPartR());
		assertEquals(2,res[0][0].getPartI());
		assertEquals(1,res[0][1].getPartR());
		assertEquals(-1,res[0][1].getPartI());
		assertEquals(5,res[1][0].getPartR());
		assertEquals(6,res[1][0].getPartI());
		assertEquals(0,res[1][1].getPartR());
		assertEquals(-1,res[1][1].getPartI());
	}
	
	@Test
	public void deberiaSacarLaAdjuntaDeUnaMatriz() {
		ComplexNumber num1 = new ComplexNumber(3,-2,'C');
		ComplexNumber num2 = new ComplexNumber(1,1,'C');
		ComplexNumber num3 = new ComplexNumber(5,-6,'C');
		ComplexNumber num4 = new ComplexNumber(0,1,'C');
		
		ComplexNumber[][] matr1 = new ComplexNumber [2][2];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[1][0] = num3;
		matr1[1][1] = num4;
		
		ComplexNumber[][]res = Library.adjunta(matr1);
		
		assertEquals(3,res[0][0].getPartR());
		assertEquals(2,res[0][0].getPartI());
		assertEquals(1,res[1][0].getPartR());
		assertEquals(-1,res[1][0].getPartI());
		assertEquals(5,res[0][1].getPartR());
		assertEquals(6,res[0][1].getPartI());
		assertEquals(0,res[1][1].getPartR());
		assertEquals(-1,res[1][1].getPartI());
	}
	
	@Test
	public void deberiaDecirQueEsHermitiana() {
		ComplexNumber num1 = new ComplexNumber(7,0,'C');
		ComplexNumber num2 = new ComplexNumber(6,5,'C');
		ComplexNumber num3 = new ComplexNumber(-3,0,'C');
		ComplexNumber num4 = new ComplexNumber(6,-5,'C');
		
		ComplexNumber[][] matr1 = new ComplexNumber [2][2];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[1][0] = num4;
		matr1[1][1] = num3;
		
		boolean res = Library.esHermitiana(matr1);
		assertTrue(res);
	}
	
	@Test
	public void deberiaSacarElEstadoEnTiempoT() {
		int num1 = 0;
		int num2 = 1;
		int num3 = 0;
		int num4 = 0;
		int num5 = 1;
		int num6 = 0;
		int num7 = 0;
		int num8 = 1;
		int num9 = 1;
		int num10 = 0;
		int num11 = 1;
		int num12 = 0;
		int num13 = 0;
		int num14 = 1;
		int num15 = 1;
		int num16 = 1;
		
		ComplexNumber num17 = new ComplexNumber(5,-1,'C');
		ComplexNumber num18 = new ComplexNumber(2,-1,'C');
		ComplexNumber num19 = new ComplexNumber(6,-4,'C');
		ComplexNumber num20 = new ComplexNumber(2,5,'C');

		int[][] matr1 = new int [4][4];
		ComplexNumber[] vect1 = new ComplexNumber[4];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[0][3] = num4;
		matr1[1][0] = num5;
		matr1[1][1] = num6;
		matr1[1][2] = num7;
		matr1[1][3] = num8;
		matr1[2][0] = num9;
		matr1[2][1] = num10;
		matr1[2][2] = num11;
		matr1[2][3] = num12;
		matr1[3][0] = num13;
		matr1[3][1] = num14;
		matr1[3][2] = num15;
		matr1[3][3] = num16;
		
		vect1[0] = num17;
		vect1[1] = num18;
		vect1[2] = num19;
		vect1[3] = num20;
		
		ComplexNumber[] res = Library.canicasCoeficientesComplejos(matr1, vect1, 2);
		
		assertEquals(7,res[0].getPartR());
		assertEquals(4,res[0].getPartI());
		assertEquals(12,res[1].getPartR());
		assertEquals(-1,res[1].getPartI());
		assertEquals(13,res[2].getPartR());
		assertEquals(-6,res[2].getPartI());
		assertEquals(28,res[3].getPartR());
		assertEquals(-1,res[3].getPartI());
	}
}
