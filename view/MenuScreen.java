package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class MenuScreen {

	private JFrame window;

	public MenuScreen(JFrame window) {
		this.window = window;
	}
	

	public void init() {
		Container cp = window.getContentPane();
		cp.setPreferredSize(new Dimension(500, 500));

		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1,1));
		menuPanel.setPreferredSize(new Dimension(500, 500));
		menuPanel.setBackground(new Color(50, 50, 0));

		JButton ticTacToeButton = new JButton("Play TicTacToe");

		menuPanel.add(ticTacToeButton);

		cp.add(BorderLayout.CENTER, menuPanel);

		ticTacToeButton.addActionListener(event -> {
			window.getContentPane().removeAll();
			var panel = new TicTacToePanel(window);
			panel.init();
			window.pack();
			window.revalidate();
		});
	}
}
