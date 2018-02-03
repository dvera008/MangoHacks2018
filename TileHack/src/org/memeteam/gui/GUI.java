package org.memeteam.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import javax.swing.JFrame;

import org.memeteam.tile.Tile;

public class GUI {
	public GUI(Map<Point, Tile> gameboard) {
		JFrame frame = new JFrame("TileHack");
		frame.getContentPane().setPreferredSize(new Dimension(600, 600));
		frame.pack();
		frame.setLayout(null);
		
		//throw shit in content pane here
		
		
		frame.setVisible(true);
	}
}
