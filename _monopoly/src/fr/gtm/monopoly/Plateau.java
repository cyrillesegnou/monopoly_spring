package fr.gtm.monopoly;

import org.springframework.stereotype.Component;

@Component
public class Plateau {
	private Case[] cases = new Case[40];
	
	public Plateau() {
		creerCases();
		lierCases();
	}
	
	public Case getCaseDepart() {
		return cases[0];
	}

	/**
	 * positioner la case suivante
	 * la case 0 a pour suivante la case 1
	 * ...
	 * la case 39 a pour suivante la case 0
	 */
	private void lierCases() {
		for(int i=0 ; i<cases.length-1 ; i++) {
			cases[i].setSuivante(cases[i+1]);
		}
		cases[cases.length-1].setSuivante(cases[0]);
		
	}

	/**
	 * méthode chargée de créer les 40 cases, 
	 * le 40 éléments du plateau
	 * les cases sont nommées case 0, case 1, ...
	 */
	private void creerCases() {
		for(int i=0 ; i<cases.length ; i++) {
			Case c = null;
			switch(i) {
			case 0:
				c = new Depart("DEPART");
				break;
			case 4:
				c = new Impot("IMPOTS");
				break;
			case 38:
				c = new TaxeLuxe("TAXE DE LUXE");
				break;
			case 5: case 15: case 20: case 25:
				c = new Gare("Gare "+i);
				break;
			case 12:
				c = new Compagnie("Compagnie d'électricité");
				break;
			case 28:
				c = new Compagnie("Compagnie des eaux");
				break;
			case 1: case 3:
				c = new Terrain("Rue "+i,"Marron");
				break;
			case 6: case 8: case 9:
				c = new Terrain("Rue "+i,"Bleu ciel");
				break;
			case 11: case 13: case 14:
				c = new Terrain("Rue "+i,"Violet");
				break;
			case 16: case 18: case 19:
				c = new Terrain("Rue "+i,"Orange");
				break;
			case 21: case 23: case 24:
				c = new Terrain("Rue "+i,"Rouge");
				break;
			case 26: case 27: case 29:
				c = new Terrain("Rue "+i,"Jaune");
				break;
			case 31: case 32: case 34:
				c = new Terrain("Rue "+i,"Vert");
				break;
			case 37: case 39:
				c = new Terrain("Rue "+i,"Bleu foncé");
				break;
			default:
				c = new Case("Case "+i);
				break;
			}
			cases[i] = c;
		}
	}

}
