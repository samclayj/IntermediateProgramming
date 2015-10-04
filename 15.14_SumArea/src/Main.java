
public class Main {

	public static void main(String[] args) {
		GeometricObject oct = new Octagon(5);
		GeometricObject tri = new Triangle(4, 5, 6, false, "Red");
		
		GeometricObject[] gArr = {oct, tri};
		
		System.out.println(GeometricObject.sumArea(gArr));
	}
	
}
