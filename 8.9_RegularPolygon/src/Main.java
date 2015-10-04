
public class Main {
	
	public static void main(String[] args) {
		RegularPolygon r1 = new RegularPolygon();
		RegularPolygon r2 = new RegularPolygon(6, 4);
		RegularPolygon r3 = new RegularPolygon(10, 4, 5.6, 7.8);

		System.out.printf("R1: Area %.2f, Perimeter %.2f", r1.getArea(), r1.getPerimeter());
		System.out.printf("\nR2: Area %.2f, Perimeter %.2f", r2.getArea(), r2.getPerimeter());
		System.out.printf("\nR3: Area %.2f, Perimeter %.2f", r3.getArea(), r3.getPerimeter());
		
	}//end main
}//end class