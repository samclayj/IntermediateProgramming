
public class StopWatch {

	/***Data Fields***/
	private long startTime;
	private long endTime;
	
	/***Getter Methods***/
	public long getStartTime() {
		return startTime;
	}
	
	public long getEndTime() {
		return endTime;
	}
	
	/***Constructor***/
	public StopWatch() {
		startTime = System.currentTimeMillis();
	}
	
	/***Methods***/
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		endTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime() {
		return endTime - startTime;
	}
	
}//end class
