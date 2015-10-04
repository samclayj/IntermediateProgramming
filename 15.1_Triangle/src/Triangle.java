
public class Triangle extends GeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		
	}
	
	public Triangle(double side1, double side2, double side3, boolean filled, String color) {
		super(color, filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
 	
	@Override
	public double getArea() {
		double p = getPerimeter() / 2;
		double area = Math.pow(p * (p - side1) * (p - side2) * (p - side3), 0.5);
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = side1 + side2 + side3;
		return perimeter;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Area: " + getArea() + " Perimeter: " + getPerimeter();
	}
}
