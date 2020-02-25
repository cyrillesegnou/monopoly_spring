package fr.gtm.monopoly;
//
import static org.junit.Assert.*;

import org.junit.Test;


public class DeTest {
	private int NB = 100_000_000;

	@Test
	public void foo() {
		
	}
	@Test
	public void testLancer() {
		boolean ok = true;
		De de = new De();
		for(int i=0 ; i<NB ;i++) {
			de.lancer();
			int r = de.getValeur();
			if(r<1 || r>6) {
				ok = false;
				break;
			}
		}
		assertTrue(ok);
	}
	
	@Test
	public void distribution() {
		int[] values = new int[6];
		De de = new De();
		for(int i=0 ; i<NB ;i++) {
			de.lancer();
			int r = de.getValeur();
			values[r-1]++;
		}
		for(int v : values) {
			assertEquals(1.0/6.0, v*1.0/NB, 0.0001);
		}
	}

	@Test
	public void testGetValeur() {
		De de = new De();
		de.lancer();
		assertNotEquals(0, de.getValeur());
	}

}
