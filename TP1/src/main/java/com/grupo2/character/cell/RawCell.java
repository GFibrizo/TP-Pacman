package com.grupo2.character.cell;

/**
 *
 * @author ivan
 */
public interface RawCell extends Cell {

	void setLeftCell(RawCell rc);

	void setRightCell(RawCell rc);

	void setUpperCell(RawCell rc);

	void setLowerCell(RawCell rc);

}
