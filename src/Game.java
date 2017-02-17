import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class Game implements KeyListener {
	
	public static final String GAME_NAME = "Rock Paper Scissors";
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 400;
	public static final int CENTER_X = 200;
	
	public static final String MSG_START = "Click on an option to play";
	
	private GUI gui;
	
	public States state;
	public Choice playerChoice;
	public Choice enemyChoice;
	public String winner;
	
	
	public Game(GUI gui) {
		this.gui = gui;
	}
	
	public void init() {
		this.state = States.CHOOSING;
	}

	public void startGame() {
		init();
		gui.setupWindow(Game.GAME_NAME, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		gui.setupGame();
	}
	
	public void receiveClick(Point point) {
		if (state == States.CHOOSING) {
			
			if (getClickedChoice(point) == null) {
				return;
			}
			
			playerChoice = getClickedChoice(point);
			enemyChoice = generateRandomChoice();
			winner = calculateWinner();
			
			startCountdown();
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			//if (state == States.RESULTS) {
				restartGame();
			//}
		}
	}
	
	private void restartGame() {
		state = States.CHOOSING;
		gui.setupGame();
	}
	
	public void startCountdown() {
		state = States.COUNTDOWN;
		gui.drawCountdown();
	}
	
	public void showResults() {
		state = States.RESULTS;
		gui.drawResults();
	}
	
	public void startResults() {
		
	}
	
	public Choice getEnemyChoice() {
		return enemyChoice;
	}
	
	public Choice getPlayerChoice() {
		return playerChoice;
	}
	
	private String calculateWinner() {
		
		if (playerChoice == Choice.ROCK && enemyChoice == Choice.ROCK
				|| playerChoice == Choice.PAPER && enemyChoice == Choice.PAPER
				|| playerChoice == Choice.SCISSORS && enemyChoice == Choice.SCISSORS) {
			return "draw";
		}
		
		else if (playerChoice == Choice.ROCK && enemyChoice == Choice.PAPER) {
			return "opponent";
		}
		
		else if (playerChoice == Choice.ROCK && enemyChoice == Choice.SCISSORS) {
			return "player";
		}
		
		else if (playerChoice == Choice.PAPER && enemyChoice == Choice.ROCK) {
			return "player";
		}
		
		else if (playerChoice == Choice.PAPER && enemyChoice == Choice.SCISSORS) {
			return "opponent";
		}
		
		else if (playerChoice == Choice.SCISSORS && enemyChoice == Choice.ROCK) {
			return "opponent";
		}
		
		else if (playerChoice == Choice.SCISSORS && enemyChoice == Choice.PAPER) {
			return "player";
		}
		
		return "error";
	}
	
	private Choice getClickedChoice(Point point) {
		for (Choice choice : Choice.ROCK.getChoices()) {
			if (choice.getRectangle().contains(point)) {
				return choice;
			}
		}
		
		return null;
	}
	
	private Choice generateRandomChoice() {
		Random rand = new Random();
		int n = rand.nextInt(3);
		
		return Choice.ROCK.getChoices()[n];
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
