import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		BigInteger theInt = new BigInteger("0");
		
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a number to factorial: ");
			theInt = new BigInteger(input.nextInt() + "");
		}
		catch (InputMismatchException e) {
			System.out.println("Unsupported type.");
		}
		
		BigInteger factorialed = factorial(theInt);
		System.out.println("Factorial: " + factorialed.toString());
	}//end main
	
	private static BigInteger factorial(BigInteger num) {
		 if(num.intValue() == 1)
			 return (new BigInteger("1"));
		 else
			 return num.multiply(factorial(num.subtract(new BigInteger("1"))));		
	}
	
}
