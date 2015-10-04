import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Date date = new Date();
		int[] intArr = {1, 2, 4, 5, 6};
		double dub = 5.5;
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise19_05.dat"));
			output.writeObject(date);
			output.writeObject(intArr);
			output.writeDouble(dub);
			output.close();
			
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise19_05.dat"));
			System.out.println("Date: " + (Date)input.readObject());
			int[] arr = (int[])input.readObject();
			for(int i = 0; i < arr.length; i++)
				System.out.println(arr[i]);
			double dub1 = input.readDouble();
			System.out.println(dub1);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			
		}
		
		
		
	}
	
}
