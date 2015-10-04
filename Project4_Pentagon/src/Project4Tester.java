import java.awt.Point;

public class Project4Tester {
	public static void main(String [] args) {
		Pentagon p1 = new Pentagon(1,2,3);
		Pentagon p2 = new Pentagon(new Point(4,5),4);
		Pentagon p3 = new Pentagon(new Point(4,5),6);
		if (p1.getPerimeter() != 15 || p2.getPerimeter() != 20 || p3.getPerimeter() != 30)
			System.err.println("Error 1: Perimeter not correct");
		if ( (p1.getArea() < 15.4 || p1.getArea() > 15.5) || 
				(p2.getArea() < 27.5 || p2.getArea() > 27.6) ||
				(p3.getArea() < 61.9 || p3.getArea() > 62.0) ) 
			System.err.println("Error 2: Area not correct");
		if ( p1.getSideLength() != 3 || p2.getSideLength() != 4 || p3.getSideLength() != 6 ) 
			System.err.println("Error 3: getSideLength not correct");
		p1.setSideLength(10);
		p2.setSideLength(11);
		p3.setSideLength(12);
		if ( p1.getSideLength() != 10 || p2.getSideLength() != 11 || p3.getSideLength() != 12 )
			System.err.println("Error 4: setSideLength not correct");
		if ( p1.getPoint().x != 1 || p2.getPoint().x != 4 || p3.getPoint().x != 4 )
			System.err.println("Error 5: getPoint not correct");
		p1.setPoint(3,4);
		p2.setPoint(new Point(5,5));
		if ( p1.getPoint().x != 3 || p2.getPoint().x != 5 || p3.getPoint().x != 4 )
			System.err.println("Error 6: setPoint not correct");
		System.out.println("If you have reached this point with no errors then your Pentagon class has passed the pass-off.");
	}//end main
}//end class