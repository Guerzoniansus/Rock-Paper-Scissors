
public class Game {
	
	public static final String GAME_NAME = "Rock Paper Scissors";
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 400;
	public static final int CENTER_X = (Game.WINDOW_WIDTH / 2) - (Choice.IMG_WIDTH / 2);
	
	public static final String MSG_START = "Click on an option to play";
	
	private GUI gui;
	
	public Game(GUI gui) {
		this.gui = gui;
	}
	
	public void init() {
		
	}

	public void startGame() {
		init();
		gui.setupWindow(Game.GAME_NAME, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		gui.setupGame();
	}
	
}
