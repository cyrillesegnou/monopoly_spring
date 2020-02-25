package fr.gtm.monopoly;

public class Terrain extends Propriete {
	private String couleur;
	
	public Terrain(String name) {
		super(name);
	}

	public Terrain(String nom, String couleur) {
		super(nom);
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	

}
