import java.util.*;

public class Main {

	public static void main(String[] args) {

		boolean flag = true;
		int num = 0;
		while(flag) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter an integer to display in reverse: ");
				num = input.nextInt();
				flag = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Not an integer.");
			}
		}//end while

		reverseDisplay(num);
	}//end main

	public static void reverseDisplay(int value) {
		if(value/10 == 0) 
			System.out.print(value);
		else {
			System.out.print(value % 10);
			reverseDisplay(value / 10);
		}
	}//end reverseDisplay
	
}//end class
