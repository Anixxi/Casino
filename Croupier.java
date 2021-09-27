
public class Croupier extends Joueur {

	public void proposer(Joueur j,Deck d){
		if(j.accepter()) {
			j.piocher(d);
		}
	}
}
