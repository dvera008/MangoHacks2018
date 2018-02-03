package org.memeteam.util;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Graphics {
	public static final ImageIcon getTileGraphics(int id) {
		// TODO: implement tilesheet
		return null;
	}

	public static final ImageIcon getSprite(int id) {
		// TODO: implement spritesheet
		return null;
	}

	/**
	 * Rotates an imageicon 90 degrees clockwise a specified number of times
	 * 
	 * @param in
	 *            Input ImageIcon
	 * @param num
	 *            Number of 90 degree clockwise rotations
	 * @return
	 */
	public static final ImageIcon rotateGraphics(ImageIcon in, int num) {
		// TODO: implement rotate
		return null;
	}

	/**
	 * Resizes an image to match the given width and height
	 * 
	 * @param i
	 *            Icon or ImageIcon to resize
	 * @param width
	 * @param height
	 * @return The resized image
	 */
	public Icon resizeImage(Icon i, int width, int height) {
		Image image;
		image = toImage(i).getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return toImageIcon(image);
	}

	private ImageIcon toImageIcon(Image i) {
		return new ImageIcon(i);
	}

	public Image toImage(Icon icon) {
		if (icon instanceof ImageIcon) {
			return ((ImageIcon) icon).getImage();
		} else {
			BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
					BufferedImage.TYPE_INT_RGB);
			icon.paintIcon(null, image.getGraphics(), 0, 0);
			return image;
		}
	}

	/**
	 * Rotates an ImageIcon by a specified amount of degrees
	 * 
	 * @param in
	 *            The image to rotate
	 * @param degrees
	 *            The amount to rotate by
	 * @return The rotated image
	 */
	public ImageIcon rotate(ImageIcon in, double degrees) {
		return toImageIcon(rotate(getBufferedImage(in), degrees));
	}

	/**
	 * Rotates a BufferedImage by a specified amount of degrees
	 * 
	 * @param im
	 *            The image to rotate
	 * @param degrees
	 *            The amount to rotate by
	 * @return The rotated image
	 */
	private static BufferedImage rotate(BufferedImage image, double angle) {
		angle = Math.toRadians(angle);
		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		int w = image.getWidth(), h = image.getHeight();
		int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		g.translate((neww - w) / 2, (newh - h) / 2);
		g.rotate(angle, w / 2, h / 2);
		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

	private BufferedImage getBufferedImage(ImageIcon i) {
		BufferedImage im = new BufferedImage(i.getIconWidth(), i.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = im.createGraphics();
		i.paintIcon(null, g, 0, 0);
		g.dispose();
		return im;
	}
}
