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
			for( Joueur j : this.getListe() ) {
				j.piocher(d);
			}
		}
	}
	

	
	public static void main(String[] args) {
		Joueur j1 = new Joueur21();
		Croupier cr = new Croupier();
		Deck d = new Deck();
		Partie p = new Partie();
		p.getListe().add(j1);
		p.getListe().add(cr);
		
		System.out.println(d); 
		cr.proposer(j1,d);
		System.out.println(d); 
		p.init(d);
		System.out.println(d); 
		
		for (Joueur j : p.getListe()) {
			cr.proposer(j, d);
		}
		System.out.println(d); 
		while (!d.getDeck().isEmpty()) {
			j1.piocher(d);
			System.out.println(d); 
		}

	//  probleme deuxieme as --> dans demanderValeur nom=nextInt
	}

}
