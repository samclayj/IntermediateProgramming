/***Sam Jentsch CSC_202.001***/
/***Project 10***/

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Project10 {

	private static RandomAccessFile raf;

	public static void main(String[] args) throws IOException {	

		boolean flag = false;
		int choice = 0;

		while(!flag) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print("Binary Search (1); Binary Insertion (2): ");
				choice = input.nextInt();
				if(choice == 1 || choice == 2)
					flag = true;
			}
			catch (Exception ex) {
				System.out.println("Invalid choice. Please enter 1 or 2.");
			}
		}

		flag = false;
		int searchNum = 0;
		while(!flag) {
			try {
				Scanner input = new Scanner(System.in);
				if(choice == 1)
					System.out.print("Enter the integer to search for: ");
				else
					System.out.print("Enter the integer to insert: ");
				searchNum = input.nextInt();
				flag = true;
			}
			catch (Exception ex) {
				System.out.println("Invalid input. Please enter an integer.");
			}
		}

		try {
			/***Use this to create a test file. Make sure to change the code from Project10.dat
			 * to test.dat when creating the file to search from if using the test file.***/
			raf = new RandomAccessFile("test.dat", "rw");
			raf.setLength(0);
			for(int i = 0; i < 100000; i++)
				raf.writeInt(i);
			raf.close();

			raf = new RandomAccessFile("test.dat", "rw");
			if(choice == 1)
				binarySearch(raf, searchNum);
			else
				binaryInsertion(raf, searchNum);		
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
		finally {
			raf.close();
		}

	}//end main

	static int binarySearch(RandomAccessFile file, int searchNum) throws IOException {
		long high = file.length() - 4;
		long low = 0;
		int searchTimes = 0;

		do {
			searchTimes++;
			long mid = (low + high) / 2;
			while(mid%4 != 0) 
				mid++;
			raf.seek(mid);
			int midInt = raf.readInt();
			System.out.println("MidInt: " + midInt);
			if(searchNum < midInt)
				high = mid - 4;
			else if(searchNum == midInt) {
				System.out.println(searchNum + " found! Search took " + searchTimes + " tries to find the number.");
				return searchNum;
			}
			else
				low = mid + 4;
		} while(high >= low);	

		System.out.println("Search took " + searchTimes + " tries. The number was not found.");

		return -1;
	}

	static int binaryInsertion(RandomAccessFile file, int searchNum) throws IOException {
		long high = file.length() - 4;
		long low = 0;
		int searchTimes = 0;

		while(high >= low) {
			searchTimes++;
			long mid = (low + high) / 2;
			while(mid%4 != 0) 
				mid++;
			raf.seek(mid);
			int midInt = raf.readInt();

			if(searchNum == midInt) {
				System.out.println(searchNum + " should be place on either side of " + midInt + " in the file.");
				System.out.println("It took " + searchTimes + " times to find where to insert the number.");
				return searchNum;
			}
			else if(high == low) {
				raf.seek(high - 4);
				int firstNum = raf.readInt();
				raf.seek(high);
				int secondNum = raf.readInt();
				if(mid > secondNum) {
					firstNum = secondNum;
					raf.seek(high + 4);
					secondNum = raf.readInt();
				}

				System.out.println(searchNum + " should be placed between " + firstNum + " and " + secondNum + " in the file.");
				System.out.println("It took " + searchTimes + " times to find where to insert the number.");
				return 0;
			}
			else if(searchNum < midInt)
				high = mid - 4;
			else
				low = mid + 4;
		} 	

		file.seek(0);
		if(searchNum < file.readInt())
			System.out.println(searchNum + " should be inserted before the first number in the file.");
		else
			System.out.println(searchNum + " should be inserted after the last number in the file.");

		System.out.println("It took " + searchTimes + " times to find where to insert the number.");

		return -1;
	}

}//end class