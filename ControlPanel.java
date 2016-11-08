import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;

/**
control panel view
*/
public class ControlPanel extends JPanel {
	/**
	create controlpanel view
	*/
	public ControlPanel (MineModel model) {
		super();
		JButton restart = new JButton("Restart");
		JButton reveal = new JButton("Reveal");
		JButton exit = new JButton("Exit");

		restart.addActionListener(e -> model.newGame());
		reveal.addActionListener(e -> model.revealMines());
		exit.addActionListener(e -> System.exit(0));

		JPanel buttons = new JPanel();
		buttons.add(restart);
		buttons.add(reveal);
		buttons.add(exit);

		JRadioButton easy = new JRadioButton("Easy");
		JRadioButton medium = new JRadioButton("Medium");
		JRadioButton hard = new JRadioButton("Hard");

		easy.addActionListener(e -> model.setDifficulty(10));
		medium.addActionListener(e -> model.setDifficulty(15));
		hard.addActionListener(e -> model.setDifficulty(20));
		medium.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);

		JPanel difficulty = new JPanel();
		difficulty.add(easy);
		difficulty.add(medium);
		difficulty.add(hard);


		setLayout(new BorderLayout());
		add(difficulty, BorderLayout.WEST);
		add(buttons, BorderLayout.EAST);
	}
}