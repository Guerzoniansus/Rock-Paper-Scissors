import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class GUI {
	
	JFrame frame;
	Graphics g;
	Game game;
	
	
	public void setupWindow(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		g = frame.getGraphics();
		
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				game.receiveClick(e.getPoint());
			}
		});
		
		frame.addKeyListener(game);
	}
	
	public void setupGame() {
		int centerX = (Game.WINDOW_WIDTH / 2) - (Choice.IMG_WIDTH / 2);
		
		frame.update(g);
		g.drawImage(Choice.ROCK.getImage(), Choice.ROCK.getX(), Choice.ROCK.getY(), null);
		g.drawImage(Choice.PAPER.getImage(), Choice.PAPER.getX(), Choice.PAPER.getY(), null);
		g.drawImage(Choice.SCISSORS.getImage(), Choice.SCISSORS.getX(), Choice.SCISSORS.getY(), null);
		
		drawCenteredString(g, Game.MSG_START, 100);
	}
	
	public void drawResults() {
		frame.update(g);
		
		String msg = "";
		
		if (game.winner == "draw") {
			msg = "It's a draw!";
		}
		
		else {
			if (game.winner == "opponent") {
				msg = "The winner is: the computer!";
			}
			
			else if (game.winner == "player") {
				msg = "The winner is: you!";
			}
		}
		
		drawCenteredString(g, msg, 100);
		drawCenteredString(g, "Press Space to play again", 120);
		
		int playerX = 200 - 32 - 64;
		int enemyX = 200 + 32;
		
		g.drawImage(game.getPlayerChoice().getImage(), playerX, 250, null);
		g.drawImage(game.getEnemyChoice().getImage(), enemyX, 250, null);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void drawCountdown() {
		frame.update(g);
		
		drawCenteredString(g, "Showing results in 3...", 100);
		
		final Timer timer3 = new Timer(1000, new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	 game.showResults();
		      }
		    });
		
		timer3.setRepeats(false);
		
		final Timer timer1 = new Timer(1000, new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	 frame.update(g);
		    	 drawCenteredString(g, "Showing results in 1...", 100);
		    	 timer3.start();
		      }
		    });
		
		timer1.setRepeats(false);
		
		Timer timer2 = new Timer(1000, new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	 frame.update(g);
		    	 drawCenteredString(g, "Showing results in 2...", 100);
		    	 timer1.start();
		      }
		    });
		
		timer2.setRepeats(false);
		timer2.start();
		
	}
	
	public void drawCenteredString(Graphics g, String text, int y) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(g.getFont());
	    // Determine the X coordinate for the text
	    int x = (new Rectangle(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT).width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    //int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(g.getFont());
	    // Draw the String
	    g.drawString(text, x, y);
	}
}
