
public class Main {

	public static void main(String[] args) {
		Triangle triangle1 = new Triangle(10, 12, 14, true, "Red");
		System.out.println("Triangle1: " + triangle1);
		Triangle triangle2 = new Triangle(8, 9, 10, true, "Blue");
		System.out.println("Triangle2: " + triangle2);
		Triangle triangle3 = new Triangle(14, 15, 18, true, "Pink");
		System.out.println("Triangle3: " + triangle3);

		System.out.println("Max: " + GeometricObject.max(triangle1, triangle2).getColor());
		System.out.println("Max: " + GeometricObject.max(triangle2, triangle3).getColor());
	}
}
