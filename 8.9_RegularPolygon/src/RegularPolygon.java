
public class RegularPolygon {
	/***Data Fields***/
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	/***Setter and Getter Methods***/
	public int getN() {
		return n;
	}//end getN
	
	public void setN(int numSides) {
		if(numSides >= 3)
			n = numSides;
	}//end setN
	
	public double getSide() {
		return side;
	}//end getSide
	
	public void setSide(double sideLength) {
		if(sideLength > 0.0)
			side = sideLength;
	}//end setSide
	
	public double getX() {
		return x;
	}//end getX
	
	public void setX(double newX) {
		x = newX;
	}//end setX
	
	public double getY() {
		return y;
	}//end getY
	
	public void setY(double newY) {
		y = newY;
	}//end setY
	
	/***Constructors***/
	public RegularPolygon() {
		
	}//end RegularPolygon, no parameters
	
	public RegularPolygon(int sides, double length) {
		setN(sides);
		setSide(length);
	}//end RegularPolygon 
	
	public RegularPolygon(int sides, double length, double xCoord, double yCoord) {
		setN(sides);
		setSide(length);
		setX(xCoord);
		setY(yCoord);
	}//end RegularPolygon
	
	/***Methods***/
	public double getPerimeter() {
		return n * side;
	}//end getPerimeter
	
	public double getArea() {
		return (n * Math.pow(side, 2)) / (4 * Math.tan(3.1416/n));
	}//end getArea
}
