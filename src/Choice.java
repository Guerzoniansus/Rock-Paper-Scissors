import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public enum Choice {

	ROCK("rock", Game.CENTER_X - 32 - 64 - 64, 300),
	PAPER("paper", Game.CENTER_X - 32, 300), 
	SCISSORS("scissors", Game.CENTER_X + 32 + 64, 300);
	
	private String choiceAsString;
	private String imgPath;
	private BufferedImage img;
	
	public static int IMG_WIDTH = 64;
	public static int IMG_HEIGHT = 64;
	
	private Rectangle rectangle;
	
	private int x;
	private int y;
	
	 Choice(String choice, int x, int y) {
		choiceAsString = choice;
		imgPath = choice + ".jpg";
		this.x = x;
		this.y = y;
		
		try {
			img = ImageIO.read(getClass().getResourceAsStream(imgPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		rectangle = new Rectangle(x, y, 64, 64);
	}
	 
	public BufferedImage getImage() {
		return img;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getChoiceAsString() {
		return choiceAsString;
	}
	
	public Choice[] getChoices() {
		Choice[] choices = {Choice.ROCK, Choice.PAPER, Choice.SCISSORS};
		return choices;
	
	}
}
