import java.util.*;
//Needs work
public class QuadraticEquation {
	/***Data Fields***/
	private int a;
	private int b;
	private int c;
	
	/***Get Methods***/
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
	/***Constructor***/
	public QuadraticEquation(int a2, int b2, int c2) {
		a = a2;
		b = b2;
		c = c2;
	}//end constructor
	
	/***Methods***/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the 3 coefficients: ");
		int a2 = input.nextInt();
		int b2 = input.nextInt();
		int c2 = input.nextInt();
		QuadraticEquation q1 = new QuadraticEquation(a2, b2, c2);
		
		double disc = q1.getDiscriminant();
		System.out.println(disc);
		if(disc > 0) 
			System.out.printf("Roots: %.2f and %.2f", q1.getRoot1(), q1.getRoot2());
		else if(disc == 0)
			System.out.printf("Root: %.2f", q1.getRoot1());
		else
			System.out.println("This equation has no roots.");
		
	}//end main
	
	public double getDiscriminant() {
		return (Math.pow(b, 2) - (4 * a * c));
	}//end getDiscriminant
	
	public double getRoot1() {
		double disc = getDiscriminant();
		if(disc != 0) {
			return (-b + Math.pow(disc, 0.5));
		}
		else
			return 0;	
	}//end getRoot1
	
	public double getRoot2() {
		double disc = getDiscriminant();
		if(disc != 0) {
			return (-b - Math.pow(disc, 0.5));
		}
		else
			return 0;	
	}//end getRoot1
	
}//end class
