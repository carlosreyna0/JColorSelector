package JColorSelector.Structure.Tabs.Basic;
import javax.swing.*;
import java.awt.*;

public class CommonColors extends JPanel
{
    private JPanel[] colorPanels = new JPanel[12];

    public CommonColors()
    {
        this.setLayout(new FlowLayout());

        for(int i = 0; i < colorPanels.length; i++)
        {
            colorPanels[i] = new JPanel();
        }
        for(JPanel x : colorPanels)
        {
            x.setPreferredSize(new Dimension(50,50));
            this.add(x);
        }

        colorPanels[0].setBackground(Color.RED);
        colorPanels[1].setBackground(Color.BLUE);
        colorPanels[2].setBackground(Color.GREEN);
        colorPanels[3].setBackground(Color.WHITE);
        colorPanels[4].setBackground(Color.BLACK);
        colorPanels[5].setBackground(Color.MAGENTA);
        colorPanels[6].setBackground(Color.GRAY);
        colorPanels[7].setBackground(Color.DARK_GRAY);
        colorPanels[8].setBackground(Color.LIGHT_GRAY);
        colorPanels[9].setBackground(Color.PINK);
        colorPanels[10].setBackground(Color.YELLOW);
        colorPanels[11].setBackground(Color.ORANGE);
    }
}