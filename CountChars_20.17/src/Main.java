public class Main {

	public static void main(String[] args) {
		System.out.println(count(new char[] {'c', 'c', 'b', 'a', 'c', 'b', 'a', 'c'}, 'a'));
	}
	
	public static int count(char[] chars, char ch) {
		return count(chars, ch, 0, 0);
	}
	
	public static int count(char[] chars, char ch, int high, int index) {
		if(chars.length == index)
			return high;
		else {
			if(chars[index] == ch)
				high++;
			return count(chars, ch, high, index+1);
		}
			
	}
	
}
