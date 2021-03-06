package org.memeteam.entity;

public enum Modifier {

	FROZEN(4, false), DMG_BOOST(2, true), DMG_REDUCTION(4, true), SLOWED(4, false);

	boolean isPositive;
	int duration;

	private Modifier(int duration, boolean isPositive) {
		this.duration = duration;
		this.isPositive = isPositive;
	}

	public Modifier[] listModifiers() {
		Modifier[] temp = { FROZEN, DMG_BOOST, DMG_REDUCTION, SLOWED };
		return temp;
	}
}
