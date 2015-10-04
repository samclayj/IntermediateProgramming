import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainMenuAlpha1 {

	public static void main(String[] args) {
	   final JFrame guiFrame = new JFrame();
		//make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Game of Dungeons");
        guiFrame.setSize(800,800);
        
        JPanel guiPanel = new JPanel();
        guiPanel.setSize(80, 20);
        
        JPanel guiPanel2 = new JPanel();
        guiPanel2.setSize(200, 100);
       final JLabel label = new JLabel("USER INTERACTION!!!!!");
        guiPanel2.add(label);
        label.setVisible(false);
        
        ImageIcon image1 = new ImageIcon("/Users/SamJ/Desktop/testImage.jpg");
        final JPanel guiPanel3 = new JPanel();
        JLabel label2 = new JLabel(image1);
        label2.setSize(80,80);
        guiPanel3.setSize(80,80);
        guiPanel3.add(label2);
        
      //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        
        JButton button1 = new JButton( "Test Button");
        button1.setPreferredSize(new Dimension(160,80));
        guiPanel.add(button1);
        
        //The ActionListener class is used to handle the
        //event that happens when the user clicks the button.
        //As there is not a lot that needs to happen we can 
        //define an anonymous inner class to make the code simpler.
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
            	label.setVisible(!label.isVisible());
            }
        });
        
        //make sure the JFrame is visible
        guiFrame.add(guiPanel, BorderLayout.SOUTH);
        guiFrame.add(guiPanel2, BorderLayout.CENTER);
        guiFrame.add(guiPanel3);
        guiFrame.setVisible(true);

	}//end main
	
}
