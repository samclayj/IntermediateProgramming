//import java.sql.Date;
import java.util.*;
public class MainClass {
	
	public static void main(String[] args) {
		long dateInit = 10000;
		Date date = new Date(dateInit);
		String dateString = date.toString();
		System.out.printf("Date %d: %s",dateInit, dateString);
		
		for(int i = 1; i < 8; i++) {
			dateInit *= 10;
			date.setTime(dateInit);
		    dateString = date.toString();
			System.out.printf("\nDate %d: %s",dateInit, dateString);
		}//end for
		
		
	}//end main
	
}//end class

