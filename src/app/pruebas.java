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
	public void deberiaSumarDosVectores() {
		ComplexNumber num1 = new ComplexNumber(1,1,'C');
		ComplexNumber num2 = new ComplexNumber(2,1,'C');
		ComplexNumber num3 = new ComplexNumber(4,1,'C');
		ComplexNumber num4 = new ComplexNumber(7,1,'C');
		ComplexNumber[] vect1 = new ComplexNumber [2];
		ComplexNumber[] vect2 = new ComplexNumber [2];
		vect1[0] = num1;
		vect1[1] = num2;
		vect2[0] = num3;
		vect2[1] = num4;
		ComplexNumber[] res = Library.sumaVectores(vect1, vect2);
		assertEquals(5,res[0].getPartR());
		assertEquals(2,res[0].getPartI());
		assertEquals(9,res[1].getPartR());
		assertEquals(2,res[1].getPartI());
	}
	
	@Test
	public void deberiaSacarInvesoDeUnVector() {
		ComplexNumber num1 = new ComplexNumber(1,1,'C');
		ComplexNumber num2 = new ComplexNumber(-2,3,'C');
		ComplexNumber[] vect1 = new ComplexNumber [2];
		vect1[0] = num1;
		vect1[1] = num2;
		ComplexNumber[] res = Library.inverso(vect1);
		assertEquals(-1,res[0].getPartR());
		assertEquals(-1,res[0].getPartI());
		assertEquals(2,res[1].getPartR());
		assertEquals(-3,res[1].getPartI());
	}
	
	@Test
	public void deberiaHacerMultiplicacionEscalar() {
		ComplexNumber num1 = new ComplexNumber(6,3,'C');
		ComplexNumber num2 = new ComplexNumber(0,0,'C');
		ComplexNumber num3 = new ComplexNumber(5,1,'C');
		ComplexNumber num4 = new ComplexNumber(4,0,'C');
		ComplexNumber numMult = new ComplexNumber(3,2,'C');
		ComplexNumber[] vect1 = new ComplexNumber [4];
		vect1[0] = num1;
		vect1[1] = num2;
		vect1[2] = num3;
		vect1[3] = num4;
		ComplexNumber[] res = Library.productoEscalar(vect1, numMult);
		assertEquals(12,res[0].getPartR());
		assertEquals(21,res[0].getPartI());
		assertEquals(0,res[1].getPartR());
		assertEquals(0,res[1].getPartI());
		assertEquals(13,res[2].getPartR());
		assertEquals(13,res[2].getPartI());
		assertEquals(12,res[3].getPartR());
		assertEquals(8,res[3].getPartI());
	}
}
