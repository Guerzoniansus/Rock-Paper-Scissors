import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public enum Choice {

	ROCK("rock"), PAPER("paper"), SCISSORS("scissors");
	
	private String choiceAsString;
	private String imgPath;
	private BufferedImage img;
	
	public static int IMG_WIDTH = 64;
	public static int IMG_HEIGHT = 64;
	
	Choice(String choice) {
		choiceAsString = choice;
		imgPath = choice + ".jpg";
		
		try {
			img = ImageIO.read(new File(getClass().getResource(imgPath).toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public BufferedImage getImage() {
		return img;
	}
}
