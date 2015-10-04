
public class Main {

	public static void main(String[] args) {
		reverseDisplay("Happy Birthday");
		System.out.println("\nFib: " + fibonacci(10));
		System.out.println("Summed series: " + sumSeries(3));
		reverseDisplay(12345);

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("\n" + binarySearch(arr, 11));
	}//end main

	public static void reverseDisplay(String s) {
		if(s.length() == 1)
			System.out.print(s);
		else {
			System.out.print(s.charAt(s.length() - 1));
			reverseDisplay(s.substring(0, s.length() - 1));
		}
	}

	public static long fibonacci(long num) {
		if(num == 0)
			return 0;
		else if(num == 1)
			return 1;
		else
			return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public static double sumSeries(double i) {
		if(i == 0)
			return 0;
		else
			return 1/i + sumSeries(i - 1);
	}

	public static void reverseDisplay(int value) {
		if(value / 10 == 0)
			System.out.print(value);
		else {
			System.out.print(value % 10);
			reverseDisplay(value / 10);
		}
	}

	public static boolean binarySearch(int[] arr, int search) {
		int high = arr.length - 1;
		int low = 0;
		int mid = arr.length / 2;

		while(high >= low) {
			mid = (low + high) / 2;
			if(arr[mid] < search) 
				low = mid + 1;
			else if (arr[mid] == search)
				return true;
			else
				high = mid - 1;
		}
		return false;
	}
}
