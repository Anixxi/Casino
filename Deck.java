import java.util.LinkedList;

public class Deck {
	//Les cartes a piocher
	private LinkedList<Carte> deck;
	
	public Deck() {
		this.deck = new LinkedList<Carte>(); 
		this.remplir();
	}

	//Remplit le deck de 4 cartes de m�mes valeur, en ignorant les diff�rentes couleurs et symboles
	private void remplir() {
		Carte c ;
		
		for (int v=0; v<4; v++) {
					
			for (int i = 0 ; i <= 13 ; i++) {
				c = new Carte(Carte.symboles(i),i);
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
}
