package fr.gtm.monopoly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Gobelet {
	@Autowired private De de1 = new De();
	@Autowired private De de2 = new De();
	
	public void lancer() {
		de1.lancer();
		de2.lancer();
	}
	
	public int getValeur() {
		return de1.getValeur() + de2.getValeur();
	}
	
	public boolean isSame() {
		return de1.getValeur() == de2.getValeur();
	}
	
}
