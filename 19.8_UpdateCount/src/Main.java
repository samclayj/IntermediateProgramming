import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		File file = new File("Exercise19_08.dat");
		
		try {
			boolean fileExists = file.exists();
			DataOutputStream output;

			System.out.println(fileExists);
			if(fileExists) {
				DataInputStream input = new DataInputStream(new FileInputStream(file));
				int readInt = input.readInt();
				input.close();
				
				output = new DataOutputStream(new FileOutputStream(file));
				output.writeInt(readInt + 1);
				output.close();
				
				input = new DataInputStream(new FileInputStream(file));
				System.out.println(input.readInt());
				input.close();
			} else {
				output = new DataOutputStream(new FileOutputStream(file));
				output.writeInt(1);
			}
			
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			
		}
	}
	
}
