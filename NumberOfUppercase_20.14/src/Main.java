import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		System.out.println("Enter a string: ");
		
		String s = input.next();
		
		System.out.println("Number of uppercase characters: " + numUpper(s));
	}
	
	public static int numUpper(String s) {
		int upper = 0;
		upper = numUpper(s, 0);
		return upper;
	}
	
	public static int numUpper(String s, int num) {
		if(s.length() == 0)
			return num;
		else {
			if(Character.isUpperCase(s.charAt(0)) == true)
				return numUpper(s.substring(1), num + 1);
			else
				return numUpper(s.substring(1), num);
			
		}
	}
	
}
