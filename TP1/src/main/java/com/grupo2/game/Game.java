package com.grupo2.game;

import com.grupo2.controller.Controller;
import com.grupo2.constants.Constants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author mauri
 */
public class Game {

	private Controller controller;
	private Level actualLevel;
	private int levelIndex;
	private int qtyLevels;

	public Game(Controller controller) {
		this.controller = controller;
		this.levelIndex = 0;
		this.qtyLevels = 0;
		try {
			Files.walk(Paths.get("src", "main", "resources", "Levels")).forEachOrdered(levelFile -> {
				if (levelFile.toString().matches(".*MazeLevel[0-9]+.xml")) {
					this.qtyLevels++;
				}
			});
		} catch (IOException ex) {
			Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
                Constants.initializeConstants(Paths.get("src", "main", "resources", "Constants.json"));
	}

	private void startLevel() throws ParserConfigurationException {
		this.actualLevel = getNextLevel();
		this.levelIndex = (this.levelIndex + 1) % this.qtyLevels;
	}

	private Level getNextLevel() throws ParserConfigurationException {
		Path mazePath = Paths.get("src", "main", "resources", "Levels", "MazeLevel" + String.valueOf(this.levelIndex) + ".xml");
		Path characterPath = Paths.get("src", "main", "resources", "Levels", "CharactersLevel" + String.valueOf(this.levelIndex) + ".xml");
		return new Level(mazePath, characterPath, controller);
	}

	public void play() {
		boolean keepPlaying = true;
		int totalScore = 0;
		try {
			this.startLevel();
		} catch (ParserConfigurationException ex) {
			keepPlaying = false;
		}
		while (keepPlaying) {
			int score = this.actualLevel.play();
			//if (!showContinueToNextLevel(score)) break;
			try {
				Thread.sleep(100);
				this.startLevel();
			} catch (Exception ex) {
				keepPlaying = false;
			}
			totalScore += score;
		}
		//showEndGame(totalScore);
	}

}
