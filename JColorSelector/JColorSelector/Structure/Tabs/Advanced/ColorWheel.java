package JColorSelector.Structure.Tabs.Advanced;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import JColorSelector.Event.*;
import JColorSelector.Structure.Buttons;

public class ColorWheel extends JLabel
{ 
	public ColorWheel(int width, int height, ArrayList<ColorChosenListener> colorChosenListeners, Buttons b, RGBValues rgbValues)
	{
		ImageIcon image = new ImageIcon("Resources//ColorWheel.png");
		Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

		this.setIcon(scaledImageIcon);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				try {
					Color color = new Robot().getPixelColor(e.getXOnScreen(), e.getYOnScreen());
					b.setColor(color);
					rgbValues.setRGB(color.getRed(), color.getGreen(), color.getBlue());
					for(int i = 0; i < colorChosenListeners.toArray().length; i++)
					{
						colorChosenListeners.get(i).colorChosen(color);
					}
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}