package JColorSelector.Structure.Tabs.Advanced.RGBKeyAdapters;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import JColorSelector.Structure.Tabs.Advanced.RGBValues;
import javax.swing.JTextField;
import JColorSelector.Event.ColorChosenListener;

public class RKeyAdapter extends KeyAdapter
{
    private RGBValues rgbValues;
    private JTextField r;
    private ArrayList<ColorChosenListener> colorChosenListeners;

    public RKeyAdapter(RGBValues rgbValues, JTextField textField, ArrayList<ColorChosenListener> chosen)
    {
        this.r = textField;
        this.rgbValues = rgbValues;
        this.colorChosenListeners = chosen;
    }
    public void keyTyped(KeyEvent e)
    {
        if(this.r.getText().isEmpty())
        {
            this.rgbValues.setR(0);
        }else if(this.r.getText().length() > 2)
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
                String rStringed = String.valueOf(this.rgbValues.getR());
                int rInt = (rStringed.length() > 1) ?Integer.parseInt(rStringed.substring(0, rStringed.length() - 1)) : 0;
                this.rgbValues.setR(rInt);
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

        char typedR = e.getKeyChar();
        String existingR = this.r.getText();
        String rStr = existingR + typedR;

        int rInt = Integer.parseInt(rStr);

        if(rInt >255)
        {
            this.rgbValues.setR(255);
            return;
        }

        this.rgbValues.setR(rInt);
        this.colorChosenListeners.forEach(x->x.colorChosen(new Color(rInt, this.rgbValues.getG(),this.rgbValues.getB())));
    }
}