import java.util.*;
import javax.swing.*;
//Work on this one.
public class DisplayCal {

	public static void main(String[] args) {
		
		PrintCal cal = new PrintCal(2012, 1);
		
		cal.printMonth();
		
		System.out.println(cal.cal);
		
		JTextField label = new JTextField(cal.cal);
		
		JPanel panel = new JPanel();
		panel.add(label);
		
		JFrame frame = new JFrame();
		frame.add(label);
		frame.setTitle("Calendar");
		frame.setSize(450, 450);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}//end main
	
}
