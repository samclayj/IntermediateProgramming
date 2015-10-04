
public class Location {

	public int row;
	public int column;
	public Object[][] maxValue = {{0.0}, {row, column}};
	
	public Location() {
		
	}//end Location constructor
	
	public static Location locateLargest(double[][] a) {
		
		double max = a[0][0];
		int maxIndexI = 0;
		int maxIndexJ = 0;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(max < a[i][j]) {
					max = a[i][j];
					maxIndexI = i;
					maxIndexJ = j;
				}//end if
			}//end for
		}//end for
		
		Location returnLoc = new Location();
		
		returnLoc.maxValue[0][0] = max;
		returnLoc.maxValue[1][0] = maxIndexI;
		returnLoc.maxValue[1][1] = maxIndexJ;
		
		return returnLoc;
		
	}//end locateLargest
	
}
