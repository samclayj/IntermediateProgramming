
public class Rectangle {
	
	/***Data Fields***/
	double width = 1;
	double height = 1;
	
	public Rectangle() {
		
	}//end Rectangle no argument
	
	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}//end Rectangle w/ argument
	
	public double getArea() {
		return width * height;
	}//end getArea
	
	public double getPerimeter() {
		return (width * 2) + (height * 2);
	}//end getPerimeter
	
}
