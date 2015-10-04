import java.awt.Point;
import java.io.File;
import java.rmi.AccessException;

public class Main {
	public static void main(String[] args) {
		/*MyArrayList<Point> list = new MyArrayList<Point>();
		for (int i = 0; i < 15; i++){ //creates 15 random points and adds them to "listÓ
			int x = (int) ((Math.random() * 100) % 100); 
			int y = (int) ((Math.random() * 100) % 100); 
			list.add(new Point(x,y));
			}
		Point pt1 = list.get(0);
		System.out.print("This point: " + pt1.toString() + " should be the same as this one: "); 
		pt1 = list.remove(0);
		System.out.println(pt1.toString());
		Point pt2 = list.get(0);
		System.out.println("This one should be different: " + pt2.toString());
		System.out.println("The current size is: " + list.size() + " - which should be 14."); 
		list.add(new Point(5,5));
		System.out.println("The current size is: " + list.size() + " - which should be 15 and");
		System.out.println("the last point is " + list.get(list.size()-1) + " which should be [x=5,y=5].");
		list.clear();
		System.out.println("The current size is: " + list.size() + " - which should be 0.");
		list.add(new Point(5,5));
		System.out.println("The current size is: " + list.size() + " - which should be 1 and");
		System.out.println("the only point is " + list.get(list.size()-1) + " which should be [x=5,y=5].");
		list.get(-1);
		list.get(1000);
		list.remove(-1);
		list.remove(1000);*/
		System.out.println(fibonacci(7));
		System.out.println(factorial(5));
		System.out.println(sumDigits(123));
		System.out.println(sumSeries(5));
		printStuff("Hey");
		printStuff(10);
		printStuff(new int[] {1,2,3,4});
		
		try {
			divideNum(0);
		}
		catch (ArithmeticException ex) {
			System.out.println(ex.toString());
			System.out.println("no division by 0");
		}
				
	}//end main
	
	public static long fibonacci(long n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static long factorial(long n) {
		if(n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}
	
	public static long sumDigits(int n) {
		if(n / 10 == 0) {
			return n;
		}
		else {
			return (n % 10) + sumDigits(n / 10);
		}
	}
	
	public static double sumSeries(int n) {
		if(n == 0) 
			return 0;
		else
			return 1.0/n + sumSeries(n - 1);
	}
	
	public static <E> void printStuff(E stuff) {
		System.out.println(stuff.toString());
	}
	
	public static void divideNum(int i) {
		if(i == 0)
			throw new ArithmeticException("You dumb.");
	}
}