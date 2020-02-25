package fr.gtm.monopoly;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@Component
public class Joueur {
	private String nom;
	private Pion pion;
	private int solde = 1500;
	private List<Propriete> proprietes = new ArrayList<Propriete>();
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public Joueur(String nom, Pion pion) {
		this.nom = nom;
		this.pion = pion;
	}

	public void add(Propriete propriete) {
		proprietes.add(propriete);
	}
	
	public void removeAllProprietes() {
		for(Propriete p : proprietes) {
			p.remettreEnJeu();
		}
		proprietes.clear();
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Pion getPion() {
		return pion;
	}

	public void setPion(Pion pion) {
		this.pion = pion;
	}

	public void jouer(Gobelet gobelet) {
		gobelet.lancer();
		int r = gobelet.getValeur();
		pion.avancer(r);
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public void crediter(int somme) {
		solde += somme;	
	}

	@Override
	public String toString() {
		return "Joueur [" + nom + ", solde=" + solde + "]";
	}

	public void debiter(int somme) {
		solde -= somme;		
	}

	public boolean isInterresseParAchat(int prixAchat) {
		if(solde<=prixAchat) {
			return false;
		}
		int r = (int) (Math.random()*10);
		return r%2 == 0;
	}

	public List<Propriete> getProprietes() {
		return proprietes;
	}


	
	
}
