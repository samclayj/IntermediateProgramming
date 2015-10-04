import java.awt.Point;

public class Pentagon {

	/***Data Fields***/
	private Point point;
	private int sideLength;
	
	/***Methods***/
	Pentagon(int x, int y, int side) {
		point = new Point(x, y);
		sideLength = side;
	}//end
	
	Pentagon(Point p, int side) {
		point = p;
		sideLength = side;
		
	}//end
	
	public double getPerimeter() {
		return (sideLength * 5);
	}//end
	
	public double getArea() {
		double area = ((5.0 * Math.pow(sideLength, 2)) * Math.tan(Math.toRadians(54))) / 4.0;
		return area;
	}//end
	
	public void setPoint(Point newPoint) {
		point = newPoint;
	}//end
	
	public void setPoint(int x, int y) {
		point = new Point(x, y);
	}//end
	
	public void setSideLength(int newSideLength) {
		sideLength = newSideLength;
	}//end
	
	public Point getPoint() {
		return point;
	}//end
	
	public int getSideLength() {
		return sideLength;
	}//end
	
}//end class
