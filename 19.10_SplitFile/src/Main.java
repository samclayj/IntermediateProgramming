import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;


public class Main {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.print("Invalid number of arguments");
			System.exit(1);
		}
		
		String sourceFile = args[0];
		String numberOfPieces = args[1];
		
		int numFiles = Integer.parseInt(numberOfPieces);
		try {
			RandomAccessFile raf = new RandomAccessFile(sourceFile, "rw");
			
			long bytesForSubFiles = raf.length() / numFiles;
			
			for(int i = 0; i < raf.length(); i += bytesForSubFiles) {
				String newFileName = sourceFile + i;
				DataOutputStream output = new DataOutputStream(new FileOutputStream(newFileName));
				byte[] bytes = new byte[(int)bytesForSubFiles];
				output.write(raf.read(bytes, i, (int)bytesForSubFiles));				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Exception");
		}
		
	}
	
}
