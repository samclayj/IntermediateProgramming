//It would make since to change the methods back to static so that the different aspects of a date
//could be printed without initializing a new PrintCal object each time

public class PrintCal {
	
	/***Data Fields***/
	private int month = 0;;
	private int year = 0;
    String cal = "";
	
	/***Constructors***/
	public PrintCal() {
		
	}//end PrintCal
	
	public PrintCal(int nYear, int nMonth) {
		year = nYear;
		month = nMonth;
	}//end PrintCal

	/***Methods***/	
	public void printMonth() {
		printMonthTitle();
		printMonthBody();
	}//end printMonth
	
	public void printMonthTitle() {
		cal += ("          " + getMonthName());
		cal += ("\n____________________________");
		cal += ("\n Sun Mon Tue Wed Thu Fri Sat\n");
	}//end printMonthTitle
	
	public String getMonthName() {
		String monthName = "";
		
		switch (month) {
			case 1: monthName = "January"; break;
			case 2: monthName = "February"; break;
			case 3: monthName = "March"; break;
			case 4: monthName = "April"; break;
			case 5: monthName = "May"; break;
			case 6: monthName = "June"; break;
			case 7: monthName = "July"; break;
			case 8: monthName = "August"; break;
			case 9: monthName = "September"; break;
			case 10: monthName = "October"; break;
			case 11: monthName = "November"; break;
			case 12: monthName = "December"; break;
		}//end switch
		
		return monthName;
	}//end getMonthName
	
	public void printMonthBody() {
		int startDay = getStartDay();
		
		int numberOfDaysInMonth = getNumberOfDaysInMonth();
		
		for(int i = 0; i < startDay; i++) 
			System.out.print("  ");
		for(int i = 1; i <= numberOfDaysInMonth; i++) {
			cal += ("  " + i);
			
			if((i+ startDay) % 7 == 0)
				cal += "\n";
		}
		
		System.out.println();
			
	}//end printMonthBody
	
	public int getStartDay() {
		final int START_DAY_FOR_JAN_1_1800 = 3;
		
		int totalNumberOfDays = getTotalNumberOfDays();
		
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
		
	}//end getStartDay
	
	public int getTotalNumberOfDays() {
		int total = 0;
		
		for(int i = 0; i < year; i++)
			if(isLeapYear())
				total = total + 366;
			else
				total = total + 365;
		
		for(int i = 0; i < month; i++)
			total = total + getNumberOfDaysInMonth();
		
		return total;
		
	}//end getTotalNumberOfDays
	
	public int getNumberOfDaysInMonth() {
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		
		if(month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		
		if (month == 2) return isLeapYear() ? 29 : 28;
		
		return 0;
		
	}//end getNumberOfDaysInMonth
	

	public boolean isLeapYear() {
		
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
		
	}//end isLeapYear
	
	/***Setter and getter***/
	public int getYear() {
		return year;
	}//end getYear
	
	public void setYear(int newYear) {
		year = newYear;
	}//end setYear
	
	public int getMonth() {
		return month;
	}//end getMonth
	
	public void setMonth(int newMonth) {
		if(month >=1 && month <= 12)
			month = newMonth;
	}//end setMonth
	
}//end class

