
public class Main {
	
	public static void main(String[] args) {
		
		Time time1 = new Time();
		Time time2 = new Time(555550000);
		
		System.out.printf("Time1: %d:%d:%d", time1.getHour(), time1.getMinute(), time1.getSecond());
		System.out.printf("\nTime2: %d:%d:%d", time2.getHour(), time2.getMinute(), time2.getSecond());
		
		
	}//end main
	
}
