import javax.swing.JPanel;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;
import java.awt.GridLayout;

/**
Controls the view of the board
*/
public class BoardView extends JPanel implements Observer {
	private MineModel model;
	private JButton[][] cell;
	private int size;

	/**
	create view for specified mine model
	@param model the minemodel to create this view for
	*/
	public BoardView(MineModel model) {
		super();

		this.model = model;
		this.size = model.getSize();
		cell = new JButton[size][size];

		setLayout(new GridLayout(size, size));

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cell[i][j] = new JButton(" ");
				final int x = i; final int y = j;
				cell[i][j].addActionListener(e->model.turn(x, y));
				add(cell[i][j]);
			}
		}
	}

	/**
	called when any Observable objects this view is observing updates
	*/
	public void update(Observable obs, Object obj) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(model.isGameOver()) {
					cell[i][j].setEnabled(false);
					if(model.get(i, j) == -1) {
						cell[i][j].setText("X");
						cell[i][j].setOpaque(false);
					}
				} else if(model.get(i, j) == -2) {
					cell[i][j].setText(" ");
					cell[i][j].setEnabled(true);
				} else {
					cell[i][j].setText(Integer.toString(model.get(i, j)));
					cell[i][j].setEnabled(false);
				};
			}
		}
		repaint();
	}
}