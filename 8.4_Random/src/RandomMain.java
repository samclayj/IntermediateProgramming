import java.util.*;

public class RandomMain {

	public static void main(String[] args) {
		Random random = new Random(1000);
		for(int i = 0; i < 50; i++) {
			int randomInt = random.nextInt(100);
			System.out.printf("%d ", randomInt);
		}//end for
	
	}//end main
	
}
