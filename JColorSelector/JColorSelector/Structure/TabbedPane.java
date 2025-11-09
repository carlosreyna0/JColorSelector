package JColorSelector.Structure;
import javax.swing.*;
import JColorSelector.Structure.Tabs.Advanced.ColorWheel;
import JColorSelector.Structure.Tabs.Advanced.RGBValues;
import java.awt.BorderLayout;
import java.util.ArrayList;
import JColorSelector.Event.ColorChosenListener;
import JColorSelector.Structure.Tabs.Basic.CommonColors;

public class TabbedPane extends JPanel
{
	private JPanel
		advancedTab = new JPanel();

	public TabbedPane(int width, int height, ArrayList<ColorChosenListener> chosenListeners, Buttons b)
	{
		this.advancedTab.setLayout(new BorderLayout());

		RGBValues rgbValues = new RGBValues(width, height/3, b, chosenListeners);
		ColorWheel colorWheel = new ColorWheel(width / 2,width / 2, chosenListeners,b, rgbValues);
		
		this.advancedTab.add(rgbValues, BorderLayout.SOUTH);
		this.advancedTab.add(colorWheel, BorderLayout.CENTER);

        this.add(advancedTab);
	}
}