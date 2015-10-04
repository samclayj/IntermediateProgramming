package Practice2;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainMenuTest1 {
	/***Data Fields***/
	JFrame guiFrame;
	JPanel guiPanel1;
	ImageIcon image1;
	
	public MainMenuTest1() {
		 this.guiFrame = new JFrame();
		 this.guiFrame.setTitle("Game of Dungeons");
	     this.guiFrame.setSize(800,790);	
	     this.guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
