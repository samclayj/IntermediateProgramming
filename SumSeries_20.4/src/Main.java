import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(sumSeries(10));
	}
	
	public static double sumSeries(int i) {
		if(i == 1)
			return 1;
		else
			return 1.0/i + sumSeries(i-1);
	}
	
}
