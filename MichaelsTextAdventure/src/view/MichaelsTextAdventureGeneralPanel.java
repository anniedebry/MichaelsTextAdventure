package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TextAdventureGeneralPanel extends JPanel{
	private Control controller;
	private JPanel menuPanel; 
	private SpringLayout layout;
	private JScrollPane textPane;
	private JTextField textField;
	private JTextPane displayTextPane;
	
	public TextAdventureGeneralPanel(Control controller) {
		super();
		this.controller = controller;
	}
	
	public void setupPanel() {
		this.setLayout(layout);
		this.add(menuPanel);
		this.textField = new JTextField("Type here", 50);
		this.textPane = new JScrollPane(displayTextPane);
		this.layout = new SpringLayout();
		this.setLayout(layout);
		this.menuPanel = new JPanel(new GridLayout(0, 1));
		
		setupTextPane();
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
	
	public void setupTextPane() {
		//displayTextPane
		this.displayTextPane = new JTextPane();
		displayTextPane.setBackground(new Color(255, 240, 194));
		displayTextPane.setText("test");
		SimpleAttributeSet set = new SimpleAttributeSet();
		//setting the font
		StyleConstants.setItalic(set, true); //change later
		//document creation to add new strings
		StyledDocument doc = (StyledDocument) displayTextPane.getDocument();
		Style style = doc.addStyle("StyleName", null);
		//adding displayTextPane to the frame
		displayTextPane.setEditable(false); 
		this.add(displayTextPane);
	}
}
