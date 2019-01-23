
/**
 * 
 * @author 2115253
 *
 */
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
		int sumaR = num1.getPartR()+num2.getPartR();
		int sumaI = num1.getPartI()+num2.getPartI();
		suma = new ComplexNumber(sumaR,sumaI);
	}
	
	public void producto(ComplexNumber num1, ComplexNumber num2) {
		int multR = (num1.getPartR()*num2.getPartR())+(-1*(num1.getPartI()*num2.getPartI()));
		int multI = (num1.getPartR()*num2.getPartI())+(num1.getPartI()*num2.getPartR());
		producto = new ComplexNumber(multR,multI);
	}
	
	public void resta(ComplexNumber num1, ComplexNumber num2){
		int restaR = num1.getPartR()-num2.getPartR();
		int restaI = num1.getPartI()-num2.getPartI();
		resta = new ComplexNumber(restaR,restaI);
	}
	
	public void division(ComplexNumber num1, ComplexNumber num2) {
		int divisor = (int) (Math.pow(num1.getPartI(), 2)+  Math.pow(num2.getPartI(), 2));
		int mult1 = num1.getPartR()*num1.getPartI() + num2.getPartR()*num2.getPartI();
		int mult2 = num1.getPartI()*num2.getPartR() - num1.getPartR()*num2.getPartI();
		division = new ComplexNumber((mult1/divisor),(mult2/divisor));
	}
	
	public ComplexNumber demeSuma() {
		return suma;
	}
	
	public double modulo(ComplexNumber num) {
		return num.modulo();
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
		//int[] res = {suma.getPartR(),suma.getPartI()};
		return producto;
	}
	
}
