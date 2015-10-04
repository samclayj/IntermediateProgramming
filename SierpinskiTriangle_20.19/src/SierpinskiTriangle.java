/***NEEDS WORK***/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SierpinskiTriangle extends JApplet {
	//private JTextField jftOrder = new JTextField("0", 5); //order
	private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel(); //to display pattern
	private JButton plusButton = new JButton("+");
	private JButton minusButton = new JButton("-");
	
	public SierpinskiTriangle() {
		//Panel to hold label, text field, and a button
		JPanel panel = new JPanel();
		panel.add(plusButton);
		plusButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(minusButton);
		minusButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Add a Sierpinski triangle panel to the applet
		add(trianglePanel);
		add(panel, BorderLayout.SOUTH);

		//Register a listener
		plusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trianglePanel.setOrder(trianglePanel.getOrder() + 1);
			}
		});
		
		minusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trianglePanel.setOrder(trianglePanel.getOrder() - 1);
			}
		});

	}//end constructor

	static class SierpinskiTrianglePanel extends JPanel {
		private int order = 0;

		/**Set new order**/
		public void setOrder(int order) {
			if(order > 0)
				this.order = order;
			repaint();
		}
		
		public int getOrder() {
			return this.order;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			//select three points in proportion to the panel size
			Point p1 = new Point(getWidth() / 2, 10);
			Point p2 = new Point(10, getHeight() - 10);
			Point p3 = new Point(getWidth() - 10, getHeight() - 10);

			displayTriangles(g, order, p1, p2, p3);
		}//end paintComponent

		private static void displayTriangles(Graphics g, int order, Point p1, Point p2, Point p3) {
			if (order == 0) {
				//draw triangle to display three points
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
				g.drawLine(p1.x, p1.y, p3.x, p3.y);
				g.drawLine(p2.x, p2.y, p3.x, p3.y);
			}
			else {
				//Get the midpoint on each edge of the triangle
				Point p12 = midpoint(p1, p2);
				Point p23 = midpoint(p2, p3);
				Point p31 = midpoint(p3, p1);

				//Recursively display three triangles
				displayTriangles(g, order - 1, p1, p12, p31);
				displayTriangles(g, order - 1, p12, p2, p23);
				displayTriangles(g, order - 1, p31, p23, p3);
			}

		}//end displayTriangles

		private static Point midpoint(Point p1, Point p2) {
			return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
		}//end midPoint

	}//end class
}//end class

