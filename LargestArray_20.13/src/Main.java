import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[] intArr = new int[8];
		for(int i = intArr.length - 1; i >= 0; i--) {
			boolean flag = true;
			while(flag) {
				try {
					Scanner input = new Scanner(System.in);
					System.out.print("Enter " + (i + 1) + " integers : ");
					intArr[i] = input.nextInt();
					System.out.println();
					flag = false;
				}
				catch (InputMismatchException e){
					System.out.println("Unsupported type.");
				}
			}//end while
		}//end for
		
		System.out.println("Largest : " + findLargest(intArr));
	}//end main
	
	public static int findLargest(int[] arr) {
		return findLargest(arr, arr[0], 0);
	}
	
	public static int findLargest(int[] arr, int largest, int index) {
		if(index == arr.length - 1)
			return largest;
		else {
			if(largest < arr[index + 1])
				largest = arr[index + 1];
			return findLargest(arr, largest, index + 1);
		}
	}
}
