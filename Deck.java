import java.util.LinkedList;
import java.util.Collections;

public class Deck {
	//Les cartes a piocher
	private LinkedList<Carte> deck;
	
	public Deck() {
		this.deck = new LinkedList<Carte>(); 
		this.remplir();
		this.melanger();
	}

	//Remplit le deck de 4 cartes de mêmes valeur, en ignorant les différentes couleurs et symboles
	private void remplir() {
		Carte c ;
		
		for (int v=0; v<4; v++) {
					
			for (int i = 1 ; i <= 13 ; i++) {
				c = new Carte(Carte.symboles(i),i);
				this.deck.add(c);
			}
		}
	}
	

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Carte c : this.deck) {
			sb.append(c.getSymbole() + " ");
		}
		return sb.toString();
	}
	
	public LinkedList<Carte> getDeck(){
		return this.deck;
	}
	
	public void melanger() {
		Collections.shuffle(this.getDeck());
	}
}
