package com.grupo2.cell;

/**
 *
 * @author ivan
 */
public interface RawCell extends Cell {

	void setLeftCell(RawCell rc);

	void setRightCell(RawCell rc);

	void setUpperCell(RawCell rc);

	void setLowerCell(RawCell rc);
        
        RawCell getLeftCell();
        
        RawCell getRightCell();

        RawCell getUpperCell();
        
        RawCell getLowerCell();        
}