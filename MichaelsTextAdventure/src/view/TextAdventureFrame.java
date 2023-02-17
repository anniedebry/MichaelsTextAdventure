package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;


public class TextAdventureFrame extends JFrame
{
	Control control;
	private TextAdventureGeneralPanel menuPanel;
	private JPanel cardPanel;
	
	public TextAdventureFrame(Control control)
	{
		super();
		this.control = control;
		this.menuPanel = new TextAdventureGeneralPanel(this.control);
		//holds all the different panels
		this.cardPanel = new JPanel(new CardLayout());
		
		//chatPane
//		add(chatPane);
//		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		setupFrame();
	}
	
	/**
	 * Method responsible for setting up the frame (and changing the background color)
	 */
	private void setupFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(cardPanel);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		this.setTitle("Michaels Text Adventure");
		this.setVisible(true);
	}
	
	/**
	 * Method that allows the Panels to be changed
	 * @param screen
	 */
	public void changeScreen(String screen) {
		((CardLayout) cardPanel.getLayout()).show(cardPanel, screen);
	}
}
