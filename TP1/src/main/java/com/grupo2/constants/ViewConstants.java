package com.grupo2.constants;

import java.nio.file.Paths;

/**
 *
 * @author
 */
public class ViewConstants {

	public static int DRAWABLE_HEIGHT = 30;
	public static int DRAWABLE_WIDTH = 30;
	public final static String HUNTER_LEFT = Paths.get("src", "main", "graphicResources", "hunterLeft.png").toString();
	public final static String HUNTER_RIGHT = Paths.get("src", "main", "graphicResources", "hunterRight.png").toString();
	public final static String PREY_LEFT = Paths.get("src", "main", "graphicResources", "PreyLeft.png").toString();
	public final static String PREY_RIGHT = Paths.get("src", "main", "graphicResources", "preyRight.png").toString();

	public final static String PACMAN_LEFT = Paths.get("src", "main", "graphicResources", "PacmanLeft.png").toString();
	public final static String PACMAN_RIGHT = Paths.get("src", "main", "graphicResources", "PacmanRight.png").toString();
	public final static String PACMAN_DOWN = Paths.get("src", "main", "graphicResources", "PacmanDown.png").toString();
	public final static String PACMAN_UP = Paths.get("src", "main", "graphicResources", "PacmanUp.png").toString();

	public static void setDrawableHeight(int height) {
		ViewConstants.DRAWABLE_HEIGHT = height;
	}

	public static void setDrawableWidth(int width) {
		ViewConstants.DRAWABLE_WIDTH = width;
	}

	private ViewConstants() {
		//this prevents even the native class from
		//calling this ctor as well :
		throw new AssertionError();
	}

}
