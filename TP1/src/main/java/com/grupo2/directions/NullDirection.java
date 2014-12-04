package com.grupo2.directions;

import com.grupo2.character.Cell;
import com.grupo2.character.Direction;

/**
 *
 * @author mauri
 */
public class NullDirection implements Direction {
 
    @Override
    public boolean canGoForward(Cell cell) {
        return false;
    }

    /**
    * The movement of the character.
    * 
    * @param cell the current cell of the character.
     * @return cell the same cell as the current.
    */
    @Override
    public Cell stepForward(Cell cell) {
        return cell;
    }
    
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */
    @Override
    public boolean isEqualTo(LeftDirection other) {
        return false;
    }
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */
    @Override
    public boolean isEqualTo(RightDirection other) {
        return false;
    }
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */
    @Override
    public boolean isEqualTo(UpDirection other) {
        return false;
    }
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */
    @Override
    public boolean isEqualTo(DownDirection other) {
        return false;
    }
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */
    @Override
    public boolean EqualTo(Direction other) {
        return false;
    }
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */
    @Override
    public boolean isEqualTo(NullDirection other) {
        return true;
    }
    /**
     *  The opposite direction of another one.
     * @param other a direction to compare with.
     * @return true if the directions are opposite, false otherwise.
     */
    @Override
    public boolean isOposedTo(LeftDirection other) {
        return false;
    }
    /**
     *  The opposite direction of another one.
     * @param other a direction to compare with.
     * @return true if the directions are opposite, false otherwise.
     */
    @Override
    public boolean isOposedTo(RightDirection other) {
        return false;
    }
    /**
     *  The opposite direction of another one.
     * @param other a direction to compare with.
     * @return true if the directions are opposite, false otherwise.
     */
    @Override
    public boolean isOposedTo(UpDirection other) {
        return false;
    }
    /**
     *  The opposite direction of another one.
     * @param other a direction to compare with.
     * @return true if the directions are opposite, false otherwise.
     */
    @Override
    public boolean isOposedTo(DownDirection other) {
        return false;
    }
    /**
     * The string name of the class.
     * @return the string.
     */
    @Override
    public String toString() {
        return "none";
    }
}
