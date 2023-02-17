package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MichaelsTextAdventureGeneralPanel extends JPanel{
	private Control controller;
	private JPanel menuPanel; 
	private SpringLayout layout;
	
	public MichaelsTextAdventureGeneralPanel(Control controller) {
		super();
		this.controller = controller;
	}
	
	public void setupPanel() {
		this.setLayout(layout);
		this.add(menuPanel);
		this.layout = new SpringLayout();
		this.menuPanel = new JPanel(new GridLayout(0, 1));
		
		updateDisplay();
		setupListeners();
	}
	
	/**
	 * method for showing images on the panel
	 */
	private void updateDisplay() {
//		String path = "/morse/view/images/";
//		String defaultName = "morseCodeTitle";
//		String extension = ".jpg";
//		
//		try {
//			titleImage = new ImageIcon(getClass().getResource(path + extension));
//		}
//		catch(NullPointerException missingFile){
//			titleImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
//		}
//		
//		imageLabel.setIcon(titleImage);
	}
	
	/**
	 * Method for changing screens 
	 */
	public void setupListeners() {
		//((MorseFrame)this.getParent().getParent()).changeScreen("screen to change to");
		
//		sentences.addActionListener(click -> controller.getFrame().changeScreen("Sentences"));
//		alphabet.addActionListener(click -> controller.getFrame().changeScreen("Alphabet"));
	}
}
