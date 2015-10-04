import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean isGood = false;
		
		while(!isGood) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a ssn: ");
		String ssn = input.next();
		isGood = ssn.matches("\\d{3}-\\d{2}-\\d{3}");
		if(!isGood)
			System.out.println("Incorrect format.");
		else
			System.out.println("Good Job!");
		}
		
	}
	
}
