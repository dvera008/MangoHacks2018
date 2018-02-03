package org.memeteam.util;

public enum Direction {
	NORTH(0), EAST(1), SOUTH(2), WEST(3);
	private int directionID;

	private Direction(int id) {
		directionID = id;
	}

	public int getID() {
		return directionID;
	}
}
