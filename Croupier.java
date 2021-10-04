
public class Croupier extends Joueur {

	private final int stop = 17;
	
	public void proposer(Joueur j,Deck d) {
		if(j.accepter()) {
			j.piocher(d);
		}
	}
	
	@Override
	public boolean accepter () {
		return this.getTotal() <= stop;
	}
}
