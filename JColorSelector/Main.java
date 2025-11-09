import javax.swing.*;
import JColorSelector.JColorSelector;

public class Main
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,600);

		JColorSelector colorSelector = new JColorSelector(frame, 500,500, "Select a color");

        colorSelector.addColorChosenListener(System.out::println);
        colorSelector.addColorSelectedListener(System.out::println);
        colorSelector.addCanceledListener(() -> {
            System.out.println("canceled");
        });

		colorSelector.start();
	}
}