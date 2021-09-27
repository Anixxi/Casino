import java.util.LinkedList;

public class Joueur {
	
	LinkedList<Carte> main ;
	
	public void piocher(Deck d) {
		try {
			main.add(d.getDeck().removeFirst());
		}
		
		catch(Exception e) {System.out.print("Pioche vide"); }
		;
	}
	
	public void poser() {
		
		
	}
}
