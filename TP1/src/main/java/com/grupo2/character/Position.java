package com.grupo2.character;

/**
 *
 * @author ivan
 */
public class Position {
    private Coordinate coordinates;
    private float radius;

    public Position(int x, int y, float radio) {
        this.coordinates = new Coordinate(x,y);
        this.radius = radio;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
    
    /**
     * 
     * @param offset is the value in which the X will be displaced (it can a possitive or a negative value)
     */
    public void displaceX(float offset){
        this.coordinates.setX(this.coordinates.getX() + offset);
    }
    
    /**
     * 
     * @param offset is the value in which the Y will be displaced (it can a possitive or a negative value)
     */
    public void displaceY(float offset){
        this.coordinates.setY(this.coordinates.getY() + offset);
    }
    
    public boolean isCollindingWith(Position otherPosition){
        float distance = this.coordinates.distanceTo(otherPosition.coordinates);
        float radiusSum = this.radius + otherPosition.radius;
        //If distance² is greater than the sum of the radius of each circle squared
        //then the circles do not intersect.
        return distance*distance <= radiusSum*radiusSum;
    }
}
