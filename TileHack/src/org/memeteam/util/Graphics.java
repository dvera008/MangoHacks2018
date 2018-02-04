package org.memeteam.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.memeteam.game.GUI;

public final class Graphics {
	/**
	 * Retrieves graphics for the using id number
	 * 
	 * @param id
	 * @return ImageIcon of tile
	 */
	public static final ImageIcon getTileGraphics(int id) {
		ImageIcon icon = getImg("" + id, "png", "src/org/memeteam/resources/tile");
		return resizeImage(icon, icon.getIconWidth(), icon.getIconHeight());

	}/**
	 * Retrieves graphics for the using id number
	 * 
	 * @param id
	 * @return ImageIcon of player
	 */
	public static final ImageIcon getPlayerGraphics(int id) {
		ImageIcon icon = getImg("" + id, "jpg", "src/org/memeteam/resources/entity/player");
		return resizeImage(icon, icon.getIconWidth(), icon.getIconHeight());

	}

	public static final ImageIcon getSprite(int id) {
		// TODO: implement spritesheet
		return null;
	}

	/**
	 * Gets an ImageIcon from a resource within the project
	 * 
	 * @param filename
	 *            name of the file ex: 15
	 * @param imagetype
	 *            extension of the file ex: png
	 * @param pathname
	 *            path to the resource without the leading '/' ex:
	 *            org/memeteam/resources/tile
	 * @return
	 */
	public static final ImageIcon getImg(String filename, String imagetype, String pathname) {

		String path = System.getProperty("user.dir") + "\\" + pathname + "\\" + filename + "."
				+ imagetype.toLowerCase();

		for (int i = 0; i < path.length(); i++) {
			if (path.substring(i, i + 1).equals("/"))
				path = path.substring(0, i) + "\\" + path.substring(i + 1);
		}
		File file = new File(path);
		try {
			System.out.println(path);
			URL url = file.toURL();
			System.out.println(url);
			return new ImageIcon(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public static final ImageIcon resizeImage(Icon i, int width, int height) {
		Image image;
		image = toImage(i).getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return toImageIcon(image);
	}

	private static final ImageIcon toImageIcon(Image i) {
		return new ImageIcon(i);
	}

	public static final Image toImage(Icon icon) {
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
	public static final ImageIcon rotate(ImageIcon in, double degrees) {
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
	private static final BufferedImage rotate(BufferedImage image, double angle) {
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

	private static final BufferedImage getBufferedImage(ImageIcon i) {
		BufferedImage im = new BufferedImage(i.getIconWidth(), i.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = im.createGraphics();
		i.paintIcon(null, g, 0, 0);
		g.dispose();
		return im;
	}

	/**
	 * Tints a BufferedImage with a specified RBG value
	 * 
	 * @param img
	 *            Image to be tinted
	 * @param r
	 *            RED value
	 * @param g
	 *            GREEN value
	 * @param b
	 *            BLUE value
	 * @return Tinted BufferedImage
	 */
	public static final BufferedImage tintImage(BufferedImage img, int r, int g, int b) {

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {

				Color color = new Color(img.getRGB(x, y));
				int rgb;
				if (color.getRed() + r > 255) {
					rgb = 255;
				} else {
					rgb = color.getRed() + r;
				}
				if (color.getGreen() + g > 255) {
					rgb = (rgb << 8) + 255;
				} else {
					rgb = (rgb << 8) + color.getGreen() + g;
				}
				if (color.getBlue() + b > 255) {
					rgb = (rgb << 8) + 255;
				} else {
					rgb = (rgb << 8) + color.getBlue() + b;
				}
				Color newColor = new Color(rgb);
				img.setRGB(x, y, newColor.getRGB());
			}
		}
		return img;
	}
}
