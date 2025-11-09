package JColorSelector;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Optional;
import javax.swing.JFrame;
import JColorSelector.Event.*;
import JColorSelector.Popup.Popup;

public class JColorSelector
{
	private int width = 500, height = 500;
	private String title = "Select a color";
	private Optional<JFrame> parentFrame;
	private ArrayList<ColorSelectedListener> colorSelectedListeners = new ArrayList<>();
	private ArrayList<CanceledListener> canceledListeners = new ArrayList<>();
	private ArrayList<ColorChosenListener> colorChosenListeners = new ArrayList<>();
	private ArrayList<Popup> activePopups = new ArrayList<>();

	public JColorSelector()
	{
	}
	public JColorSelector(JFrame parent)
	{
		this.setParent(parent);
	}
	public JColorSelector(int width, int height)
	{
		this.setSize(width, height);
	}
	public JColorSelector(String title)
	{
		this.setTitle(title);
	}
	public JColorSelector(JFrame parent, int width, int height, String title)
	{
		this.setParent(parent);
		this.setSize(width, height);
		this.setTitle(title);
	}
	public void setDefaultChosenColor(Color c)
	{
		
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public void setParent(JFrame parent)
	{
		this.parentFrame = Optional.ofNullable(parent);
	}
	public int getWidth()
	{
		return this.width;
	}
	public int getHeight()
	{
		return this.height;
	}
	public void setSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	public void addColorSelectedListener(ColorSelectedListener l)
	{
		this.colorSelectedListeners.add(l);
	}
	public void removeColorSelectedListener(ColorSelectedListener l)
	{
		this.colorSelectedListeners.remove(l);
	}
	public void addCanceledListener(CanceledListener l)
	{
		this.canceledListeners.add(l);
	}
	public void removeCanceledListener(CanceledListener l)
	{
		this.canceledListeners.remove(l);
	}
	public void addColorChosenListener(ColorChosenListener l)
	{
		this.colorChosenListeners.add(l);
	}
	public void removeColorChosenListener(ColorChosenListener l)
	{
		this.colorChosenListeners.remove(l);
	}
	public void start()
	{
		if(parentFrame.isEmpty())
		{
			return;
		}
		this.activePopups.add(new Popup(parentFrame.get(), this.width, this.height, this.title, this.colorSelectedListeners, this.colorChosenListeners, this.canceledListeners));
	}
	public void end()
	{
		this.activePopups.forEach(e->
		{
			e.dispose();
		});
		this.activePopups.clear();
	}
}