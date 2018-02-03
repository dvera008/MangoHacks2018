package org.memeteam.entity;

import javax.swing.ImageIcon;

import org.memeteam.util.Direction;

public abstract class HostileEntity extends LivingEntity {

	public HostileEntity(int[] stats) {
		super(stats);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageIcon getGraphics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveInDirection(Direction direction) {
		// TODO Auto-generated method stub

	}

}
