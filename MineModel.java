import java.util.Observable;

/**
model for the minesweeper game
*/
public class MineModel extends Observable {
	private MineSweeper game;

	/**
	create model for specified game
	@param game the specified minesweeper game object
	*/
	public MineModel(MineSweeper game) {
		super();
		this.game = game;
	}

	/**
	returns integer for specified coordinate
	@return the value of square, either how many bombs surround it or if its undiscovered or is a bomb
	*/
	public int get(int i, int j) {
		return game.get(i, j);
	}

	/**
	compute a new game
	*/
	public void newGame() {
		game.newGame();
		setChanged();
		notifyObservers();
	}

	/**
	reveals all mines on board
	*/
	public void revealMines() {
		game.revealMines();
		setChanged();
		notifyObservers();
	}

	/**
	is the game over?
	@return boolean value for if game is over
	*/
	public boolean isGameOver() {
		return game.isGameOver();	
	}

	/**
	return size of board
	@return size
	*/
	public int getSize() {
		return game.getSize();
	}

	/**
	take turn, called when square clicked on
	*/
	public void turn(int i, int j) {
		game.turn(i, j);
		setChanged();
		notifyObservers();
	}

	/**
	sets number of mines in game and restarts game
	@param i number of MineSweeper
	*/
	public void setDifficulty(int i) {
		game.setDifficulty(i);
		setChanged();
		notifyObservers();
	}
}