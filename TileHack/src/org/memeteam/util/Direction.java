package org.memeteam.util;

import java.awt.Point;

public enum Direction {
	NORTH(0), EAST(1), SOUTH(2), WEST(3);
	private int directionID;

	private Direction(int id) {
		directionID = id;
	}

	/**
	 * Gets the numerical representation of the direction for indexing purposes
	 * @return
	 */
	public int getID() {
		return directionID;
	}

	/**
	 * Moves a given point one space in a given direction
	 * 
	 * @param p
	 *            The point to move
	 * @param d
	 *            The direction to move in
	 */
	public static final void navigate(Point p, Direction d) {
		switch (d) {
		case NORTH:
			p.translate(0, 1);
			break;
		case SOUTH:
			p.translate(0, -1);
			break;
		case EAST:
			p.translate(1, 0);
			break;
		case WEST:
			p.translate(-1, 0);
			break;
		}
	}

	/**
	 * Moves a given point a number of spaces in a given direction
	 * 
	 * @param p
	 *            The point to move
	 * @param d
	 *            The direction to move in
	 * @param amount
	 *            The number of spaces to move
	 */
	public static final void navigate(Point p, Direction d, int amount) {
		switch (d) {
		case NORTH:
			p.translate(0, 1);
			break;
		case SOUTH:
			p.translate(0, -1);
			break;
		case EAST:
			p.translate(1, 0);
			break;
		case WEST:
			p.translate(-1, 0);
			break;
		}
	}
}
