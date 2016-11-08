import java.util.Random;
/**
Create minesweeper game
*/
public class MineSweeper {
	private Integer[][] board;
	private Boolean[][] minemap;
	private int size;
	private int mines;
	private Random rand;
	private Boolean gameOver;

	public static final int MINE = -1;
	public static final int UNDISCOVERED = -2;

	/**
	create the minesweeper game of specified difficulty
	@param difficulty the number of bombs
	*/
	public MineSweeper(int difficulty) {
		rand = new Random();
		this.size = 10;
		setDifficulty(difficulty);
	}

	/**
	compute a new game
	*/
	public void newGame() {
		System.out.println("New Game with:" + this.mines + " mines");
		gameOver = false;

		board = new Integer[size][size];
		minemap = new Boolean[size][size];

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				board[i][j] = UNDISCOVERED;
				minemap[i][j] = false;
			}
		}

		for(int i = 0; i < mines; i++) {
			int x = rand.nextInt(size);
			int y = rand.nextInt(size);

			if(minemap[x][y] == true) {
				i = i - 1;
			} else {
				minemap[x][y] = true;
			}
		}
	}

	/**
	is the game over?
	@return boolean value for if game is over
	*/
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	returns integer for specified coordinate
	@return the value of square, either how many bombs surround it or if its undiscovered or is a bomb
	*/
	public int get(int i, int j) {
		return board[i][j];
	}

	/**
	return size of board
	@return size
	*/
	public int getSize() {
		return size;
	}

	/**
	take turn, called when square clicked on
	*/
	public void turn(int i, int j) {
		if(!gameOver) {
			if(minemap[i][j]) {
				gameOver = true;
				board[i][j] = MINE;
				revealMines();
			} else {
				board[i][j] = getNumMines(i, j);			
			}
		}
	}

	/**
	reveals all mines on board
	*/
	public void revealMines() {
		gameOver = true;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(minemap[i][j]) {
					board[i][j] = MINE;
				}
			}
		}
	}

	/**
	gets number of mines around a point
	@param i the coordinate
	@param j coordinate
	@return integer number of mines surrounding point
	*/
	private int getNumMines(int i, int j) {
		int count = 0;

		for(int m = -1; m < 2; m++) {
			for(int g = -1; g < 2; g++) {
				try {
					if(minemap[i+m][j+g]) count++;
				} catch (Exception e) {
					System.out.println("caught exception");
				}
			}
		}

		return count;
	}

	/**
	sets number of mines in game and restarts game
	@param i number of MineSweeper
	*/
	public void setDifficulty(int i) {
		this.mines = i;
		newGame();
	}

}