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
	public static final Dimension tileSize = new Dimension(150, 150);
	public static final Dimension frameSize = new Dimension(625, 625);
	public static final Dimension gamepanelSize = new Dimension(500, 500);
	public static final Point panelLocation = new Point((int) (frameSize.width - gamepanelSize.getWidth()), 0);

	public GUI() {
		final Dimension gameSize = new Dimension(500, 500);
		frame = new JFrame("TileHack");
		frame.getContentPane().setPreferredSize(frameSize);
		frame.pack();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// throw stuff in content pane here
		gamepanel = new JPanel();
		gamepanel.setSize(gamepanelSize);
		gamepanel.setBackground(Color.DARK_GRAY);
		gamepanel.setLocation(panelLocation);
		gamepanel.setLayout(null);
		frame.add(gamepanel);

		boardpanel = new JPanel();
		boardpanel.setLayout(null);
		boardpanel.setSize(tileSize.width, tileSize.height);
		boardpanel.setBackground(Color.DARK_GRAY);
		gamepanel.add(boardpanel);

		// Make things visible
		frame.setVisible(false);
		boardpanel.setVisible(true);
		gamepanel.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}
}
