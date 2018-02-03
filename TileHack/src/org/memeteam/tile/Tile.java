package org.memeteam.tile;

import java.awt.Point;

import javax.swing.ImageIcon;

import org.memeteam.util.Direction;
import org.memeteam.util.Graphics;

public class Tile {
	private int tileID; // Valid ids so far include 0-15
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
	public Tile(int id, Point location) {
		tileID = id;
		tileLocation = location;
		tileGraphic = Graphics.getTileGraphics(id);
		doors = initDoors();
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
	 * 
	 * @return
	 */
	public Point getLocation() {
		return tileLocation;
	}

	public ImageIcon getImage() {
		return tileGraphic;
	}

	private boolean[] initDoors() {
		boolean[] out = new boolean[4];
		switch (tileID) {
		case 0:
			out[0] = false;
			out[1] = true;
			out[2] = false;
			out[3] = true;
			break;
		case 1:
			out[0] = true;
			out[1] = true;
			out[2] = true;
			out[3] = true;
			break;
		case 2:
			out[0] = true;
			out[1] = true;
			out[2] = true;
			out[3] = true;
			break;
		case 3:
			out[0] = true;
			out[1] = false;
			out[2] = true;
			out[3] = false;
			break;
		case 4:
			out[0] = true;
			out[1] = true;
			out[2] = true;
			out[3] = true;
			break;
		case 5:
			out[0] = true;
			out[1] = false;
			out[2] = false;
			out[3] = false;
			break;
		case 6:
			out[0] = true;
			out[1] = true;
			out[2] = false;
			out[3] = false;
			break;
		case 7:
			out[0] = true;
			out[1] = false;
			out[2] = true;
			out[3] = false;
			break;
		case 8:
			out[0] = true;
			out[1] = false;
			out[2] = false;
			out[3] = false;
			break;
		case 9:
			out[0] = true;
			out[1] = false;
			out[2] = false;
			out[3] = true;
			break;
		case 10:
			out[0] = false;
			out[1] = true;
			out[2] = true;
			out[3] = false;
			break;
		case 11:
			out[0] = false;
			out[1] = false;
			out[2] = true;
			out[3] = true;
			break;
		case 12:
			out[0] = true;
			out[1] = false;
			out[2] = true;
			out[3] = true;
			break;
		case 13:
			out[0] = true;
			out[1] = false;
			out[2] = false;
			out[3] = false;
			break;
		case 14:
			out[0] = true;
			out[1] = true;
			out[2] = false;
			out[3] = false;
			break;
		case 15:
			out[0] = true;
			out[1] = false;
			out[2] = true;
			out[3] = false;
			break;
		}
		return out;
	}
}
