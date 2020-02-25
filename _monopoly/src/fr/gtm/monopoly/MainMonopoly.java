package fr.gtm.monopoly;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class MainMonopoly {

	public static void main(String[] args) {
		
		ApplicationContext ap = new AnnotationConfigApplicationContext(MainMonopoly.class);
		
		Monopoly monopoly = ap.getBean(Monopoly.class) ;
			
		Pion p1 = ap.getBean(Pion.class, "Avion");	//new Pion("avion");
		Pion p2 = ap.getBean(Pion.class, "Bateau");	//new Pion("bateau");
		Pion p3 = ap.getBean(Pion.class, "Chapeau");//new Pion("chapeau");
		
		Joueur j1 = ap.getBean(Joueur.class, "Marie");//new Joueur("Gaston");
		Joueur j2 = ap.getBean(Joueur.class, "Vincent");//new Joueur("Lucien");
		Joueur j3 = ap.getBean(Joueur.class, "Louis");//new Joueur("Max");
		
		j1.setPion(p1);
		j2.setPion(p2);
		j3.setPion(p3);
		
		p1.setJoueur(j1);
		p2.setJoueur(j2);
		p3.setJoueur(j3);
		
		monopoly.add(j1,j2,j3);
		monopoly.demarrer();
		System.out.println();
		System.out.println("Tatataaa - le vainqueur est : "+monopoly.getVainqueur());
	}

}
