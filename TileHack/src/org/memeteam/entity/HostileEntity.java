package org.memeteam.entity;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.memeteam.util.Direction;

public abstract class HostileEntity extends LivingEntity {

	public HostileEntity(Point location, int[] stats) {
		super(location, stats);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JLabel getGraphics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveInDirection(Direction direction) {
		// TODO Auto-generated method stub

	}

}
