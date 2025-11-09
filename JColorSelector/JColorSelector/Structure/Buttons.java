package JColorSelector.Structure;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import JColorSelector.Event.*;

public class Buttons extends JPanel
{
	private Color selectedColor = Color.BLACK;
	private JPanel selectedColorPanel = new JPanel();
	public Buttons(int width, int height, ArrayList<ColorSelectedListener> colorSelectedListeners, JFrame parent, ArrayList<CanceledListener> canceledListeners)
	{
		Dimension buttonSize = new Dimension(width / 3, height / 5);
		JButton
			cancel = new JButton("Cancel"),
			select = new JButton("Select");
		selectedColorPanel = new JPanel();
		
		selectedColorPanel.setBackground(this.selectedColor);
		
		selectedColorPanel.setPreferredSize(new Dimension(height / 5, height / 5));
		cancel.setPreferredSize(buttonSize);
		select.setPreferredSize(buttonSize);
		
		this.setPreferredSize(new Dimension(width, height / 4));
		this.setLayout(new FlowLayout());
		
		select.addActionListener(e->
		{
			parent.dispose();
			for(int i = 0; i < colorSelectedListeners.toArray().length; i++)
			{
				colorSelectedListeners.get(i).colorSelected(getBackground());
			}
		});
		cancel.addActionListener(e->
		{
            canceledListeners.forEach(CanceledListener::canceled);
			parent.dispose();
		});
		
		this.add(cancel);
		this.add(selectedColorPanel);
		this.add(select);
	}
	public void setColor(Color c)
	{
		this.selectedColor = c;
		this.selectedColorPanel.setBackground(c);
	}
}
