import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
create jpanel component combining board view and control panel
*/
public class MineComponent extends JPanel {
	public MineComponent(MineSweeper game) {
		MineModel model = new MineModel(game);

		BoardView board = new BoardView(model);
		ControlPanel cp = new ControlPanel(model);

		model.addObserver(board);

		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		add(cp, BorderLayout.SOUTH);	
	}
}