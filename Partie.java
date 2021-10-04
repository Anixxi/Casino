import java.util.LinkedList;

public class Partie {

	public Partie () {
		listeJoueurs = new LinkedList<Joueur>();
	}
	private LinkedList<Joueur> listeJoueurs;
	
	public LinkedList<Joueur> getListe() {
		return listeJoueurs;
	}
	
	
	public void init(Deck d) {
		for(int i = 0; i < 2 ; i++) {
			for( Joueur j : listeJoueurs ) {
				j.piocher(d);
			}
		}
	}
	

	
	public static void main(String[] args) {
		Joueur j1 = new Joueur();
		Croupier cr = new Croupier();
		Deck d = new Deck();
		Partie p = new Partie();
		p.getListe().add(j1);
		p.getListe().add(cr);
		
		//System.out.print(d); 
		//cr.proposer(j1,d);
		
		p.init(d);
		
		for (Joueur j : p.getListe()) {
			cr.proposer(j, d);
		}

		//Ne demande pas la valeur pour les as
		while (!d.getDeck().isEmpty()) {
			j1.piocher(d);
		}

	
	}

}
