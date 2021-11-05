package Black;

import java.util.Scanner;

public class Croupier extends Joueur {

	public Croupier(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	private final int stop = 17;
	
	public void proposer(Joueur j,Deck d,Scanner sc,Partie p) {
		if(j.accepter(d)) {
			if(p.hasHiLow()) {
				j.piocher(d,sc);
				JoueurHiLow.hiLow(j.getMain().getLast().getSymbole());
			}
			else {
				j.piocher(d,sc);
			}
			
		}
	}
	
	@Override
	public boolean accepter (Deck d) {
		return this.getTotal() <= stop;
	}


}