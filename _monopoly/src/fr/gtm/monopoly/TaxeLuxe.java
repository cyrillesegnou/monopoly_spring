package fr.gtm.monopoly;

public class TaxeLuxe extends Case {
	private int somme = 350;
	
	public TaxeLuxe() {
		super("Taxe de luxe");
	}

	public TaxeLuxe(String nom) {
		super(nom);
	}

	@Override
	public void arreter(Pion p) {
		super.arreter(p);
		Joueur j =  p.getJoueur();
		j.debiter(somme);
	}
	

}
