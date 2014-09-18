package com.grupo2.character;

/**
 * @author ivan
 */
public class CollidingArea {
	
	/**
	 * Coordinates of the CollidingArea.
	 */
	private final Coordinate coordinates;
	/**
	 * Radius of the CollidingArea.
	 */
	private float radius;

	/**
	 * @param x the coordinate X of the Position
	 * @param y the coordinate Y of the Position
	 * @param radius the radius of the Position.
	 */
	public CollidingArea(float x, float y, float radius) {
		this.coordinates = new Coordinate(x, y);
		this.radius = radius;
	}

	/**
	 * @return the value of the radius.
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Set the radius of the actual position.
	 *
	 * @param radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}

	/**
	 * @param offset is the value in which the X will be displaced
	 * (it can a possitive or a negative value)
	 */
	public void displaceHorizantally(float offset) {
		this.coordinates.setX(this.coordinates.getX() + offset);
	}

	/**
	 * @param offset is the value in which the Y will be displaced
	 * (it can a possitive or a negative value)
	 */
	public void displaceVertically(float offset) {
		this.coordinates.setY(this.coordinates.getY() + offset);
	}

    /**
     * @param offset is the value in which the Y will be displaced (it can a
     * possitive or a negative value)
     */
    public void displaceVertically(float offset) {
        this.coordinates.setY(this.coordinates.getY() + offset);
    }
    
    
    public float obtainCoordinateX() {
        return coordinates.getX();
    }
 
    public float obtainCoordinateY() {
        return coordinates.getY();
    }
    
    

	/**
	 * Determines if two collidingAreas are equal or not.
	 *
	 * @param otherPosition is a CollidingArea
	 * @return true if are equals, false otherwise
	 */
	public boolean isEqualTo(final CollidingArea otherPosition) {
		return this.coordinates.isEqualTo(otherPosition.coordinates);
	}
}
