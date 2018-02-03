package org.memeteam.game;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.memeteam.tile.Tile;
import org.memeteam.util.Direction;
import org.omg.PortableServer.ServantRetentionPolicyValue;

public class GameInstance {
	private Map<Point, Tile> gameBoard;
	private int[] bounds;
	private Point focusPoint; // stores the location of the focused position on screen

	public GameInstance() {
		init();
	}

	private void init() {
		gameBoard = new HashMap<Point, Tile>();
		bounds = new int[4];
		new GUI();
	}

	private void drawTile(Tile t) {

		// check if expansion is necessary
		if (t.getLocation().getX() > bounds[Direction.EAST.getID()]
				|| t.getLocation().getX() < bounds[Direction.WEST.getID()]
				|| t.getLocation().getY() > bounds[Direction.NORTH.getID()]
				|| t.getLocation().getY() < bounds[Direction.SOUTH.getID()]) {
			int[] newbounds = new int[4];
			for (int i = 0; i < bounds.length; i++) {
				newbounds[i] = bounds[i];
			}
			if (t.getLocation().getX() > bounds[Direction.EAST.getID()]) {
				newbounds[Direction.EAST.getID()] = (int) t.getLocation().getX() - newbounds[Direction.EAST.getID()];
			}
			if (t.getLocation().getX() < bounds[Direction.WEST.getID()]) {
				newbounds[Direction.WEST.getID()] = (int) t.getLocation().getX() - newbounds[Direction.WEST.getID()];
			}
			if (t.getLocation().getY() > bounds[Direction.NORTH.getID()]) {
				newbounds[Direction.NORTH.getID()] = (int) t.getLocation().getY() - newbounds[Direction.NORTH.getID()];
			}
			if (t.getLocation().getY() < bounds[Direction.SOUTH.getID()]) {
				newbounds[Direction.SOUTH.getID()] = (int) t.getLocation().getY() - newbounds[Direction.SOUTH.getID()];
			}
			expandBounds(newbounds);
		}

		// draw tile
		JLabel tile = new JLabel(t.getImage());
		tile.setLocation(
				// origin = bounds[-left], bounds[-down]
				(int) (GUI.tileSize.getWidth() * (t.getLocation().getX()) - bounds[Direction.WEST.getID()]),
				(int) (GUI.tileSize.getHeight() * (t.getLocation().getY() - bounds[Direction.SOUTH.getID()])));
		tile.setSize(new Dimension(t.getImage().getIconHeight(), t.getImage().getIconWidth()));
		tile.setVisible(true);
		GUI.boardpanel.add(tile);
	}

	/**
	 * Expand each direction by the given amount
	 * 
	 * @param amt
	 */
	private void expandBounds(int[] amt) {
		// calculate new bounds
		bounds[Direction.EAST.getID()] += amt[Direction.EAST.getID()];
		bounds[Direction.NORTH.getID()] += amt[Direction.NORTH.getID()];
		bounds[Direction.WEST.getID()] -= amt[Direction.WEST.getID()];
		bounds[Direction.SOUTH.getID()] -= amt[Direction.SOUTH.getID()];

		// Create new gameboard
		JPanel newBoard = new JPanel();
		newBoard.setLayout(null);
		int width = bounds[Direction.EAST.getID()] - bounds[Direction.WEST.getID()];
		int height = bounds[Direction.NORTH.getID()] - bounds[Direction.SOUTH.getID()];
		newBoard.setSize(
				new Dimension((int) (width * GUI.tileSize.getWidth()), (int) (height * GUI.tileSize.getHeight())));

		// Populate the new board
		for (Map.Entry<Point, Tile> tileEntry : gameBoard.entrySet()) {
			Tile t = tileEntry.getValue();
			JLabel tile = new JLabel(t.getImage());
			tile.setLocation(
					// origin = bounds[-left], bounds[-down]
					(int) (GUI.tileSize.getWidth() * (t.getLocation().getX()) - bounds[Direction.WEST.getID()]),
					(int) (GUI.tileSize.getHeight() * (t.getLocation().getY() - bounds[Direction.SOUTH.getID()])));
			tile.setSize(new Dimension(t.getImage().getIconHeight(), t.getImage().getIconWidth()));
			tile.setVisible(true);
			newBoard.add(tile);
		}

		// Update for focus point
		// find center
		int centerx = (int) (GUI.tileSize.getWidth() * (1 / 2.0 + focusPoint.getX()));
		int centery = (int) (GUI.tileSize.getHeight() * (1 / 2.0 + focusPoint.getY()));
		// use center to calc gamepanel location
		int posx = (GUI.gamepanel.getWidth() / 2) - centerx;
		int posy = (GUI.gamepanel.getHeight() / 2) - centery;
		// update position
		newBoard.setLocation(posx, posy);

		// Destroy old board
		GUI.gamepanel.remove(GUI.boardpanel);

		// Add new board
		newBoard.setVisible(true);
		GUI.boardpanel=newBoard;
		GUI.gamepanel.add(newBoard);

	}
}
