
public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return this.filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return this.dateCreated;
	}
	
	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
		if(o1.compareTo(o2) <= 0)
			return o2;
		else
			return o1;
	}
 	
	@Override 
	public int compareTo(GeometricObject o) {
		int type;
		if(this.getArea() - o.getArea() > 0)
			type = 1;	
		else if(this.getArea() - o.getArea() == 0)
			type = 0;
		else
			type = -1;
		return type;	
	}
}
