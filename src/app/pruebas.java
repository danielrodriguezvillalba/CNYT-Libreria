package app;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pruebas {

	@Test
	void test() {
	}

	@Test
	public void deberiaSumar() {
		ComplexNumber num1 = new ComplexNumber(3,-1);
		ComplexNumber num2 = new ComplexNumber(1,4);
		ComplexNumber res = Library.suma(num1,num2);
		assertEquals(4,res.getPartR());
		assertEquals(3,res.getPartI());
	}
	
	@Test
	public void deberiaSacarElProducto() {
		ComplexNumber num1 = new ComplexNumber(3,-1);
		ComplexNumber num2 = new ComplexNumber(1,4);
		ComplexNumber res = Library.producto(num1, num2);
		assertEquals(7,res.getPartR());
		assertEquals(11,res.getPartI());
	}
	
	@Test
	public void deberiaRestar() {
		ComplexNumber num1 = new ComplexNumber(3,-1);
		ComplexNumber num2 = new ComplexNumber(1,4);
		ComplexNumber res = Library.resta(num1,num2);
		assertEquals(2,res.getPartR());
		assertEquals(-5,res.getPartI());
	}
	
	@Test
	public void deberiaDividir() {
		ComplexNumber num1 = new ComplexNumber(-2,1);
		ComplexNumber num2 = new ComplexNumber(1,2);
		ComplexNumber res = Library.division(num1,num2);
		assertEquals(0,res.getPartR());
		assertEquals(1,res.getPartI());
	}
	
	@Test
	public void deberiaSacarElModulo() {
		ComplexNumber num1 = new ComplexNumber(1,-1);
		assertEquals(Math.pow(2, 0.5),num1.modulo());
	}
	
	@Test
	public void deberiaSacarElconjugado() {
		ComplexNumber num = new ComplexNumber(1,-1);
		ComplexNumber con = Library.conjugado(num);
		assertEquals(1,con.getPartR());
		assertEquals(1,con.getPartI());
	}
	
	@Test
	public void deberiaCambiarLasCoordenadasAPolares() {
		ComplexNumber num = new ComplexNumber(1,1);
		Library.cambiarForma(num);
		assertEquals(Math.pow(2, 0.5),num.getPartR());
		assertEquals(Math.atan(1),num.getPartI());
	}
	
	@Test
	public void deberiaCambiarLasCoordenadasACardinales() {
		ComplexNumber num = new ComplexNumber(Math.pow(2, 0.5),Math.atan(1));
		num.cambiarForma('P');
		Library.cambiarForma(num);
		assertEquals(1,(int)(num.getPartR()));
		assertEquals(1,(int)(num.getPartI()));
	}
	
	@Test
	public void deberiaDarFaseDeUnNumeroCartesianas() {
		ComplexNumber num = new ComplexNumber(1,1);
		assertEquals(Math.atan(1),num.fase());
	}
	     
	@Test
	public void deberiaDarFaseDeUnNumeroPolares() {
		ComplexNumber num = new ComplexNumber(60,1);
		num.cambiarForma('P');
		assertEquals(60,num.fase());
	}
}
