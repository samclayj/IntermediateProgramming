import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		int rows, columns;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns in the array: ");
		rows = input.nextInt();
		columns = input.nextInt();
		
		double[][] arr = new double[rows][columns];
		System.out.println("\nEnter the array: ");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = input.nextDouble();
			}//end for
		}//end for
		
		Location newLoc = Location.locateLargest(arr);
		
		System.out.println("Max: " + newLoc.maxValue[0][0]);
		System.out.println("Indices: (" + newLoc.maxValue[1][0] + ", " + newLoc.maxValue[1][1] + ")");
		
	}//end main
	
}
