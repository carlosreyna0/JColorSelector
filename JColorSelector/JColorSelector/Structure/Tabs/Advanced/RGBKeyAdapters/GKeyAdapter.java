package JColorSelector.Structure.Tabs.Advanced.RGBKeyAdapters;
import java.awt.*;
import java.awt.event.*;
import JColorSelector.Structure.Tabs.Advanced.RGBValues;
import javax.swing.JTextField;
import JColorSelector.Event.ColorChosenListener;
import java.util.ArrayList;

public class GKeyAdapter extends KeyAdapter
{
    private RGBValues rgbValues;
    private JTextField g;
    private ArrayList<ColorChosenListener> colorChosenListeners;

    public GKeyAdapter(RGBValues rgbValues, JTextField textField, ArrayList<ColorChosenListener> chosen)
    {
        this.g= textField;
        this.rgbValues = rgbValues;
        this.colorChosenListeners = chosen;
    }
    public void keyTyped(KeyEvent e)
    {
        if(this.g.getText().isEmpty())
        {
            this.rgbValues.setG(0);
        }else if(this.g.getText().length() > 2)
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
                String gStringed = String.valueOf(this.rgbValues.getG());
                int gInt = (gStringed.length() > 1) ?Integer.parseInt(gStringed.substring(0, gStringed.length() - 1)) : 0;
                this.rgbValues.setG(gInt);
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

        char typedG = e.getKeyChar();
        String existingG = this.g.getText();
        String gStr = existingG + typedG;

        int gInt = Integer.parseInt(gStr);

        if(gInt >255)
        {
            this.rgbValues.setG(255);
            return;
        }

        this.rgbValues.setG(gInt);
        this.colorChosenListeners.forEach(x->x.colorChosen(new Color(this.rgbValues.getR(), gInt,this.rgbValues.getB())));
    }
}