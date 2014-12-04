package com.grupo2.directions;

import com.grupo2.character.Cell;
import com.grupo2.character.Direction;

/**
 *
 * @author mauri
 */
public class DownDirection implements Direction {

    /**
    * The movement of the character.
    * 
    * @param cell the current cell of the character.
     * @return the lower cell of the current one.
    */
    @Override
    public Cell stepForward(Cell cell) {
        return cell.getLowerCell();
    }
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */
    @Override
    public boolean EqualTo(Direction other) {
        return other.isEqualTo(this);
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
        return true;
    }
    /**
    * 
     * @param other a Direction.
     * @return true if both are the same direction.
     */ 
    @Override
    public boolean isEqualTo(NullDirection other) {
        return false;
    }
    /**
     * Returns true if the character can move.
     * @param cell the current cell of the character.
     * @return true if it can move, false otherwise.
     */
    @Override
    public boolean canGoForward(Cell cell) {
        return cell.getLowerCell().isTransitable();
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
        return true;
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
        return "Down";
    }

}
