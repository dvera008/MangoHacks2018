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
	public void navigate(Point p, Direction d) {
		switch (d) {
		case NORTH:
			p.setLocation(p.getX(), p.getY() + 1);
			break;
		case SOUTH:
			p.setLocation(p.getX(), p.getY() - 1);
			break;
		case EAST:
			p.setLocation(p.getX() + 1, p.getY());
			break;
		case WEST:
			p.setLocation(p.getX() - 1, p.getY());
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
	public void navigate(Point p, Direction d, int amount) {
		switch (d) {
		case NORTH:
			p.setLocation(p.getX(), p.getY() + amount);
			break;
		case SOUTH:
			p.setLocation(p.getX(), p.getY() - amount);
			break;
		case EAST:
			p.setLocation(p.getX() + amount, p.getY());
			break;
		case WEST:
			p.setLocation(p.getX() - amount, p.getY());
			break;
		}
	}
}
