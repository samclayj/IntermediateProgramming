
public class Main {

	public static void main(String[] arg) {
		char[] c = {'A', 'a', 'b', 'B', 'b', 'c', 'c', 'B', 'd'};
		System.out.println("Count: " + count(c));
	}
	
	public static int count(char[] chars) {		
		return count(chars, 0, 0);
	}
  
	public static int count(char[] chars, int high, int uppercase) {
		if(high == chars.length - 1) {
			return uppercase;
		}
		else {
			if(Character.isUpperCase(chars[high]) == true)
				return count(chars, high + 1, uppercase + 1);				
		}
		
		return count(chars, high + 1, uppercase);
		
	}//end
	
	public static int count(char[] chars, int high) {
		if(high == chars.length - 1) {
			return high;
		}
		else {
			if(Character.isUpperCase(chars[high]) == true)
				return count(chars, high + 1);				
		}
		
		return count(chars, high + 1);
		
	}//end
}
