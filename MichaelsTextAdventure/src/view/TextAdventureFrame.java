package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;


@SuppressWarnings("serial")
public class TextAdventureFrame extends JFrame
{
	Control control;
	public TextAdventureGeneralPanel menuPanel;
	private JPanel cardPanel;
	
	public TextAdventureFrame(Control control)
	{
		super();
		this.control = control;
		this.menuPanel = new TextAdventureGeneralPanel(this.control);
		this.cardPanel = new JPanel(new CardLayout());
		
		setupFrame();
	}
	
	/**
	 * Method responsible for setting up the frame (and changing the background color)
	 */
	private void setupFrame() {
		
		cardPanel.add(menuPanel, "Menu");
		menuPanel.setBackground(Color.BLACK);
		
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
