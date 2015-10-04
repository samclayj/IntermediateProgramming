import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		File direc = new File("");
		boolean flag = true;
		while(flag) {
			System.out.print("Enter a directory name: ");
			String fileName = input.next();
			direc = new File(fileName);

			if(!direc.exists())
				System.out.println("Directory does not exist.");
			else if(!direc.isDirectory())
				System.out.println("Name entered is not directory.");
			else
				flag = false;
		}
		
		System.out.println("Number of files: " + getDirSize(direc));
		
	}//end main
	
	public static long getDirSize(File dir) {
		long size = 0;
		if(dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(int i = 0; i < files.length; i++) {
				size += getDirSize(files[i]);
			}
		}
		else {
			size++;
		}
		return size;
	}
	
}
