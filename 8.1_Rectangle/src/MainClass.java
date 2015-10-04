
public class MainClass {
	
	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(4, 40);
		Rectangle r2 = new Rectangle(3.5, 39.5);
		
		System.out.printf("The first rectangle has width %4.2f, height %4.2f, area %4.2f, and perimeter %4.2f", 
				r1.width, r1.height, r1.getArea(), r1.getPerimeter());
		
		System.out.printf("\nThe second rectangle has width %4.2f, height %4.2f, area %4.2f, and perimeter % 4.2f",
				r2.width, r2.height, r2.getArea(), r2.getPerimeter());
		
	}//end main
	
}
