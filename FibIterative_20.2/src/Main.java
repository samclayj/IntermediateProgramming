import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		boolean flag = true;
		int index = 0;
		while (flag) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print("Enter an index: ");
				index = input.nextInt();
				flag = false; 
			}
			catch (InputMismatchException e){
				System.out.println("Wrong type fool.");
			}
		}
		
		
		BigInteger n1 = new BigInteger("0");
		BigInteger n2 = new BigInteger("1");
		
		BigInteger fibonacciNum = new BigInteger("0");

		if(index > 0 && index !=1 && index !=2)
			for(int i = 1; i < index; i++) {
				fibonacciNum = n1.add(n2);
				n1 = n2;
				n2 = fibonacciNum;
			}
		else if(index < 0)
			System.out.println("Can't find fibonacci of negative index.");
		else if(index == 0)
			fibonacciNum = new BigInteger("0");
		else
			fibonacciNum = new BigInteger("1");
		
		System.out.println("Fibonacci " + index + " equals: " + fibonacciNum.toString());
		
		
	}//end main
	
}//end class
