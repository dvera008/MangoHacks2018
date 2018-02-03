package org.memeteam.entity;

import java.util.HashMap;
import java.util.LinkedList;

import org.memeteam.inventory.Item;
import org.memeteam.util.Direction;

public abstract class LivingEntity implements Entity {
	int health;
	LinkedList<Item> inventory;
	LinkedList<Modifier> modifiers;
	int[] stats;
	boolean isAlive;

	public LivingEntity(int[] stats) {
		inventory = new LinkedList<Item>();
		modifiers = new LinkedList<Modifier>();
		isAlive = true;
	}

	public int[] getStats() {
		return stats;
	}

	/**
	 * Damages Entity by a given amount
	 * 
	 * @param amt
	 *            Amount to damage health by
	 */
	public void damageHealth(int amt) {
		health -= amt;
		isAlive = health > 0;
	}

	public boolean isAlive() {
		return isAlive;
	}
	public abstract void moveInDirection(Direction direction);
}
