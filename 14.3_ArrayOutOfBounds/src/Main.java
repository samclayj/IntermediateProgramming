import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		int[] arr = new int[100];
		
		for(int i = 0; i < arr.length; i++) 
			arr[i] = (int)(Math.random() * 100);
		
		int index = 0;
		boolean flag = true;
		while(flag) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter an index: ");
				index = input.nextInt();
				System.out.println(arr[index]);
				flag = false;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Out of bounds.");
			}
			catch (InputMismatchException e) {
				System.out.println("Unsupported type.");
			}
		}
		
	}

}