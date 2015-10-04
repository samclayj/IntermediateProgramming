import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test {
	private static RandomAccessFile raf;

	public static void main(String[] args) {
		try {		
			raf = new RandomAccessFile("test2.dat", "rw");
			for(int i = 0; i < 100; i++)
				raf.writeInt(i);
			raf.close();
			
			raf = new RandomAccessFile("test2.dat", "rw");
			raf.seek(4);
			raf.writeInt(33);
			raf.close();
			raf = new RandomAccessFile("test2.dat", "rw");
			
			for(int i = 0; i < raf.length()/4; i++)
				System.out.println(raf.readInt());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (EOFException eof) {
			System.out.println("Not found!");
		}
		catch (Exception ex) {
			System.out.println("Something went wrong.");
		}
	}
}//end class
