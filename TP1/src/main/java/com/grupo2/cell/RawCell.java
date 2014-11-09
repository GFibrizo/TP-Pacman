package com.grupo2.cell;

import com.grupo2.view.DrawableNode;

/**
 *
 * @author ivan
 */
public interface RawCell extends Cell, DrawableNode {

    void setLeftCell(RawCell rc);

    void setRightCell(RawCell rc);

    void setUpperCell(RawCell rc);

    void setLowerCell(RawCell rc);

}
