package com.grupo2.ghostFactory;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.command.GhostIsCloseToPacmanCommand;
import com.grupo2.directions.RightDirection;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Ghost;
import com.grupo2.ghost.GhostState;
import com.grupo2.ghostState.HunterState;
import com.grupo2.ghostState.Personality;
import com.grupo2.pacman.PacmanArea;
import com.grupo2.personality.OnlyRight;

/**
 *
 * @author fibrizo
 */
public class GhostFactory {

	public static Ghost createGhost(GhostState state, Personality pers,
			Coordinate coord, Direction dir) {
		Ghost newGhost = Ghost.createEmptyGhost();
		newGhost.setState(state);
		newGhost.setPosition(coord);
		newGhost.setPersonality(pers);
		Subscriber sub = new GhostIsCloseToPacmanCommand(newGhost);
		PacmanArea.getInstance().subscribe(PacmanArea.VisionEvent.GHOST_IS_INSIDE, sub);
		return newGhost;
	}

	public static Ghost createOnlyRightGhost() {
		Ghost aGhost = Ghost.createEmptyGhost();
		aGhost.setState(new HunterState());
		aGhost.setPersonality(new OnlyRight());
		aGhost.setDirection(new RightDirection());
		return aGhost;
	}

}
