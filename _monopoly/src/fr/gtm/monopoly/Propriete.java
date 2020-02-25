package fr.gtm.monopoly;

public abstract class Propriete extends Case {
	private int loyer = 500;
	private int prixAchat = 100;
	private Joueur proprio = null;


	public Propriete(String name) {
		super(name);
	}



	@Override
	public void arreter(Pion p) {
		super.arreter(p);
		Joueur j = p.getJoueur();
		if(proprio == null && j.isInterresseParAchat(prixAchat)) {
			j.debiter(prixAchat);
			proprio = j;
			j.add(this);
			System.out.println(String.format("+++ %s achète %s pour %d",j.getNom(),this.getNom(),prixAchat));
			return;
		}
		if(proprio != null && j != proprio) {
			j.debiter(loyer);
			proprio.crediter(loyer);
			System.out.println(String.format(">>> %s verse un loyer à %s pour %d",j.getNom(),proprio.getNom(),loyer));
		}

	}

	public int getLoyer() {
		return loyer;
	}

	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}

	public int getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Joueur getProprio() {
		return proprio;
	}

	public void setProprio(Joueur proprio) {
		this.proprio = proprio;
	}

	public void remettreEnJeu() {
		this.proprio = null;
		
	}

}
