package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.SwingUtilities;

/**
 * Class responsible for loading in images and processing text, contains the run method
 * @author Annie de Bry
 * @version January 2023
 *
 */

public class Control implements Runnable
{

	TextAdventureFrame view;
	GeneralText mainText;
	Map<String, BufferedImage> countMap;
	
	public Control()
	{
		SwingUtilities.invokeLater(this);
	}
	
	@Override
	public void run() 
	{
		countMap = new TreeMap<String, BufferedImage>();
		view = new TextAdventureFrame(this);
		this.mainText = new GeneralText();
	}
	
	/**
	 * Method responsible for loading in images into the view
	 * @param filename
	 * @return newImage if the countMap contains the called filename, image if found in the resources folder
	 * null if the image couldn't be loaded.
	 */
	public BufferedImage getImage(String filename)
	{
		if(countMap.containsKey(filename))
		{
			BufferedImage newImage = countMap.get(filename);
			return newImage;
		}
		try
		{
			ClassLoader myLoader = this.getClass().getClassLoader();
			InputStream imageStream = myLoader.getResourceAsStream("resources/" + filename);
			BufferedImage image = javax.imageio.ImageIO.read(imageStream);
			return image;
		}
		catch(IOException e)
		{
			System.out.println("Could not find or load resources/ " + filename);
			System.exit(0);
			return null;
		}
	}
	
	//returns inputed response
		public String processText(String text) 
		{
			String response = "";
			
			//how chatbot responds
			response += mainText.processText(text) + ("\n");
			
			return response;
		}
		
		public String interactWithChatbot(String text) 
		{
			String response = "";
			
			//the display set up of your text
			response += ("(You): ") + text + ("\n");
			
			return response;
		}
		
		//catching errors
		public void handleError(Exception error) 
		{
			String details = "Your error is: " + error.getMessage();
			System.out.println(details);
		}

}
