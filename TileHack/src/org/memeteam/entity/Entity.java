package org.memeteam.entity;

import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Entity {
	private Point location;

	public abstract ImageIcon getGraphics();

	public Entity(Point location) {
		this.location = location;
	}

	public Point getLocation() {
		return location;
	}

}
