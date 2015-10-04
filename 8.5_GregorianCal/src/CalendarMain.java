import java.util.*;

public class CalendarMain {

	public static void main(String[] args) {
		
		//create GregorianCalendar object
		GregorianCalendar calendar = new GregorianCalendar();
		
		int year = calendar.get(GregorianCalendar.YEAR);
		int month = calendar.get(GregorianCalendar.MONTH);
		int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		
		System.out.printf("%d/%d/%d", month, day, year);
		
		calendar.setTimeInMillis(1234567898765L);
		
		year = calendar.get(GregorianCalendar.YEAR);
		month = calendar.get(GregorianCalendar.MONTH);
		day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		
		System.out.printf("\n%d/%d/%d", month, day, year);
		
	}//end main
	
}
