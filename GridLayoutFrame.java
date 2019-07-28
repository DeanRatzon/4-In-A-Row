
/** This class is the frame layout for the game
 * 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GridLayoutFrame extends JFrame implements ActionListener {

	private JLabel[][] buttons;
	private JPanel[][] buttonspanels;
	private JButton[] press = new JButton[7];
	private JButton[] reset = new JButton[7];
	private final GridLayout gridLayout1;
	int turn;
	ImageIcon black = new ImageIcon("./images/black.png");
	Icon yellow = new ImageIcon("./images/yellow.png");
	Icon purple = new ImageIcon("./images/purple.png");

	/**
	 * Constructs the frame with the grid layout
	 * 
	 */
	public GridLayoutFrame() {
		super("4 in a row");
		gridLayout1 = new GridLayout(8, 7, 1, 1);

		setLayout(gridLayout1);
		buttons = new JLabel[6][7];
		buttonspanels = new JPanel[6][7];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				buttonspanels[i][j] = new JPanel(new BorderLayout());
				add(buttonspanels[i][j]);

				buttons[i][j] = new JLabel(black);
				buttonspanels[i][j].add(buttons[i][j]);
			}
		}

		for (int i = 0; i < 7; i++) {
			press[i] = new JButton("Add");
			press[i].addActionListener(this);
			add(press[i]);
		}

		for (int i = 0; i < 7; i++) {
			if (i == 3) {
				reset[i] = new JButton("Reset");
				reset[i].addActionListener(this);

				add(reset[i]);
			} else {
				reset[i] = new JButton();
				reset[i].setEnabled(false);
				reset[i].addActionListener(this);
				add(reset[i]);

			}
			turn = 0;
		}
	}
	


	/**
	 * This method initializes the board for a new game
	 * 
	 */
	public void initialize() {
		turn = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				buttons[i][j].setIcon(black);

			}
		}
		for (int i = 0; i < 7; i++)
			press[i].setEnabled(true);
	}

	/**
	 * This method checks for a sequence of 4 discs with the same color (
	 * horizontally, vertically and diagonally)
	 * 
	 */
	public void checkWin() {
		int countVert = 1, countHor = 1, countDiag = 1, countDiagX = 1;

		// checks diagonally
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				countDiag = 1;
				if (!(buttons[i][j].getIcon() == black)) {
					int k = i;
					int f = j;
					if (buttons[i][j].getIcon() == (buttons[i + 1][j + 1].getIcon())) {
						while (k + 1 < 6 && f + 1 < 7
								&& buttons[k][f].getIcon().equals(buttons[k + 1][f + 1].getIcon())) {
							countDiag++;
							k++;
							f++;
						}

						if (countDiag >= 4 && buttons[i][j].getIcon().equals(yellow)) {
							JOptionPane.showMessageDialog(null, "Yellow won!");
							int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							if (start == JOptionPane.YES_OPTION)
								initialize();
							else
								System.exit(0);
						}
						if (countDiag >= 4 && buttons[i][j].getIcon().equals(purple)) {
							JOptionPane.showMessageDialog(null, "Purple won!");
							int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							if (start == JOptionPane.YES_OPTION)
								initialize();
							else
								System.exit(0);
						}
					}
				}
			}
		}

		// checks opposite diagonally
		for (int i = 0; i < 5; i++) {
			for (int j = 6; j > 0; j--) {
				countDiagX = 1;
				if (!(buttons[i][j].getIcon() == black)) {
					int k = i;
					int f = j;
					if (buttons[i][j].getIcon().equals(buttons[i + 1][j - 1].getIcon())) {
						while (k < 5 && f > 0 && buttons[k][f].getIcon().equals(buttons[k + 1][f - 1].getIcon())) {
							countDiagX++;
							k++;
							f--;
						}

						if (countDiagX >= 4 && buttons[i][j].getIcon().equals(yellow)) {
							JOptionPane.showMessageDialog(null, "Yellow won!");
							int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							if (start == JOptionPane.YES_OPTION)
								initialize();
							else
								System.exit(0);
						}
						if (countDiagX >= 4 && buttons[i][j].getIcon().equals(purple)) {
							JOptionPane.showMessageDialog(null, "Purple won!");
							int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							if (start == JOptionPane.YES_OPTION)
								initialize();
							else
								System.exit(0);
						}
					}
				}
			}
		}

		// check horizontally
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				countHor = 1;
				if (!buttons[i][j].getIcon().equals(black)) {
					int f = j;
					if (buttons[i][j].getIcon().equals(buttons[i][j + 1].getIcon())) {

						while (f + 1 < 7 && buttons[i][f].getIcon().equals(buttons[i][f + 1].getIcon())) {
							countHor++;
							f++;
						}

						if (countHor >= 4 && buttons[i][j].getIcon().equals(yellow)) {
							JOptionPane.showMessageDialog(null, "Yellow won!");
							int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							if (start == JOptionPane.YES_OPTION)
								initialize();
							else
								System.exit(0);
						}
						if (countHor >= 4 && buttons[i][j].getIcon().equals(purple)) {
							JOptionPane.showMessageDialog(null, "Purple won!");
							int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							if (start == JOptionPane.YES_OPTION)
								initialize();
							else
								System.exit(0);
						}
					}

				}
			}
		}

		// check vertically
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				countVert = 1;
				if (!buttons[i][j].getIcon().equals(black)) {
					int k = i;

					if (buttons[i][j].getIcon().equals(buttons[i + 1][j].getIcon())) {
						while (k + 1 < 6 && buttons[k][j].getIcon().equals(buttons[k + 1][j].getIcon())) {
							countVert++;
							k++;
						}

						if (countVert >= 4 && buttons[i][j].getIcon().equals(yellow)) {
							JOptionPane.showMessageDialog(null, "Yellow won!");
							int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							if (start == JOptionPane.YES_OPTION)
								initialize();
							else
								System.exit(0);
						}
					}

					if (countVert >= 4 && buttons[i][j].getIcon().equals(purple)) {
						JOptionPane.showMessageDialog(null, "Purple won!");
						int start = JOptionPane.showConfirmDialog(null, "Do you want to start again?", "GAME OVER",
								JOptionPane.YES_NO_OPTION);
						if (start == JOptionPane.YES_OPTION)
							initialize();
						else
							System.exit(0);
					}
				}

			}
		}
	}

	/**
	 * This method manages the actions in the game (calls the check win method after
	 * every move)
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (reset[3] == event.getSource()) {
			initialize();
		}

		else {
			for (int j = 0; j < 7; j++) {
				if (press[j] == event.getSource()) {
					int k = 0;

					while (k < 5 && buttons[k + 1][j].getIcon().equals(black))
						k++;

					if (turn % 2 == 0) {
						buttons[k][j].setIcon(yellow);
						buttons[k][j].setDisabledIcon(yellow);

						turn++;
						checkWin();
					} else {
						buttons[k][j].setIcon(purple);
						buttons[k][j].setDisabledIcon(purple);

						turn++;
						checkWin();
					}

					if (!(buttons[0][j].getIcon().equals(black)))
						press[j].setEnabled(false);

				}

			}
		}
	}
}
