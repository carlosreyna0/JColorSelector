package JColorSelector.Event;
import java.awt.Color;

@FunctionalInterface
public interface ColorSelectedListener
{
	public void colorSelected(Color c);
}