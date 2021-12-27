package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ButtonEventListener;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class TicTacToePanel {
	JFrame window;
    private JButton quitButton = new JButton("Quit");
    private JButton playAgainButton = new JButton("Play Again");
	private JButton[] buttons = new JButton[9];


	private JLabel textField = new JLabel();


	public TicTacToePanel(JFrame window) {
		this.window = window;
	}

	public void init() {
		Container cp = window.getContentPane();
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(500, 100));
		titlePanel.setLayout(new GridLayout(3, 1));
		titlePanel.setBackground(new Color(50, 50, 50));

		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 255));
		textField.setFont(new Font("", Font.BOLD, 25));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Select Square to play TicTacToe");

		playAgainButton.setEnabled(false);

		titlePanel.add(textField);
		titlePanel.add(playAgainButton);
		titlePanel.add(quitButton);
		cp.add(titlePanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));

		ButtonEventListener listener = new ButtonEventListener(this);
		quitButton.addActionListener(listener);
		playAgainButton.addActionListener(listener);
		
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("", Font.BOLD, 120));
			buttons[i].setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(listener);
		}
		cp.add(buttonPanel, BorderLayout.CENTER);
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public JButton getPlayAgainButton() {
		return playAgainButton;
	}

	public JFrame getWindow() {
		return window;
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public JLabel getTextField() {
		return textField;
	}
}


