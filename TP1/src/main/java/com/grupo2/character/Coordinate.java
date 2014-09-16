package com.grupo2.character;

import static java.lang.Math.sqrt;

/**
 *
 * @author fibrizo
 */
public class Coordinate {

    float x;
    float y;

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

    public boolean EqualTo(Coordinate other) {
        if (other == null) {
            return false;
        }
        // Should throw exception. Don't know wich type.
        return (this.x == other.x) && (this.y == other.y);
    }

    public float distanceTo(Coordinate otherCoordinate) {
        float distanceX = this.getX() - otherCoordinate.getX();
        float distanceY = this.getY() - otherCoordinate.getY();
        float valuedDistance = distanceX * distanceX + distanceY * distanceY;
        return (float) sqrt(valuedDistance);
    }
}
