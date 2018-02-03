package org.memeteam.entity;

import java.awt.Point;

import javax.swing.ImageIcon;

import org.memeteam.util.Direction;

public abstract class Entity {
	private Point location;

	public abstract ImageIcon getGraphics();

	public Entity(Point location) {
		this.location = location;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point p) {
		location.setLocation(p.getX(), p.getY());
	}

	/**
	 * Changes the location of the entity by translating its reference point
	 * 
	 * @param d
	 *            Direction to move the entity
	 * @param amount
	 *            Amount of spaces to move the entity
	 */
	public void navigate(Direction d, int amount) {
		Direction.navigate(location, d, amount);
	}

	/**
	 * Changes the location of the entity by translating its reference point one
	 * space in a given direction
	 * 
	 * @param d
	 *            Direction to move the entity
	 */
	public void navigate(Direction d) {
		Direction.navigate(location, d);
	}
}
