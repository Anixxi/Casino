import java.util.LinkedList;
import java.util.Scanner;

public class Partie {

	public Partie () {
		listeJoueurs = new LinkedList<Joueur>();
	}
	private LinkedList<Joueur> listeJoueurs;
	
	public LinkedList<Joueur> getListe() {
		return listeJoueurs;
	}
	
	
	public void init(Deck d,Scanner sc) {
		for(int i = 0; i < 2 ; i++) {
			for( Joueur j : this.getListe() ) {
				j.piocher(d,sc);
			}
		}
	}
	
//	public String resultat(Joueur j, Croupier cr) {
//		if( j.aPerdu() ) return "Victoire de " + cr.getNom();
//		else {
//			if (cr.aPerdu()) {
//				return "Victoire de " + j.getNom();
//			}
//			
//			else {
//				return "Victoire de " + this.Gagnant();
//			}
//		}
//	}
//	
	public boolean hasHiLow() {
		for (Joueur j : this.getListe()) {
			if (j.isHiLow()) {
				return true;
			}
		}
		return false;
	}
	
	
	private String gagnant() {
		Joueur gn = null;
		for (Joueur j : this.listeJoueurs) {
			if(!j.aPerdu()) {
				if (gn == null) {
					gn = j;
				}
				
				if(j.getTotal() > gn.getTotal()) {
					gn = j;
				}
			}
			
		}
		
		if (gn == null) {
			return "Aucun gagnant, le croupier l'emporte";
		}
		return "Victoire de : " + gn.getNom();
	}


	public static void main(String[] args) {
	
		Joueur j1 = new JoueurHiLow("JoueurHL");
		Croupier cr = new Croupier("Croupier");
		//Joueur j2 = new JoueurHiLow("HL");
		
		Deck d = new Deck();
		Partie p = new Partie();
		p.getListe().add(j1);
		p.getListe().add(cr);
		//p.getListe().add(j2);
		Scanner sc = new Scanner(System.in);
		  
		p.init(d,sc);
		
		for (Joueur j : p.getListe()) {
			cr.proposer(j, d,sc,p);
		}
		 
		while (j1.accepter(d) || cr.accepter(d) ) {
			if(j1.accepter(d)) j1.piocher(d,sc);
			if(cr.accepter(d)) cr.piocher(d, sc);
			//if(j2.accepter(d)) j2.piocher(d, sc);
		}
		System.out.println("Total joueur 1 :" + j1.getTotal());
		System.out.println("Total croupier :" + cr.getTotal());
		//System.out.println("Total joueur HL :" + j2.getTotal());
		System.out.println(p.gagnant());
		sc.close();

	}

}
