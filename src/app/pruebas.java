package app;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pruebas {

	@Test
	void test() {
	}

	@Test
	public void deberiaSumar() {
		int[] num1 = {3,-1};
		int[] num2 = {1,4};
		Library lb = new Library(num1,num2);
		ComplexNumber res = lb.demeSuma();
		assertEquals(4,res.getPartR());
		assertEquals(3,res.getPartI());
	}
	
	@Test
	public void deberiaSacarElProducto() {
		int[] num1 = {3,-1};
		int[] num2 = {1,4};
		Library lb = new Library(num1,num2);
		ComplexNumber res = lb.demeProducto();
		assertEquals(7,res.getPartR());
		assertEquals(11,res.getPartI());
	}
	
	@Test
	public void deberiaRestar() {
		int[] num1 = {3,-1};
		int[] num2 = {1,4};
		Library lb = new Library(num1,num2);
		ComplexNumber res = lb.demeResta();
		assertEquals(2,res.getPartR());
		assertEquals(-5,res.getPartI());
	}
	
	@Test
	public void deberiaDividir() {
		int[] num1 = {-2,1};
		int[] num2 = {1,2};
		Library lb = new Library(num1,num2);
		ComplexNumber res = lb.demeDivision();
		assertEquals(0,res.getPartR());
		assertEquals(1,res.getPartI());
	}
	
	@Test
	public void deberiaSacarElModulo() {
		int[] num1 = {1,-1};
		ComplexNumber num = new ComplexNumber(num1[0],num1[1]);
		assertEquals(Math.pow(2, 0.5),num.modulo());
	}
	
	@Test
	public void deberiaSacarElconjugado() {
		int[] num1 = {1,-1};
		int[] num2 = {1,2};
		ComplexNumber num = new ComplexNumber(num1[0],num1[1]);
		Library lb = new Library(num1,num2) ;
		ComplexNumber con = lb.conjugado(num);
		assertEquals(1,con.getPartR());
		assertEquals(1,con.getPartI());
	}
	
	@Test
	public void deberiaCambiarLasCoordenadasAPolares() {
		int[] num1 = {1,1};
		int[] num2 = {1,2};
		ComplexNumber num = new ComplexNumber(num1[0],num1[1]);
		Library lb = new Library(num1,num2) ;
		lb.cambiarForma(num);
		assertEquals(Math.pow(2, 0.5),num.getPartR());
		assertEquals(Math.atan(1),num.getPartI());
	}
	@Test
	public void deberiaCambiarLasCoordenadasACardinales() {
		double[] num1 = {Math.pow(2, 0.5),Math.atan(1)};
		int[] num2 = {1,2};
		ComplexNumber num = new ComplexNumber(num1[0],num1[1]);
		num.cambiarForma('P');
		Library lb = new Library(num2,num2) ;
		lb.cambiarForma(num);	
		assertEquals(1,num.getPartR());
		assertEquals(1,num.getPartI());
	}
	@Test
	public void deberiaDarFaseDeUnNumeroCartesianas() {
		int[] num1 = {1,1};
		ComplexNumber num = new ComplexNumber(num1[0],num1[1]);
		assertEquals(Math.atan(1),num.fase());
	}
	@Test
	public void deberiaDarFaseDeUnNumeroPolares() {
		int[] num1 = {60,1};
		ComplexNumber num = new ComplexNumber(num1[0],num1[1]);
		num.cambiarForma('P');
		assertEquals(60,num.fase());
	}
}
