package org.memeteam.tile;

import java.awt.Point;

import javax.swing.ImageIcon;

import org.memeteam.util.Direction;
import org.memeteam.util.Graphics;

public class Tile {
	private int tileID;
	private Point tileLocation;
	private boolean doors[];
	private ImageIcon tileGraphic;

	/**
	 * 
	 * @param id
	 *            SpriteID of the given tile
	 * @param location
	 * @param doors
	 *            The state of each door using DirectionIDs for indexes.
	 */
	public Tile(int id, Point location, boolean[] doors) {
		tileID = id;
		tileLocation = location;
		Graphics.getTileGraphics(id);
	}

	/**
	 * Rotates a Tile clockwise
	 * 
	 * @param i
	 *            Amount of 90 degree rotations
	 */
	public void rotateTile(int amount) {
		amount = amount < 0 ? -(amount % 4) : amount % 4;
		for (int n = 0; n < amount; n++) {
			boolean temp = doors[doors.length - 1];
			for (int i = doors.length - 1; i > 0; i++) {
				doors[i] = doors[i - 1];
			}
			doors[0] = temp;
		}
		tileGraphic = Graphics.rotateGraphics(tileGraphic, amount);
	}

	/**
	 * Checks if a given door is open
	 * 
	 * @param d
	 *            The direction of the door to check
	 * @return
	 */
	public boolean isOpen(Direction d) {
		return doors[d.getID()];
	}

	/**
	 * Sets the state of a door
	 * 
	 * @param d
	 *            Direction of the door to change
	 * @param state
	 *            State to change the door to
	 */
	public void setDoorState(Direction d, boolean state) {
		doors[d.getID()] = state;
	}

	/**
	 * Returns the tilesprite ID of a given tile
	 * 
	 * @return
	 */
	public int getID() {
		return tileID;
	}
/**
 * Returns the location of a given tile
 * @return
 */
	public Point getLocation() {
		return tileLocation;
	}

}
