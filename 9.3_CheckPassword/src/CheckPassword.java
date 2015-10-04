import java.util.*;

public class CheckPassword {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isGood = false;

		boolean isNotDigit = false;
		int digitCount = 0;
		
		while(!isGood) {
		System.out.print("Enter a password: ");
		String password = input.next();
		
		for(int i = 0; i < password.toCharArray().length; i++) {
			
			if(!Character.isLetter(password.toCharArray()[i]) && !Character.isDigit(password.toCharArray()[i])) {
				isNotDigit = true;
			}
		
			if(Character.isDigit(password.toCharArray()[i]))
				digitCount++;
			
		}//end for

		if(password.length() >= 8 && !isNotDigit && digitCount >= 2) {
			System.out.println("Nice Password!");
			isGood = true;
		}
		else {
			System.out.println("Please try again...");
			digitCount = 0;
			isNotDigit = false;
			isGood = false;
		}
		
		}//end while
		
	}//end main
	
}
