package fr.gtm.monopoly;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlateauTest {

	@Test
	public void testPlateau() {
		Plateau p = new Plateau();
		assertNotNull(p);
	}

	@Test
	public void testGetCaseDepart() {
		Plateau p = new Plateau();
		assertNotNull(p.getCaseDepart());
	}
	
	@Test
	public void testCases() {
		Plateau p = new Plateau();
		Case depart = p.getCaseDepart();
		Case c = depart;
		int cpt = 0;
		do {
			c = c.getSuivante();
			cpt++;
		}while(c != depart);
		assertEquals(40,cpt);
	}

}
