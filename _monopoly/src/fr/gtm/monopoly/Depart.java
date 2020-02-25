package fr.gtm.monopoly;

public class Depart extends Case {
	private int somme = 200;
	
	public Depart() {
		super("DEPART");
	}
	
	public Depart(String nom) {
		super(nom);
	}

	@Override
	public void survoler(Pion p) {
		Joueur j =  p.getJoueur();
		j.crediter(somme);
	}
	
	@Override
	public void arreter(Pion p) {
		Joueur j =  p.getJoueur();
		j.crediter(somme*2);
	}
	

}
