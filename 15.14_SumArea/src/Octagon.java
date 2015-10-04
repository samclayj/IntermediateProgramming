
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{

	private double side;
	
	public Octagon() {
		super();
	}
	
	public Octagon(double side) {
		this.side = side;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (2 + 4 * Math.pow(2, 0.5)) * side * side;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return side * 8;
	}

	@Override
	public int compareTo(Octagon o) {
		// TODO Auto-generated method stub
		if(this.getArea() < o.getArea())
			return -1;
		else if(this.getArea() > o.getArea())
			return 1;
		else
			return 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
