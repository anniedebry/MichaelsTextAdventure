package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class TextAdventureStoryPanel extends JPanel{
	Control controller;
	private JPanel menuPanel; 
	private SpringLayout layout;
	private JScrollPane textPane;
	private JTextField textField;
	private JTextPane displayTextPane;
	
	public TextAdventureStoryPanel(Control controller) {
		super();
		this.controller = controller;
		this.setLayout(layout);
		this.textField = new JTextField("", 50);
		this.textPane = new JScrollPane(displayTextPane);
		this.displayTextPane = new JTextPane();
		textPane.setViewportView(displayTextPane);
		displayTextPane.setText("");
		this.layout = new SpringLayout();
		this.menuPanel = new JPanel(new GridLayout(0, 1));
		
		setupTextPane();
		setupPanel();
		setupLayout();
		setupKeyListener();
	}
	
	public void setupPanel() {
		this.add(displayTextPane);
		this.add(textField);
		this.add(textPane);
		this.setLayout(layout);
		this.add(menuPanel);
		
		//colors
		textField.setBackground(Color.BLACK);
		displayTextPane.setBackground(Color.BLACK);
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
		textPane.setBackground(Color.BLACK);
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	public void setupKeyListener() {
		SimpleAttributeSet set = new SimpleAttributeSet();
		//setting the font
		StyleConstants.setItalic(set, true); //change later
		//document creation to add new strings
		StyledDocument doc = (StyledDocument) displayTextPane.getDocument();
		Style style = doc.addStyle("StyleName", null);
		//adding displayTextPane to the frame
		displayTextPane.setEditable(false); 
		
		
		//for pressing enter and printing the users response on the textPane
		textField.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e)
			{
				int keyCode = e.getKeyCode();
				//key press for enter
				if(keyCode == KeyEvent.VK_ENTER)
				{
					//printing for user chat messages
					try 
					{
						StyleConstants.setForeground(style, Color.WHITE);
						doc.insertString(doc.getLength(), controller.interactWithChatbot(textField.getText()), style);
					} 
					catch (BadLocationException e2) 
					{
						System.out.println("process chatbot error");
					}
					
					//printing for chatbot chat messages
					try 
					{	
						StyleConstants.setForeground(style, Color.WHITE);
						doc.insertString(doc.getLength(), controller.processText(textField.getText()), style);
					} 
					catch (BadLocationException e1) 
					{
						System.out.println("interact with chatbot error");
					}
					
					//clears textField when user presses enter
					textField.setText("");
				}
			}
		});
	}
	
	/**
	 * Where all the constraints go
	 */
	public void setupLayout() {
		layout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, textPane);
		layout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textPane);
		layout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textPane);
		layout.putConstraint(SpringLayout.NORTH, textPane, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, textPane, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, textPane, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, textPane, -10, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH, displayTextPane, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, displayTextPane, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, displayTextPane, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, displayTextPane, -10, SpringLayout.EAST, this);
	}
	
	
}
