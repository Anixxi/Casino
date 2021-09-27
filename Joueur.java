import java.util.LinkedList;
import java.util.Scanner;

public class Joueur {
	int BlackJack = 21;
	
	LinkedList<Carte> main ;
	
	// si "AS" demander valeur
	public void piocher(Deck d) {
		try {
			if(d.getDeck().peek().getValeur() == 1 ) {
				Carte c = d.getDeck().removeFirst();
				DemanderValeur();
				main.add(c);
				return ;
			}
			main.add(d.getDeck().removeFirst());
		}
		
		catch(Exception e) {
			System.out.print("Pioche vide");
		}
		
	}
	
	private void DemanderValeur() {
		
	}

	//Depend du type de joueur 
	//PLus tard : methode abstraite
	public  boolean accepter() {
		return false;
	}
	
	//Recuperer valeur totale dans main
	public int getTotal() {
		int t = 0;
		
		for(Carte c : this.main) {
			t+=c.getValeur();
		}
		
		return t;
	}
}
