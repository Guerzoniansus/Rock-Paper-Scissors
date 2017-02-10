import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GUI {
	
	JFrame frame;
	Graphics g;
	
	
	public void setupWindow(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		g = frame.getGraphics();
	}
	
	
	public void setupGame() {
		int centerX = (Game.WINDOW_WIDTH / 2) - (Choice.IMG_WIDTH / 2);
		
		g.drawImage(Choice.ROCK.getImage(), centerX - 32 - 64, 300, null);
		g.drawImage(Choice.PAPER.getImage(), centerX, 300, null);
		g.drawImage(Choice.SCISSORS.getImage(), centerX + 32 + 64, 300, null);
	}

	public JFrame getFrame() {
		return frame;
	}
}
