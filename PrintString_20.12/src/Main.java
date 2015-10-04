
public class Main {

	public static void main(String[] args) {
		reverseDisplay("dog");
	}
	
	public static void reverseDisplay(String s) {
		reverseDisplay(s, s.length() - 1);
	}
	
	public static void reverseDisplay(String s, int high) {
		if(high > 0) {
			System.out.print(s.charAt(high));
			reverseDisplay(s, high - 1);
		}
	}
	
}
