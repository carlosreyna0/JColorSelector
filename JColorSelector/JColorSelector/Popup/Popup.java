package JColorSelector.Popup;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import JColorSelector.Event.*;
import JColorSelector.Structure.Buttons;
import JColorSelector.Structure.TabbedPane;
import java.awt.BorderLayout;

public class Popup
{
	private JFrame frame;
	public Popup(JFrame parent, int width, int height, String title, ArrayList<ColorSelectedListener> colorListeners, ArrayList<ColorChosenListener> colorChosenListeners, ArrayList<CanceledListener> canceledListeners)
	{
		this.frame = new JFrame(title);
		final int
			popupX = parent.getX() + parent.getWidth() / 2 - (width/2),
			popupY = parent.getY() + parent.getHeight() / 2 - (height/2);
		
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setBounds(popupX,popupY,width,height);
		this.frame.setLayout(new BorderLayout());
		
		Buttons buttons = new Buttons(width, (int) (height / 1.5), colorListeners, this.frame, canceledListeners);
		TabbedPane tabbedPane = new TabbedPane(width, (int)(height / 1.5),colorChosenListeners,buttons);
		
		this.frame.add(buttons, BorderLayout.SOUTH);
		this.frame.add(tabbedPane, BorderLayout.CENTER);
		
		this.frame.setVisible(true);
	}
	public void dispose()
	{
		frame.dispose();
	}
}