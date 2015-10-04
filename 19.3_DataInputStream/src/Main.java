import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise19_03.dat"));
			for(int i = 0; i < 100; i++)
				output.writeInt(i);
			output.close();
			
			DataInputStream input = new DataInputStream(new FileInputStream("Exercise19_03.dat"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Error");
		}
		
		try {
			RandomAccessFile input = new RandomAccessFile("Exercise19_03.dat", "rw");
			int sum = 0;
			for(int i = 0; i < input.length() / 4; i++)
				sum += input.readInt();
			System.out.println(sum);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException ex) {
			System.out.println("End of file.");
		} catch(Exception ex) {
			System.out.println("Error");
		}

	}//end main
	
}
