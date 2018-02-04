package org.memeteam.game;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.memeteam.entity.PlayerEntity;
import org.memeteam.tile.Tile;
import org.memeteam.util.Direction;
import org.omg.PortableServer.ServantRetentionPolicyValue;

public class GameInstance {
	private Map<Point, Tile> gameBoard;
	private int[] bounds;
	private Point focusPoint; // stores the location of the focused position on screen
	static PlayerEntity player;
	static JLabel playerIcon;

	public GameInstance() {
		init();
	}

	private void init() {

		gameBoard = new HashMap<Point, Tile>();
		bounds = new int[4];
		bounds[Direction.NORTH.getID()] = 1;
		bounds[Direction.EAST.getID()] = 1;
		int[] tempStats = { 0, 0, 0 };
		player = new PlayerEntity(new Point(0, 0), tempStats, 12);
		new GUI();
		placeTile(new Tile(0, new Point(0, 0)));
		focusPoint = player.getLocation();
		changeFocusPoint(focusPoint);

		GUI.frame.setVisible(true);

		movePlayer(Direction.EAST);

	}

	private void movePlayer(Direction d) {
		Direction.navigate(player.getLocation(), d);
		if (!gameBoard.containsKey(player.getLocation())) {
			placeTile(new Tile((int) (Math.random() * 16), player.getLocation()));
		}

		updateGraphics();
	}

	private void updateGraphics() {
		focusPoint = player.getLocation();
		changeFocusPoint(focusPoint);
		drawPlayer(player);
		GUI.gamepanel.repaint();
	}

	private void placeTile(Tile t) {
		gameBoard.put(t.getLocation(), t);
		drawTile(t);
	}

	private void drawTile(Tile t) {

		// check if expansion is necessary
		if (t.getLocation().getX() + 1 > bounds[Direction.EAST.getID()]
				|| t.getLocation().getX() < bounds[Direction.WEST.getID()]
				|| t.getLocation().getY() + 1 > bounds[Direction.NORTH.getID()]
				|| t.getLocation().getY() < bounds[Direction.SOUTH.getID()]) {
			int[] newbounds = new int[4];
			for (int i = 0; i < bounds.length; i++) {
				newbounds[i] = bounds[i];
			}
			if (t.getLocation().getX() > bounds[Direction.EAST.getID()]) {
				newbounds[Direction.EAST.getID()] = (int) t.getLocation().getX() + 1
						- newbounds[Direction.EAST.getID()];
			}
			if (t.getLocation().getX() < bounds[Direction.WEST.getID()]) {
				newbounds[Direction.WEST.getID()] = (int) t.getLocation().getX() - newbounds[Direction.WEST.getID()];
			}
			if (t.getLocation().getY() > bounds[Direction.NORTH.getID()]) {
				newbounds[Direction.NORTH.getID()] = (int) t.getLocation().getY() + 1
						- newbounds[Direction.NORTH.getID()];
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
		GUI.boardpanel.repaint();
	}

	/**
	 * Draws a playerEntity object to the center of the screen
	 * 
	 * @param p
	 */
	private void drawPlayer(PlayerEntity p) {
		playerIcon = p.getGraphics();
		int playerPosX, playerPosY;
		int xorig, yorig;
		xorig = (int) -GUI.boardpanel.getLocation().getX();
		yorig = (int) -GUI.boardpanel.getLocation().getY();
		playerPosX = (int) (GUI.gamepanelSize.getWidth() - GUI.playerSize.getWidth() / 2) + xorig;
		playerPosY = (int) (GUI.gamepanelSize.getHeight() - GUI.playerSize.getHeight() / 2) + yorig;
		playerIcon.setLocation(playerPosX, playerPosY);
		GUI.boardpanel.setComponentZOrder(playerIcon, 0);
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
			newBoard.setBackground(GUI.boardpanel.getBackground());
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
		GUI.boardpanel = newBoard;
		GUI.gamepanel.add(newBoard);
	}

	/**
	 * Centers the camera on a specific point
	 * 
	 * @param p
	 */
	private void changeFocusPoint(Point p) {
		// Update for focus point
		// find center
		int centerx = (int) (GUI.tileSize.getWidth() * (1 / 2.0 + focusPoint.getX()));
		int centery = (int) (GUI.tileSize.getHeight() * (1 / 2.0 + focusPoint.getY()));
		// use center to calc gamepanel location
		int posx = (GUI.gamepanel.getWidth() / 2) - centerx;
		int posy = (GUI.gamepanel.getHeight() / 2) - centery;
		// update position
		GUI.boardpanel.setLocation(posx, posy);
		GUI.boardpanel.repaint();
	}
}
