package com.grupo2.cell;

import com.grupo2.view.DrawableNode;

/**
 *
 * @author ivan
 */
public abstract class RawCell implements Cell, DrawableNode {

    public abstract void setLeftCell(RawCell rc);

    public abstract void setRightCell(RawCell rc);

    public abstract void setUpperCell(RawCell rc);

    public abstract void setLowerCell(RawCell rc);

}
