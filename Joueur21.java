
public class Joueur21 extends Joueur {
	
	public Joueur21(String n) {
		super(n);
	}

	@Override
	public boolean accepter(Deck d) {
		if( this.getTotal() < BlackJack) return true;
		return false;
	}
}
