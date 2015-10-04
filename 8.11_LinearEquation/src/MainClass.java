import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter values for a, b, c, d, e, f: ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		int e = input.nextInt();
		int f = input.nextInt();

		LinearEquation linEq = new LinearEquation(a, b, c, d, e, f);
		
		if(linEq.isSolvable()) {
			System.out.printf("\n X is %f, Y is %f.", linEq.getX(), linEq.getY());
		}
		else
			System.out.println("The equation has no solution.");
		
	}//end main
	
}

class LinearEquation {
	/***Data Fields***/
	private int a;
	private int b;
	private int c;
	private int d; 
	private int e;
	private int f;
	
	/***Constructors***/
	public LinearEquation() {
		
	}
	
	public LinearEquation(int a1, int b1, int c1, int d1, int e1, int f1) {
		a = a1;
		b = b1;
		c = c1;
		d = d1;
		e = e1;
		f = f1;
	}
	
	/***Getter and Setters***/
	public int getA() {
		return a;
	}
	
	public void setA(int a1) {
		a = a1;
	}
	
	public int getB() {
		return b;
	}
	
	public void setB(int b1) {
		b = b1;
	}
	
	public int getC() {
		return c;
	}
	
	public void setC(int c1) {
		 c = c1;
	}
	
	public int getD() {
		return d;
	}
	
	public void setD(int d1) {
		d = d1;
	}
	
	public int getE() {
		return e;
	}
	
	public void setE(int e1) {
		e = e1;
	}
	
	public int getF() {
		return f;
	}
	
	public void setF(int f1) {
		f = f1;
	}
	
	/***Methods***/
	public boolean isSolvable() {
		if(a*d - b*c != 0)
			return true;
		else
			return false;
	}
	
	public double getX() {
		return (e*d - b*f) / (a*d - b*c);
	}
	
	public double getY() {
		return (a*f - e*c) / (a*d -b*c);
	}
	
	
}//end class