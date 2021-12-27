package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.MenuScreen;
import view.TicTacToePanel;

import java.util.Random;

public class ButtonEventListener implements ActionListener {

	private TicTacToePanel panel;
	private JButton buttons[];
	private JLabel textFeild;

	public ButtonEventListener(TicTacToePanel panel) {
		this.panel = panel;
		this.buttons = panel.getButtons();
		this.textFeild = panel.getTextField();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton quitButton = panel.getQuitButton();
		JButton playAgainButton = panel.getPlayAgainButton();
		
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button == quitButton){
			panel.getWindow().getContentPane().removeAll();
            var menu = new MenuScreen(panel.getWindow());
            menu.init();
            panel.getWindow().pack();
            panel.getWindow().revalidate();
		} else if (button == playAgainButton) {
			for (int i = 0; i < buttons.length; i++) {
				buttons[i].setText("");
				buttons[i].setEnabled(true);;
			}
			textFeild.setText("Select Square to play TicTacToe");
			playAgainButton.setEnabled(false);
		} else if (button.getText() == "") {
			playAgainButton.setEnabled(true);
			button.setText("X");
			if (checkXWin()) {
				textFeild.setText("X Wins");
				for (int i = 0; i < buttons.length; i++) {
					buttons[i].setEnabled(false);
				}
			} else {
				makeMove();
				if (checkOWin()) {
					textFeild.setText("O Wins");
					for (int i = 0; i < buttons.length; i++) {
						buttons[i].setEnabled(false);
					}
				}
			}
		}
	}

	boolean checkCat() {
		int count = 0;
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].getText() == "" )
				count++;
		}
		if (count != 0)
			return false;
		else
			return true;
	}

	void makeMove() {
		if (checkCat()) {
			textFeild.setText("Cat's Game");
				for (int i = 0; i < buttons.length; i++) {
					buttons[i].setEnabled(false);
				}
			return;
		}
		Random rand = new Random();
		int randnumb = rand.nextInt(8);
		if (buttons[randnumb].getText() != "") {
			makeMove();
		} else {
			buttons[randnumb].setText("O");
		}
	}

	boolean checkXWin() {
		// top: left to right
		String a = buttons[0].getText() + buttons[1].getText() + buttons[2].getText();

		// middle: left to right
		String b = buttons[3].getText() + buttons[4].getText() + buttons[5].getText();
		
		// bottom: left to right
		String c = buttons[6].getText() + buttons[7].getText() + buttons[8].getText();

		// left: top to bottom
		String d = buttons[0].getText() + buttons[3].getText() + buttons[6].getText();

		// middle: top to bottom
		String e = buttons[1].getText() + buttons[4].getText() + buttons[7].getText();

		// right: top to bottom
		String f = buttons[2].getText() + buttons[5].getText() + buttons[8].getText();

		// left: diaganol
		String g = buttons[0].getText() + buttons[4].getText() + buttons[8].getText();

		// right: diaganol
		String h = buttons[2].getText() + buttons[4].getText() + buttons[6].getText();

		if(a.equals("XXX") || b.equals("XXX") || c.equals("XXX") || d.equals("XXX") || e.equals("XXX") || f.equals("XXX") || g.equals("XXX") || h.equals("XXX")){
			return true;
		} else {
			return false;
		}
	}

	boolean checkOWin() {
		// top: left to right
		String a = buttons[0].getText() + buttons[1].getText() + buttons[2].getText();

		// middle: left to right
		String b = buttons[3].getText() + buttons[4].getText() + buttons[5].getText();
		
		// bottom: left to right
		String c = buttons[6].getText() + buttons[7].getText() + buttons[8].getText();

		// left: top to bottom
		String d = buttons[0].getText() + buttons[3].getText() + buttons[6].getText();

		// middle: top to bottom
		String e = buttons[1].getText() + buttons[4].getText() + buttons[7].getText();

		// right: top to bottom
		String f = buttons[2].getText() + buttons[5].getText() + buttons[8].getText();

		// left: diaganol
		String g = buttons[0].getText() + buttons[4].getText() + buttons[8].getText();

		// right: diaganol
		String h = buttons[2].getText() + buttons[4].getText() + buttons[6].getText();

		if(a.equals("OOO") || b.equals("OOO") || c.equals("OOO") || d.equals("OOO") || e.equals("OOO") || f.equals("OOO") || g.equals("OOO") || h.equals("OOO")){
			return true;
		} else {
			return false;
		}
	}
	
}