package fr.gtm.monopoly;

public class Impot extends Case {
	private int somme = 500;
	
	public Impot() {
		super("Impôt");
	}
	
	public Impot(String nom) {
		super(nom);
	}

	@Override
	public void arreter(Pion p) {
		super.arreter(p);
		Joueur j =  p.getJoueur();
		int debit = j.getSolde()/10;
		debit = debit>somme ? somme : debit;
		j.debiter(debit);
	}
	

}
