
public class Main {
	
	static GUI gui;
	static Game game;
	

	public static void main(String[] args) {
		
		gui = new GUI();
		game = new Game(gui);
		
		game.startGame();
	}

}
