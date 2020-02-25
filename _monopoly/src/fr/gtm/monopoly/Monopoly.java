package fr.gtm.monopoly;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Monopoly {
@Autowired	private Plateau plateau = new Plateau();
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	@Autowired private Gobelet gobelet = new Gobelet();
	private Joueur vainqueur;
	
	public void add(Joueur...joueurs) {
		for(Joueur j : joueurs) {
			this.joueurs.add(j);
			j.getPion().setPosition(plateau.getCaseDepart());
		}
	}
	
	public Joueur getVainqueur() {
		return vainqueur;
	}
	
	public void demarrer() {
		System.out.println("Monopoly : lancement du jeu");
		for(int i=0 ; vainqueur==null ; i++) {
			System.out.println("================== Tour "+(i+1));
			for(int k=0 ; k<joueurs.size() ; k++) {
				Joueur j = joueurs.get(k);
				j.jouer(gobelet);
				/* si le solde de j < 0
				 * 		remettre en jeu les propriétés du joueur
				 * 		enlever le joueur de la liste des joueurs
				 * fin si
				 * si il ne reste qu'un seul joueur
				 * 		arrêter le jeu
				 * 		mettre à jour une propriété vainqueur
				 * fin
				 */
				if(j.getSolde()<0) {
					j.removeAllProprietes();
					joueurs.remove(j);
					System.out.println("---- "+j.getNom()+" est éliminé");
				}
				if(joueurs.size()==1) {
					vainqueur = joueurs.get(0);
					break;
				}
			}
		}
	}

}
