package org.memeteam.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame("TileHack");
		frame.getContentPane().setPreferredSize(new Dimension(600, 600));
		frame.setLayout(null);
		
		frame.pack();
		frame.setVisible(true);
	}
}
