import java.util.*;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Object> arrList = new ArrayList<Object>();

		Object frame = new JFrame();
		Object date = new Date();
		Object myString = "Hello!";
		Object o = new Object();	

		arrList.add(frame);
		arrList.add(date);
		arrList.add(myString);
		arrList.add(o);
		
		for(int i = 0; i < arrList.size(); i++)
			System.out.println(arrList.get(i).toString());
	}
}
