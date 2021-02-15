import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class JuliaSetProgramSubmit extends JPanel implements AdjustmentListener
{
	JFrame frame;
	JScrollBar aScroll, bScroll;
	JPanel scrollPanel, labelPanel, bigPanel;
	JLabel aLabel, bLabel;
	double a=0.0, b=0.0;
	DecimalFormat threeDecimals=new DecimalFormat("0.000");
	
	public JuliaSetProgramSubmit()
	{
		frame=new JFrame("Julia Set Program");
		frame.add(this);
		frame.setSize(1000,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aScroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 6000);
		aScroll.addAdjustmentListener(this);
		aScroll.setPreferredSize(new Dimension(700,20));
		
		bScroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 6000);
		bScroll.addAdjustmentListener(this);
		bScroll.setPreferredSize(new Dimension(700,20));
		
		GridLayout grid=new GridLayout(2,2);
		
		aLabel = new JLabel("A: "+threeDecimals.format(a));
		bLabel = new JLabel("B: "+threeDecimals.format(b));
		
		labelPanel = new JPanel(); // labels 
		labelPanel.setLayout(grid);
		labelPanel.add(aLabel);
		labelPanel.add(bLabel);
		
		
		scrollPanel = new JPanel(); //scroll wheel 
		scrollPanel.setLayout(grid);
		scrollPanel.add(aScroll);
		scrollPanel.add(bScroll);
		
		bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout());
		bigPanel.add(labelPanel, BorderLayout.WEST);
		bigPanel.add(scrollPanel, BorderLayout.EAST);

		frame.add(bigPanel, BorderLayout.SOUTH);

		frame.setVisible(true); 
		

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawJuliaSet(g);
	}

	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		if(e.getSource()==aScroll)
		{
			a=aScroll.getValue()/1000.0;
			aLabel.setText("A: "+threeDecimals.format(a));
		}
		if(e.getSource()==bScroll)
		{
			b=bScroll.getValue()/1000.0;
			bLabel.setText("B: "+threeDecimals.format(b));
		}
		repaint();
	}

	public void drawJuliaSet(Graphics g)
	{
		int width = frame.getWidth();
		int height = frame.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		double zoom = 0.5;

		for (int i=0; i<width; i++)
		{
			for (int j=0; j<height; j++)
			{
				double zx = 1.5*(i-0.5*width)/(0.5*zoom*width);
				double zy = (j-0.5*height)/(0.5*zoom*height);
			}
		}

	}

	public static void main(String[] args)
	{
		JuliaSetProgramSubmit app = new JuliaSetProgramSubmit();
	}
}