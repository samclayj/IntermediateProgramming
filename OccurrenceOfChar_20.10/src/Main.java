/***Needs Work***/
public class Main {

	public static void main(String[] args) {
		System.out.println(count("aaabababac", 'a'));
	}
	
	public static int count(String str, char a) {
		return count(str, a, 0);
	}
	public static int count(String str, char a, int count) {
		if(str.length() < 1)
			return count;
		else {
			if(str.charAt(0) == a)
				count++;
			return count(str.substring(1), a, count);
		}
			
		
	}
}
