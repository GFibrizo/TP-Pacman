package com.grupo2.graphicView;

import com.grupo2.board.Board;
import com.grupo2.controller.Controller;
import com.grupo2.fruit.Fruit;
import com.grupo2.ghost.Ghost;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.GraphicView;
import com.grupo2.view.ObjectView;
import java.awt.event.KeyListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.PopupMenu;

/**
 *
 * @author fibrizo
 */
public class ViewsFactory {

    private static JFrame frame = new JFrame("Pacman Game");
    
    public static void createStartGame() throws InterruptedException {
        frame.add(new GameStartView());
        frame.pack();
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
        Thread.sleep(3000);
        //frame.setVisible(false);
        frame.getContentPane().removeAll();
    }

    public static GraphicView createGraphicView(Board board, Controller controller) {
        List<Ghost> ghosts = board.getGhosts();
        Pacman pacman = Pacman.getPacman();
        Fruit fruit = board.getTheFruit();

        List<ObjectView> objectViews = new ArrayList<>();

        for (Ghost ghost : ghosts) {
            objectViews.add(new GhostView(ghost));
        }
        objectViews.add(new PacmanView(pacman));
        objectViews.add(new FruitView(fruit));

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();

        GraphicView theView = GraphicView.createGraphicView(board.getMaze(), frame);
        theView.addObjectViews(objectViews);
        theView.setKeyListener((KeyListener) controller.getReader());
        theView.initialize();
        return theView;
    }

    private ViewsFactory() {
    }

}
