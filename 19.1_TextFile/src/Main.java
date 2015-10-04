import java.util.Scanner;
import java.io.*;

public class Main {

	static PrintWriter writer;
	
	public static void main(String[] args) {

		try {
			File file = new File("Exercise19_10.txt");
			if(file.exists())
				writer = new PrintWriter(new FileOutputStream(file, true));
			else
				writer = new PrintWriter(file);
			for(int i = 0; i < 100; i++)
				writer.print(i + " ");
			writer.close();
			Scanner reader = new Scanner(file);
			while(reader.hasNext())
				System.out.println(reader.next());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}//end main
	
}
