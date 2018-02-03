package org.memeteam.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
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
	public static final Dimension gamepanelSize = new Dimension(450, 450);
	public static final Point panelLocation = new Point(150, 0);

	public GUI() {
		final Dimension gameSize = new Dimension(500, 500);
		frame = new JFrame("TileHack");
		frame.getContentPane().setPreferredSize(frameSize);
		frame.pack();
		frame.setLayout(null);

		// throw shit in content pane here
		gamepanel = new JPanel();
		gamepanel.setSize(gamepanelSize);
		gamepanel.setBackground(Color.DARK_GRAY);
		gamepanel.setLocation(panelLocation);
		gamepanel.setLayout(null);
		frame.add(gamepanel);

		boardpanel = new JPanel();
		boardpanel.setLayout(null);
		boardpanel.setSize(0, 0);

		boardpanel.setBackground(Color.BLACK);
		gamepanel.add(boardpanel);

		// Make things visible
		boardpanel.setVisible(true);
		gamepanel.setVisible(true);
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void drawTile(Tile t, Point Location) {
		// TODO: Draw tile
	}
}
