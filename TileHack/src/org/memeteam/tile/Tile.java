package org.memeteam.tile;

import java.awt.Point;

import javax.swing.ImageIcon;

import org.memeteam.util.Graphics;

public class Tile {
	private int tileId;
	private Point tileLocation;
	private boolean doors[];
	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;
	private ImageIcon tileGraphic;

	/**
	 * 
	 * @param id
	 *            SpriteID of the given tile
	 * @param location
	 * @param doors
	 *            The state of each door in the order [n,e,s,w].
	 */
	public Tile(int id, Point location, boolean[] doors) {
		tileId = id;
		tileLocation = location;
		Graphics.getTileGraphics(id);
	}

}
