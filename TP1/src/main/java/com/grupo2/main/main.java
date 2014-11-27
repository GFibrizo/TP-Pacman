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
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
        TinySound.init();
        Game newGame = new Game(new Controller(new KeyBoardReader()));
        newGame.play();
        TinySound.shutdown();
    }
}
