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
	private float x;
	/**
	 * Coordinate Y.
	 */
	private float y;

	public Coordinate(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
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
	public float distanceTo(Coordinate otherCoordinate) {
		float distanceX = this.getX() - otherCoordinate.getX();
		float distanceY = this.getY() - otherCoordinate.getY();
		float valuedDistance = distanceX * distanceX + distanceY * distanceY;
		return (float) sqrt(valuedDistance);
	}
}
