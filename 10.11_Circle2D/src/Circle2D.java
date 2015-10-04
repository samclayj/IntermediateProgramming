
public class Circle2D {

	/***Data Fields***/
	private double x;
	private double y;
	private double radius;
	
	/***Constructor***/
	public Circle2D() {
		setX(0);
		setY(0);
		setRadius(1);
	}//default
	
	public Circle2D(double x, double y, double radius) {
		setX(x);
		setY(y);
		setRadius(radius);
	}//specified parameters
	
	/***Methods***/
	public double getArea() {
		return Math.PI * radius * radius;
	}//end getArea
	
	public double getPerimeter() {
		return Math.PI * 2 * radius;
	}//end getPerimeter
	
	public boolean contains(double x, double y) {
		boolean isContained = false;
		if(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) < Math.pow(this.radius, 2))
				isContained = true;
		return isContained;
	}
	
	public boolean contains(Circle2D circle) {
		boolean isContained = false;
		return isContained;
	}
	
	public boolean overlaps(Circle2D circle) {
		boolean isContained = false;
		return isContained;
	}
	
	/***Set/Get***/
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}//end class
