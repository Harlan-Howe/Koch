import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class KochFrame extends JFrame {

	private SnowPanel myPanel;
	private JSlider mySlider;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		KochFrame app = new KochFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public KochFrame()
	{
		super("Koch Snowflake");
		this.getContentPane().setLayout(new BorderLayout());
		JPanel sliderPanel = new JPanel(new FlowLayout());
		sliderPanel.add(new JLabel("Recursion Depth"));
		mySlider = new JSlider(0,10,0);
		mySlider.setMajorTickSpacing(1);
		mySlider.setPaintTicks(true);
		sliderPanel.add(mySlider);
		mySlider.addChangeListener(new SliderListener());
		this.getContentPane().add(sliderPanel,BorderLayout.SOUTH);
		myPanel = new SnowPanel();
		myPanel.setPreferredSize(new Dimension(800,800));
		this.getContentPane().add(myPanel,BorderLayout.CENTER);
		setSize(800,900);
		setResizable(false);
		setVisible(true);
		
	}
	
	public class SliderListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent ce)
		{
			if (mySlider.getValueIsAdjusting())
				return;
			myPanel.setDepth(mySlider.getValue());
		}
	}
}
