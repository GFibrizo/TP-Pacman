package com.grupo2.character;

import static java.lang.Math.sqrt;

/**
 *
 * @author fibrizo
 */
public class Coordinate {

	/**
	 * Coordinate X.
	 */
	private int x;
	/**
	 * Coordinate Y.
	 */
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Determines if two Coordinates are equal or not.
	 *
	 * @param other Coordinate to be compared
	 * @return True if Coordinates are equal, false otherwise
	 */
	public boolean isEqualTo(Coordinate other) {
		if (other == null) {
			return false;
		}
		// Should throw exception. Don't know wich type.
		return (this.x == other.x) && (this.y == other.y);
	}

	/**
	 * Compute the euclidean distance from one Coordinate to another.
	 *
	 * @param otherCoordinate Coordinate to compute distance.
	 * @return distance
	 */
	public int distanceTo(Coordinate otherCoordinate) {
		int distanceX = this.getX() - otherCoordinate.getX();
		int distanceY = this.getY() - otherCoordinate.getY();
		int valuedDistance = distanceX * distanceX + distanceY * distanceY;
		return (int) sqrt(valuedDistance);
	}
}
