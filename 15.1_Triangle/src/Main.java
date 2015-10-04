import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter color: ");
		String color = input.next();
		
		System.out.print("\nEnter filled (0 or 1): ");
		boolean filled;
		if(input.nextInt() == 0)
			filled = true;
		else
			filled = false;
		
		System.out.print("\nEnter side1, side2, and side3");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();

		Triangle triangle = new Triangle(side1, side2, side3, filled, color);
		System.out.println("Triangle: " + triangle.toString());
		
	}
	
}
