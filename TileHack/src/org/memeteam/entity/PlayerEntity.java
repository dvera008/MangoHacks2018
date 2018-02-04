package org.memeteam.entity;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.memeteam.entity.LivingEntity;
import org.memeteam.game.GUI;
import org.memeteam.util.Direction;
import org.memeteam.util.Graphics;

public class PlayerEntity extends LivingEntity {
	public static final int STRENGTH = 0;
	public static final int SPEED = 1;
	public static final int ARMOR = 2;
	private JLabel graphics;

	public PlayerEntity(Point location, int[] stats, int graphicsId) {
		super(location, stats);
		// TODO Auto-generated constructor stub
		ImageIcon image = Graphics.getPlayerGraphics(graphicsId);
		graphics = new JLabel(image);
		graphics.setSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
	}

	@Override
	public void moveInDirection(Direction direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public JLabel getGraphics() {
		return graphics;
	}

}
