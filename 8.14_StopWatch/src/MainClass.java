import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		Random random = new Random(50);
		StopWatch sWatch = new StopWatch();
		int[] testArray = new int[10000000];
		for(int i = 0; i < testArray.length; i++)
			testArray[i] = random.nextInt(10000000);
		sWatch.start();
		java.util.Arrays.sort(testArray);
		sWatch.stop();
		
		long time = sWatch.getElapsedTime();
		
		System.out.println("Sort took " + time + " milliseconds.");
		
		
	}//end main
	
}
