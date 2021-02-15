import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JuliaSetWalkThrough extends JPanel implements AdjustmentListener, ActionListener
{

	BufferedImage image;
	JFrame frame;
	JPanel scrollPanel,labelPanel,bigPanel;
	JScrollBar aBar,bBar,zoomBar,hueBar,satBar,brightBar;
	JLabel aLabel,bLabel, zoomLabel,hueLabel,satLabel,brightLabel;
	JButton reset, save;
	JFileChooser fileChooser;
;
	double aVal,bVal;
	double hue,saturation,brightness;
	double zoom;
	float maxIter = 300f;
	
	
	public JuliaSetWalkThrough()
	{
		frame=new JFrame("Julia Set Program");
		frame.add(this);
		frame.setSize(1000,600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//orientation,starting value,doodad size,min value,max value
		aBar=new JScrollBar(JScrollBar.HORIZONTAL,0,0,-2000,2000);
		aVal=aBar.getValue()/1000.0;
		aBar.addAdjustmentListener(this);

		bBar=new JScrollBar(JScrollBar.HORIZONTAL,0,0,-2000,2000);
		bVal=bBar.getValue()/1000.0;
		bBar.addAdjustmentListener(this);
		
		zoomBar=new JScrollBar(JScrollBar.HORIZONTAL,10,0,0,100);
		zoom =zoomBar.getValue()/10.0;
		zoomBar.addAdjustmentListener(this);
		
		hueBar=new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,100);
		hue =hueBar.getValue()/100.0;
		hueBar.addAdjustmentListener(this);
		
		satBar=new JScrollBar(JScrollBar.HORIZONTAL,100,0,0,100);
		saturation =satBar.getValue()/100.0;
		satBar.addAdjustmentListener(this);
		
		brightBar=new JScrollBar(JScrollBar.HORIZONTAL,100,0,0,100);
		brightness =brightBar.getValue()/100.0;
		brightBar.addAdjustmentListener(this);

		GridLayout grid=new GridLayout(8,1);
		
		aLabel=new JLabel("A: " + aVal);
		bLabel=new JLabel("B: " + bVal);
		zoomLabel=new JLabel("Zoom: " + zoom);
		hueLabel=new JLabel("Hue: " + hue);
		satLabel=new JLabel("Saturation: " + saturation);
		brightLabel=new JLabel("Brightness: " + brightness);
		
		labelPanel=new JPanel();
		labelPanel.setLayout(grid);
		
		scrollPanel=new JPanel();
		scrollPanel.setLayout(grid);
		
		labelPanel.add(aLabel);
		scrollPanel.add(aBar);
		
		labelPanel.add(bLabel);
		scrollPanel.add(bBar);
		
		labelPanel.add(zoomLabel);
		scrollPanel.add(zoomBar);
		
		labelPanel.add(hueLabel);
		scrollPanel.add(hueBar);
		
		labelPanel.add(satLabel);
		scrollPanel.add(satBar);
		
		labelPanel.add(brightLabel);
		scrollPanel.add(brightBar);
		
		reset = new JButton();
		reset.setText("Reset");
		reset.setPreferredSize(new Dimension(70, 10));
		reset.addActionListener(this);
		
		labelPanel.add(reset);
		
		save = new JButton("Save");
		String currDir=System.getProperty("user.dir");
		fileChooser=new JFileChooser(currDir);
		save.setPreferredSize(new Dimension(70, 10));
		save.addActionListener(this);
		
		scrollPanel.add(save);

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
		g.drawImage(drawJulia(),0,0,null);

	}
	public BufferedImage drawJulia()
	{
		int w = frame.getWidth();
		int h = frame.getHeight();
		
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		for (int x=0; x < w; x++)
		{
			for (int y=0; y < h; y++)
			{
				
				float i = maxIter;
				double zx = 1.5*((x-(w/2.0))/(0.5*zoom*w));
				double zy = (y-h/2.0)/(0.5*zoom*h);
				
				while (zx*zx+zy*zy<6 && i>0)
				{
					double difSquare = zx*zx - zy*zy + aVal ;
					zy = (2.0*zx*zy)+bVal;
					zx = difSquare;
					i--;
				}
				//hue,saturation,brightness
				//number that is 0 <= n <= 1
				
				int c;
				float hue2 = (float) hue;		// 0 = red : 0.33 green : 0.66 blue : 1 = red
				float sat2 = (float) saturation;
				float brightness2 = (float) brightness;
				if (i>0)
					c = Color.HSBtoRGB(hue2*(maxIter/i) % 1, sat2, brightness2);
				
				else c = Color.HSBtoRGB(maxIter/i, 1, 0);
				
				image.setRGB(x,y,c);
			}
		}
		
		return image;
	}



	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		if(e.getSource()== aBar) {
			aVal=aBar.getValue()/1000.0;
			aLabel.setText("A: " + aVal + "\t\t");
		}
		else if(e.getSource()==bBar) {
			bVal=bBar.getValue()/1000.0;
			bLabel.setText("B: " + bVal + "\t\t");
		}
		else if(e.getSource()==zoomBar) {
			zoom=zoomBar.getValue()/10.0;
			zoomLabel.setText("Zoom: " + zoom + "\t\t");
		}
		else if(e.getSource()==hueBar) {
			hue=hueBar.getValue()/100.0;
			hueLabel.setText("Hue: " + hue + "\t\t");
		}
		else if(e.getSource()==satBar) {
			saturation=satBar.getValue()/100.0;
			satLabel.setText("Saturation: " + saturation + "\t\t");
		}
		else if(e.getSource()==brightBar) {
			brightness=brightBar.getValue()/100.0;
			brightLabel.setText("Brightness: " + brightness + "\t\t");
		}
		repaint();
	}

	public static void main(String[] args)
	{
		JuliaSetWalkThrough app=new JuliaSetWalkThrough();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reset) {
            aBar.setValue(0);
            bBar.setValue(0);
            zoomBar.setValue(10);
            hueBar.setValue(0);
            satBar.setValue(100);
            brightBar.setValue(100);
        }
		if (e.getSource() == save) {
			System.out.println("Saved");
			saveImage();
        }
        repaint();
	}
	
	public void saveImage()
	{
		if(image!=null)   //juliaImage is the BufferedImage I declared globally (and used in 
                                                    //the drawJulia method)
		{
			FileFilter filter=new FileNameExtensionFilter("*.png","png");
		        fileChooser.setFileFilter(filter);
			if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
			{
				File file=fileChooser.getSelectedFile();
				try
				{
					String st=file.getAbsolutePath();
					if(st.indexOf(".png")>=0)
						st=st.substring(0,st.length()-4);
					ImageIO.write(image,"png",new File(st+".png"));
				}catch(IOException e)
				{
				}

			}
		}
	}

}