import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String rString = input.next();
		
		reverseString(rString);
		
	}
	
	public static void reverseString(String s) {
		if(s.length() == 1)
			System.out.print(s);
		else {
			System.out.print(s.charAt(s.length() - 1));
			reverseString(s.substring(0, s.length() - 1));
		}
		
	}
	
}
