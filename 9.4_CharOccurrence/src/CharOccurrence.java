import java.util.Scanner;

public class CharOccurrence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String searchString = input.next();
		System.out.print("\nEnter a char: ");
		char searchChar = input.next().charAt(0);
		
		searchChar = Character.toUpperCase(searchChar);
		searchString = searchString.toUpperCase();
		
		System.out.printf("%c occurs %d times in %s.", searchChar, countOccurrence(searchString, searchChar), searchString);
	}//end main
	
	public static int countOccurrence(String stringToCount, char searchChar) {
		int occurrence = 0;
		
		for(int i = 0; i < stringToCount.toCharArray().length; i++) {
			if(stringToCount.toCharArray()[i] == searchChar)
				occurrence++;
		}
		
		return occurrence;
		
	}//end countOccurrence
	
}
