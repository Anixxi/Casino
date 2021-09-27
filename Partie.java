
public class Partie {

	
	public static void main(String[] args) {
	Joueur j1 = new Joueur();
	Croupier cr = new Croupier();
	Deck d = new Deck();
	System.out.print(d); 
	cr.proposer(j1,d);
	}

}
