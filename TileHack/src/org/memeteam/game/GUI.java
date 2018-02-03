package org.memeteam.game;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.memeteam.tile.Tile;

public class GUI {
	static JFrame frame;
	static JPanel gamepanel;
	static JPanel boardpanel;
	public static final Dimension tileSize = new Dimension(50, 50);
	public static final Dimension frameSize = new Dimension(600, 600);

	public GUI() {
		final Dimension gameSize = new Dimension(500, 500);
		frame = new JFrame("TileHack");
		frame.getContentPane().setPreferredSize(frameSize);
		frame.pack();
		frame.setLayout(null);

		// throw shit in content pane here

		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void drawTile(Tile t, Point Location) {
		// TODO: Draw tile
	}
}
