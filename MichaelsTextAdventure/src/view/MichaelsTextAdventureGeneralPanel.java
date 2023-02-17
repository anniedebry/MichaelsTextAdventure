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

@SuppressWarnings("serial")
public class TextAdventureGeneralPanel extends JPanel{
	Control controller;
	private JPanel menuPanel; 
	private SpringLayout layout;
	private JScrollPane textPane;
	private JTextField textField;
	private JTextPane displayTextPane;
	
	public TextAdventureGeneralPanel(Control controller) {
		super();
		this.controller = controller;
		this.setLayout(layout);
		this.textField = new JTextField("Type here", 50);
		this.textPane = new JScrollPane(displayTextPane);
		this.layout = new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, textPane);
		layout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textPane);
		layout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textPane);
		layout.putConstraint(SpringLayout.NORTH, textPane, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, textPane, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, textPane, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, textPane, -10, SpringLayout.EAST, this);
		this.menuPanel = new JPanel(new GridLayout(0, 1));
		
		setupPanel();
		setupTextPane();
	}
	
	public void setupPanel() {
		this.add(textField);
		this.add(textPane);
		this.setLayout(layout);
		this.add(menuPanel);
		
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
	}
	
	
}
