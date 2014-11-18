package com.grupo2.main;

import com.grupo2.controller.Controller;
import com.grupo2.controller.KeyBoardReader;
import com.grupo2.game.Game;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import kuusisto.tinysound.TinySound;
import org.xml.sax.SAXException;

/**
 *
 * @author ivan
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
//		MazeBuilder mBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml"));
//		CharacterBuilder cBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml"));
		/*Board board = Board.createBoard(mBuilder, cBuilder);
         ArrayList<DrawableNode> cells = board.getMaze().getNodes();
         GraphicView view = ViewsFactory.createGraphicView(board);
         view.show();
         board.getMaze().getCellFromCoordinates(new Coordinate(1,1)).setBall(new NullBall());
         view.show();
         int i = 0;
         while (i < 4) {
         Thread.sleep(50);
         board.updateModel(new Controller(() -> new RightDirection()));
         view.update();
         view.show();
         }*/
        TinySound.init();
        Game newGame = new Game(new Controller(new KeyBoardReader()));
        newGame.play();
        TinySound.shutdown();
    }
}
