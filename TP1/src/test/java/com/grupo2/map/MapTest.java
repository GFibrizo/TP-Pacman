package com.grupo2.map;

import com.grupo2.directions.DownDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.ICharacter;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class MapTest {

	public MapTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of collisionBetween method, of class Map.
	 */
	@Test
	public void testCollisionBetween() {
		ICharacter aCharacter = new Ghost(0, 0, new DownDirection());
		ICharacter anotherCharacter = new Ghost(0, 0, new DownDirection());
		Map instance = Map.getInstance();
		boolean expResult = true;
		boolean result = instance.collisionBetween(aCharacter, anotherCharacter);
		assertEquals(expResult, result);
	}

}
