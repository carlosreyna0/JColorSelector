package JColorSelector.Event;
import java.awt.Color;

@FunctionalInterface
public interface ColorChosenListener
{
	public void colorChosen(Color c);
}