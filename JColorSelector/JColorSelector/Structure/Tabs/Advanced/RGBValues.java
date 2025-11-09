package JColorSelector.Structure.Tabs.Advanced;
import javax.swing.*;
import JColorSelector.Event.ColorChosenListener;
import JColorSelector.Structure.Buttons;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import JColorSelector.Structure.Tabs.Advanced.RGBKeyAdapters.*;

public class RGBValues extends JPanel
{
	private Color selectedColor;
	final private JTextField
		r = new JTextField(),
		g = new JTextField(),
		b = new JTextField();
    private int rValue = 0;
    private int gValue = 0;
    private int bValue = 0;
    private Buttons buttons;
	final private RGBValues self = this;
	public RGBValues(int width, int height, Buttons b, ArrayList<ColorChosenListener> chosen){
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new FlowLayout());
		this.buttons = b;

		Dimension panelDimension = new Dimension(width / 2, height / 4);
		Dimension labelDimension = new Dimension(panelDimension.width/4, panelDimension.height);
		
		JLabel 
			rLabel = new JLabel("Red"),
			gLabel = new JLabel("Green"),
			bLabel = new JLabel("Blue");
		JPanel 
			rPanel = new JPanel(), 
			gPanel = new JPanel(),
			bPanel = new JPanel();

		rLabel.setPreferredSize(labelDimension);
		gLabel.setPreferredSize(labelDimension);
		bLabel.setPreferredSize(labelDimension);
		
		rLabel.setHorizontalAlignment(JLabel.CENTER);
		gLabel.setHorizontalAlignment(JLabel.CENTER);
		bLabel.setHorizontalAlignment(JLabel.CENTER);
		
		rPanel.setPreferredSize(panelDimension);
		gPanel.setPreferredSize(panelDimension);
		bPanel.setPreferredSize(panelDimension);
		
		rPanel.setLayout(new BorderLayout());
		gPanel.setLayout(new BorderLayout());
		bPanel.setLayout(new BorderLayout());
		
		rPanel.add(rLabel, BorderLayout.WEST);
		gPanel.add(gLabel, BorderLayout.WEST);
		bPanel.add(bLabel, BorderLayout.WEST);
		
		rPanel.add(this.r, BorderLayout.CENTER);
		gPanel.add(this.g, BorderLayout.CENTER);
		bPanel.add(this.b, BorderLayout.CENTER);

        this.r.addKeyListener(new RKeyAdapter(this, this.r, chosen));
        this.g.addKeyListener(new GKeyAdapter(this, this.g, chosen));
        this.b.addKeyListener(new BKeyAdapter(this, this.b, chosen));

		this.add(rPanel);
		this.add(gPanel);
		this.add(bPanel);
	}
	public void setRGB(int r, int g, int b)
	{
		setRText(r);
		setGText(g);
		setBText(b);
	}
    public void setRText(int r)
    {
        this.setR(r);
        this.r.setText(String.valueOf(r));
    }
    public void setGText(int g)
    {
        this.setG(g);
        this.g.setText(String.valueOf(g));
    }
    public void setBText(int b)
    {
        this.setB(b);
        this.b.setText(String.valueOf(b));
    }
	public void setR(int r)
	{
        this.rValue = r;
        this.buttons.setColor(new Color(r, this.getG(), this.getB()));
	}
	public void setG(int g)
	{
        this.gValue = g;
        this.buttons.setColor(new Color(this.getR(), g, this.getB()));
	}
	public void setB(int b)
	{
        this.bValue = b;
        this.buttons.setColor(new Color(this.getR(), this.getG(), b));
	}
	public int getR()
	{
		return this.rValue;
	}
	public int getG()
	{
		return this.gValue;
	}
	public int getB()
	{
		return this.bValue;
	}
}

