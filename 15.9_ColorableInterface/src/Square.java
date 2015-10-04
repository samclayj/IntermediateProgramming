
public class Square extends GeometricObject implements Colorable {
	private double side = 0;
	
	public Square() {
		
	}
	
	public Square(double side, String color, boolean filled) {
		this.side = side;
		setColor(color);
		setFilled(filled);
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return side * side;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return side * 4;
	} 

	@Override
	public String howToColor() {
		// TODO Auto-generated method stub
		String returnString;
		if(!isFilled())
			returnString = "Color each of the sides.";
		else
			returnString = "Fill in the square.";
			
		return returnString;
	}

}
