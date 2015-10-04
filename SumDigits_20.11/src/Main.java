import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		boolean flag = true;
		long num = 0;
		while(flag) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print("Enter an int: ");
				num = input.nextLong();
				flag = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Unsupported input.");
			}
			
		}
		System.out.println(sumDigits(num));

	}//end main

	public static int sumDigits(long n) {
		if(n / 10 == 0)
			return (int)n;
		else {
			return (int)((n%10) + sumDigits(n/10));
		}
	}//end sumDigits
}
