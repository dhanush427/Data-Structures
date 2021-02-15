import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//for your maze havd a test file with #
//make a new file Class called Location which has setx . sety, getx, gety
//have an Explorer Class,
		//public Explorere (Location loc, int dir, int size, Color color)
		// public void move (int key, char[][] maze)
// Have a Hero class 
public class MazeProject extends JPanel implements KeyListener {

	
	JFrame frame;
	int x = 300;
	int y = 250;
	
	
	public MazeProject() {
		
		frame = new JFrame("A-Mazing Program");
		frame.add(this);
		frame.setSize(1200, 700);
		frame.addKeyListener(this);
		frame.setBackground(Color.BLACK);
		//up : 38
		//down: 40
		//right: 39
		//left: 37
		//spacebar: 32
	//initializing of variables and arrays and stuff
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		

		
		
		
		
		
		
		
		
		
		
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);//giant eraser for code 
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		
		g2.setColor(new Color(120,180,0));
		g2.fillOval(x, y, 30, 30);
		g2.setColor(Color.MAGENTA);
		g2.setStroke(new BasicStroke(5));
		g2.drawOval(x, y, 30, 30);
	}
	
	public void keyPressed (KeyEvent e) {
			System.out.println(e.getKeyCode());
			
			
			if(e.getKeyCode()==38)//forward
				y-=30;
		//keep in mind of what rotation you are in 	
			repaint();
	}
	public void keyReleased (KeyEvent e) {
		
	}
	public void keyTyped (KeyEvent e) {
		
	}
	public static void main(String[] args) {

	}

}
