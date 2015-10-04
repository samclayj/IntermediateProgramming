import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		File scoresFile = new File("Exercise14_15.txt");
		
		if(!scoresFile.exists()) {
			PrintWriter output = new PrintWriter(scoresFile);
			for(int i = 1; i <= 100; i++) 
				arr.add((int)(Math.random() * 100));
			output.close();
		}

		for(int i = 0; i < arr.size(); i++)
			System.out.println(arr.get(i));
		
		Scanner input = new Scanner(scoresFile);
		while(input.hasNext()) {
			System.out.println(input.nextInt());
		}
	}
	
}
