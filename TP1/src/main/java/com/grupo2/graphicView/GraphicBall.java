package com.grupo2.graphicView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.grupo2.constants.ViewConstants;
import com.grupo2.balls.*;
import com.grupo2.board.Board;

/**
 *
 * @author fibrizo
 */
public abstract class GraphicBall extends JPanel {

    protected Image image;
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected Ball ball;

    protected void initialize(Ball ball, int x, int y, ImageIcon boardBackground) {
        this.width = ViewConstants.DRAWABLE_WIDTH;
        this.height = ViewConstants.DRAWABLE_HEIGHT;
        this.ball = ball;
        this.x = x;
        this.y = y;
        this.image = boardBackground.getImage();
        setPreferredSize(new Dimension(width, height));
    }

    public void update() {
        ball = (Board.getInstance().getMaze().getCellFromCoordinates(x, y)).getBall();
        if (!ball.isEatable()) {
            this.image = null;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, (this.x * this.width), (this.y * this.height), this.width, this.height, this);
    }
}
