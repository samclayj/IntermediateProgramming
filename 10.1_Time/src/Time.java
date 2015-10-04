
public class Time {

	/***Data Fields***/
	private int hour;
	private int minute;
	private int second;
	
	/***Constructor***/
	public Time() {
		long time = System.currentTimeMillis();
		
		long totalSeconds = time / 1000;
		long currentSecond = totalSeconds % 60;
		
		long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;
		
		long totalHours = totalMinutes / 60;
		long currentHour = totalHours % 24;
		
		setHour((int)currentHour);
		setMinute((int)currentMinute);
		setSecond((int)currentSecond);		
	}//end constructor
	
	public Time(long elapsedTime) {
		long time = elapsedTime;
		
		long totalSeconds = time / 1000;
		long currentSecond = totalSeconds % 60;
		
		long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;
		
		long totalHours = totalMinutes / 60;
		long currentHour = totalHours % 24;
		
		setHour((int)currentHour);
		setMinute((int)currentMinute);
		setSecond((int)currentSecond);
	}//end constructor
	
	public Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}//end constructor
	
	/***Get/Set***/
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
