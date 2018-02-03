package org.memeteam;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.memeteam.gui.GUI;
import org.memeteam.tile.Tile;

public class Main {
	public static void main(String[] args) {
		Map<Point, Tile> gameboard = new HashMap<Point, Tile>();
		new GUI(gameboard);
		
	}
}
