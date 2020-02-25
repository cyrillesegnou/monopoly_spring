package fr.gtm.monopoly;

import org.springframework.stereotype.Component;

@Component
public class Pion {
	private String nom;
	private Joueur joueur;
	private Case position;
	
	public Pion(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public Case getPosition() {
		return position;
	}


	public void setPosition(Case position) {
		this.position = position;
	}

	public void avancer(int r) {
		for(int i=0 ; i<r-1 ; i++) {
			position = position.getSuivante();
			position.survoler(this);
		}
		position = position.getSuivante();
		position.arreter(this);
	}



}
