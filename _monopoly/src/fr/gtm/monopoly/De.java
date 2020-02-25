package fr.gtm.monopoly;

import java.util.Random;

public class De {
	private static Random random = new Random();
	private int valeur;

	public int getValeur() {
		return valeur;
	}
	
	public void lancer() {
		valeur = random.nextInt(6) + 1;
	}
}
