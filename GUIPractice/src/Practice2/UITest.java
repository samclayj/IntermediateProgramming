package Practice2;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UITest {
	/***Data Fields***/
	JFrame guiFrame;
	JPanel guiPanel1;
	ImageIcon image1;
	
	public UITest() throws MalformedURLException, IOException {
		 this.guiFrame = new JFrame();
		 this.guiFrame.setTitle("Game of Dungeons");
	     this.guiFrame.setSize(800,800);	
	     this.guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     this.guiPanel1 = new JPanel();
	     this.guiPanel1.setLayout(new GridLayout(10,10));
	     
	     Image image = ImageIO.read(new URL("http://www.promnite.com/~/media/Promnite/Products/Decorations/Decorating-Materials/Background-Paper/M1054F/507-600-M1054F--Patterned-Background-Paper--Animated-Cobblestone--000.ashx?w=230&h=230&bc=FFFFFF"));
	     
	     Icon icon = new ImageIcon (image.getScaledInstance(80,80,0));	     

	     for(int i = 0; i < 100; i++) {
	    	 this.guiPanel1.add(new JButton(icon));
	     }
	     
	     this.guiFrame.add(guiPanel1);  
	     
	     this.guiFrame.setVisible(true);

	}//end
	
}//end
