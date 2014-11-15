package com.grupo2.main;

import com.grupo2.balls.NullBall;
import com.grupo2.character.Coordinate;
import com.grupo2.controller.Controller;
import com.grupo2.controller.KeyBoardReader;
import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicLittleBall;
import com.grupo2.graphicView.GraphicNode;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import com.grupo2.view.DrawableNode;
import com.grupo2.view.GraphicView;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.grupo2.cell.Cell;
import com.grupo2.balls.BigBall;
import com.grupo2.board.Board;
import com.grupo2.graphicView.ViewsFactory;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.board.Board;
import com.grupo2.pacman.Pacman;
import com.grupo2.directions.RightDirection;

/**
 *
 * @author ivan
 */
public class main {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
        MazeBuilder      mBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml"));
        CharacterBuilder cBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml"));
        Board board = Board.createBoard(mBuilder, cBuilder);
        ArrayList<DrawableNode> cells = board.getMaze().getNodes();
        GraphicView view = ViewsFactory.createGraphicView(board);
        view.drawAll();
        board.getMaze().getCellFromCoordinates(new Coordinate(1,1)).setBall(new NullBall());
        view.drawAll();
        int i = 0;
        while (i < 4) {
            Thread.sleep(200);
            board.updateModel(new Controller(() -> new RightDirection()));
            view.update();
            view.drawAll();
        }
    }
}
