
public class Main {
	
	public static GUI gui;
	public static Game game;
	

	public static void main(String[] args) {
		
		gui = new GUI();
		game = new Game(gui);
		
		gui.setGame(game);
		game.startGame();
		
		//gui.setupWindow(Game.GAME_NAME, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		//gui.setupGame();
	}

}
