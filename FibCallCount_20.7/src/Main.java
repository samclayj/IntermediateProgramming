import java.util.*;

public class Main {

	public static long callCount = 0;
	
	public static void main(String[] args) {
		boolean flag = true;
		long index = 0;
		while (flag) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print("Enter an index: ");
				index = input.nextLong();
				flag = false; 
			}
			catch (InputMismatchException e){
				System.out.println("Wrong type fool.");
			}
		}
		
		System.out.println("Fibonnaci: " +fib(index)+ " Call count: " + callCount);
		
	}//end main
	
	public static long fib(long index) {
		callCount++;
		//base cases
		if(index == 0)
			return 0;
		else if(index == 1)
			return 1;
		else
			return fib(index - 1) + fib(index - 2);
		//use recursion to find the sum of the 2 number previous to the index.
	}//end main
	
}//end class
