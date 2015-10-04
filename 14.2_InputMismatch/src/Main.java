import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;

		boolean flag = true;

		while(flag) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter two integers: ");
				num1 = input.nextInt();
				num2 = input.nextInt();
				flag = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Unsupported. Enter again.");
			}
		}
		System.out.println("Sum: " + (num1 + num2));
	}	
}
