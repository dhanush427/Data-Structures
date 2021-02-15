import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;

public class JuliaSetProgram extends JPanel implements AdjustmentListener
{

	JFrame frame;
	int red,green,blue;
	JScrollBar redBar,greenBar,blueBar;
	JPanel scrollPanel,labelPanel,bigPanel;
	JLabel redLabel,greenLabel,blueLabel;

	public JuliaSetProgram()
	{
		frame=new JFrame("Julia Set Program");
		frame.add(this);
		frame.setSize(1000,600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//orientation,starting value,doodad size,min value,max value
		redBar=new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
		red=redBar.getValue();
		redBar.addAdjustmentListener(this);

		greenBar=new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
		green=greenBar.getValue();
		greenBar.addAdjustmentListener(this);

		blueBar=new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
		blue=blueBar.getValue();
		blueBar.addAdjustmentListener(this);

		GridLayout grid=new GridLayout(3,1);
		redLabel=new JLabel("Red");
		greenLabel=new JLabel("Green");
		blueLabel=new JLabel("Blue");

		labelPanel=new JPanel();
		labelPanel.setLayout(grid);
		labelPanel.add(redLabel);
		labelPanel.add(greenLabel);
		labelPanel.add(blueLabel);

		scrollPanel=new JPanel();
		scrollPanel.setLayout(grid);
		scrollPanel.add(redBar);
		scrollPanel.add(greenBar);
		scrollPanel.add(blueBar);

		bigPanel=new JPanel();
		bigPanel.setLayout(new BorderLayout());
		bigPanel.add(labelPanel,BorderLayout.WEST);
		bigPanel.add(scrollPanel,BorderLayout.CENTER);

		frame.add(bigPanel,BorderLayout.SOUTH);

		frame.setVisible(true);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//g.setColor(Color.MAGENTA);
		g.setColor(new Color(red,green,blue));
		g.fillRect(0,0,frame.getWidth(),frame.getHeight());

	}
	public BufferedImage drawJulia(Graphics g)
	{
		//put your drawJulia image code in here
		return null;
	}



	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		if(e.getSource()==redBar)
			red=redBar.getValue();
		if(e.getSource()==greenBar)
			green=greenBar.getValue();
		if(e.getSource()==blueBar)
			blue=blueBar.getValue();
		repaint();
	}

	public static void main(String[] args)
	{
		JuliaSetProgram app=new JuliaSetProgram();
	}

}