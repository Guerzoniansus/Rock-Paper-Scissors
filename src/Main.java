
public class Main {
	
	static GUI gui;
	static Game game;
	

	public static void main(String[] args) {
		
		game = new Game();
		gui = new GUI();
		
		gui.setupWindow(game.GAME_NAME, game.WINDOW_WIDTH, game.WINDOW_HEIGHT);
		gui.setupGame();
	}

}
