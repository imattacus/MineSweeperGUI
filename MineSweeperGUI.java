import javax.swing.JFrame;

public class MineSweeperGUI {
	public static void main (String[] args) {
		MineSweeper game = new MineSweeper(15);
		MineComponent comp = new MineComponent(game);

		JFrame frame = new JFrame("MineSweeper");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(comp);
		frame.setVisible(true);
	}
}