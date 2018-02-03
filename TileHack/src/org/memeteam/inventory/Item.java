package org.memeteam.inventory;

public enum Item {
	item1(1), item2(10);

	int durability;
	int maxDurability;
	boolean broken = false;

	/**
	 * Creates an item with a given durability
	 * 
	 * @param durability
	 */
	private Item(int durability) {
		this.durability = durability;
		maxDurability = durability;
	}

	/**
	 * Returns whether the item is broken
	 * 
	 * @return
	 */
	public boolean isBroken() {
		return broken;
	}

	/**
	 * Returns the maximum durability of the given item
	 * 
	 * @return
	 */
	public int getMaxDurability() {
		return maxDurability;
	}

	/**
	 * Returns the durability of the given item
	 * 
	 * @return
	 */
	public int getDurability() {
		return durability;
	}

	/**
	 * Lowers the durability of the given item by an amount
	 * 
	 * @param amt
	 */
	public void lowerDurability(int amt) {
		durability -= amt;
		broken = durability <= 0;
	}

	/**
	 * Lowers durability of the given item by 1
	 */
	public void lowerDurability() {
		durability--;
		broken = durability <= 0;
	}
}
