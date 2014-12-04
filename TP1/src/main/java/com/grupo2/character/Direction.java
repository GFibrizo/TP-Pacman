package com.grupo2.character;

import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.NullDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;

/**
 *
 * @author mauri
 */
public interface Direction {

    /**
     * Returns the Cell which is next in the current Direction.
     *
     * @param cell to compute next
     * @return next Cell in the actual Direction
     */
    Cell stepForward(Cell cell);

    /**
     * Returns other.isEqualTo(this).
     *
     * @param other
     * @return true if equals, false otherwise
     */
    boolean EqualTo(Direction other);

    /**
     *
     * @param other
     * @return true if this is LeftDirection, false otherwise
     */
    boolean isEqualTo(LeftDirection other);

    /**
     *
     * @param other
     * @return true if this is RightDirection, false otherwise
     */
    boolean isEqualTo(RightDirection other);

    /**
     *
     * @param other
     * @return true if this is UpDirection, false otherwise
     */
    boolean isEqualTo(UpDirection other);

    /**
     *
     * @param other
     * @return true if this is DownDirection, false otherwise
     */
    boolean isEqualTo(DownDirection other);

    /**
     *
     * @param other
     * @return true if this is NullDirection, false otherwise
     */
    boolean isEqualTo(NullDirection other);

    /**
     *
     * @param other
     * @return true if this is RightDirection, false otherwise
     */
    boolean isOposedTo(LeftDirection other);

    /**
     *
     * @param other
     * @return true if this is LeftDirection, false otherwise
     */
    boolean isOposedTo(RightDirection other);

    /**
     *
     * @param other
     * @return true if this is DownDirection, false otherwise
     */
    boolean isOposedTo(UpDirection other);

    /**
     *
     * @param other
     * @return true if this is UpDirection, false otherwise
     */
    boolean isOposedTo(DownDirection other);

    /**
     *
     * @param cell
     * @return true if the next cell in the current Direction is transitable, false otherwise
     */
    boolean canGoForward(Cell cell);

}
