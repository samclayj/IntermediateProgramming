
public class Fan {
	/***Data Fields***/
    private final static int SLOW = 1;
	private final static int MEDIUM = 2;
	private final static int FAST = 3;
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	
	/***Setter and Getter Methods***/
	public int getSpeed() {
		return speed;
	}//end getSpeed
	
	public void setSpeed(int newSpeed) {
		if(newSpeed >= FAST)
			speed = FAST;
		else if(newSpeed == 2)
			speed = MEDIUM;
		else
			speed = SLOW;
	}//end setSpeed
	
	public boolean isOn() {
		return on;
	}//end isOn
	
	public void setOn(boolean onState) {
		on = onState;
	}//end setOn
	
	public double getRadius() {
		return radius;
	}//end getRadius
	
	public void setRadius(double newRadius) {
		radius = newRadius;
	}//end setRadius
	
	public String getColor() {
		return color;
	}//end getColor
	
	public void setColor(String newColor) {
		color = newColor;
	}//end setColor
	
	/***Constructors*/
	public Fan() {
		
	}//end Fan
	
	/***Methods***/
	public static void main(String[] args) {
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		
		f1.setSpeed(3);
		f1.setRadius(10);
		f1.setColor("yellow");
		f1.setOn(true);
		
		f2.setSpeed(2);
		f2.setRadius(5);
		f2.setColor("blue");
		f2.setOn(false);
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
	}//end main
	
	public String toString() {
		String desc = "Fan speed is " + speed + ". The fan's color is " + color + ". The radius is " + radius + ".";
		if(on)
			desc += " The fan is on.";
		else
			desc+= " The fan is off.";
		return desc;
	}//end toString()
	
	
	
}
