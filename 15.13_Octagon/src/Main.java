
public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Octagon og = new Octagon(4);
		Octagon og1 = new Octagon(5);
		
		System.out.println(og.compareTo(og1));
		
		Octagon og2 = (Octagon)og.clone();
		
		System.out.println(og2.compareTo(og));
		
		System.out.println(og2.equals(og));
	}
	
}
