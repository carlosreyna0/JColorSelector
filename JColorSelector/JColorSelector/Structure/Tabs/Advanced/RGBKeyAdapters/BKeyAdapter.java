package JColorSelector.Structure.Tabs.Advanced.RGBKeyAdapters;
import java.awt.event.*;
import JColorSelector.Structure.Tabs.Advanced.RGBValues;
import javax.swing.JTextField;
import JColorSelector.Event.ColorChosenListener;
import java.util.ArrayList;
import java.awt.Color;

public class BKeyAdapter extends KeyAdapter
{
    private RGBValues rgbValues;
    private JTextField b;
    private ArrayList<ColorChosenListener> colorChosenListeners;

    public BKeyAdapter(RGBValues rgbValues, JTextField textField, ArrayList<ColorChosenListener> chosen)
    {
        this.b= textField;
        this.rgbValues = rgbValues;
        this.colorChosenListeners = chosen;
    }
    public void keyTyped(KeyEvent e)
    {
        if(this.b.getText().isEmpty())
        {
            this.rgbValues.setB(0);
        }else if(this.b.getText().length() > 2)
        {
            e.consume();
        }
    }
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
            case KeyEvent.VK_BACK_SPACE:
                String bStringed = String.valueOf(this.rgbValues.getB());
                int bInt = (bStringed.length() > 1) ?Integer.parseInt(bStringed.substring(0, bStringed.length() - 1)) : 0;
                this.rgbValues.setB(bInt);
                return;
            case
                    KeyEvent.VK_0,
                    KeyEvent.VK_1,
                    KeyEvent.VK_2,
                    KeyEvent.VK_3,
                    KeyEvent.VK_4,
                    KeyEvent.VK_5,
                    KeyEvent.VK_6,
                    KeyEvent.VK_7,
                    KeyEvent.VK_8,
                    KeyEvent.VK_9:
                break;
            default:
                return;
        }

        char typedB = e.getKeyChar();
        String existingB = this.b.getText();
        String bStr = existingB + typedB;

        int bInt = Integer.parseInt(bStr);

        if(bInt >255)
        {
            this.rgbValues.setB(255);
            return;
        }

        this.rgbValues.setB(bInt);
        this.colorChosenListeners.forEach(x-> x.colorChosen(new Color(this.rgbValues.getR(),this.rgbValues.getG(),bInt)));
    }
}