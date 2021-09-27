
public class Joueur21 extends Joueur {
	
	@Override
	public boolean accepter() {
		if( this.getTotal() < BlackJack) return true;
		return false;
	}
}
