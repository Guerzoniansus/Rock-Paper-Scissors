import java.awt.Point;
import java.util.Random;


public class Game {
	
	public static final String GAME_NAME = "Rock Paper Scissors";
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 400;
	public static final int CENTER_X = 200;
	
	public static final String MSG_START = "Click on an option to play";
	
	private GUI gui;
	
	public States state;
	public Choice playerChoice;
	public Choice enemyChoice;
	
	
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
			playerChoice = getClickedChoice(point);
			enemyChoice = generateRandomChoice();
			
			System.out.println("Your choice: " + playerChoice.getChoiceAsString());
			System.out.println("Opponents choice: " + enemyChoice.getChoiceAsString());
			
			System.out.println("The winner is: " + calculateWinner());
		}
		
		else if (state == States.COUNTDOWN) {
			
		}
		
		else if (state == States.RESULTS) {
			
		}
	}
	
	private String calculateWinner() {
		
		if (playerChoice == Choice.ROCK && enemyChoice == Choice.ROCK
				|| playerChoice == Choice.PAPER && enemyChoice == Choice.PAPER
				|| playerChoice == Choice.SCISSORS && enemyChoice == Choice.PAPER) {
			return "Draw";
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
	
}
