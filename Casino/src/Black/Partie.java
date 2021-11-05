package Black;

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
	
	
	private Joueur gagnant() {
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
			return null;
		}
		return gn;
	}
	
	private String ecritureGagnant(Joueur gn) {

		if (gn == null) {
			return "Aucun gagnant, le croupier l'emporte";
		}
		return "Victoire de : " + gn.getNom();
	}


	public static void main(String[] args) {
		Deck d = new Deck();
	
		System.out.println("yo");
		
		Joueur j1 = new JoueurHiLow("Joueur");
		Croupier cr = new Croupier("Croupier");
		int vJoueur = 0,vCroupier =0;
		
		
		for(int i = 0; i < 1000 ; i++ ) {
			if(d.getDeck().isEmpty()) {
				d= new Deck();
				JoueurHiLow.changementDeck();
			}
			
			try {
				Partie p = new Partie();
				p.getListe().add(j1);
				p.getListe().add(cr);
				Scanner sc = new Scanner(System.in);
					  
				p.init(d,sc);
					
				for (Joueur j : p.getListe()) {
					cr.proposer(j, d,sc,p);
				}
					 
				while ((j1.accepter(d) || cr.accepter(d)) ) {
					if(j1.accepter(d)) cr.proposer(j1, d, sc, p);
					if(cr.accepter(d)) cr.proposer(cr, d, sc, p);
				
				}					
				Joueur gn = p.gagnant();
				if(gn == j1 ) vJoueur++;
				if (gn == cr || gn == null) vCroupier++;
					
	
				j1.getMain().clear();
				cr.getMain().clear();
				sc.close();
			}catch (Exception e) {
					j1.getMain().clear();
					cr.getMain().clear();
					d = new Deck();
					JoueurHiLow.changementDeck();
					Partie p = new Partie();
					p.getListe().add(j1);
					p.getListe().add(cr);
					Scanner sc = new Scanner(System.in);
						  
					p.init(d,sc);
						
					for (Joueur j : p.getListe()) {
						cr.proposer(j, d,sc,p);
					}
						 
					while (j1.accepter(d) || cr.accepter(d) ) {
						if(j1.accepter(d)) cr.proposer(j1, d, sc, p);
						if(cr.accepter(d)) cr.proposer(cr, d, sc, p);
					
					}

						
					Joueur gn = p.gagnant();
					//	System.out.println(p.ecritureGagnant(gn));
					if(gn == j1) vJoueur++;
					if (gn == cr || gn == null) vCroupier++;
						

					j1.getMain().clear();
					cr.getMain().clear();
					sc.close();
				}
		}
		System.out.println("");
		
		System.out.println("Total victoires " + cr.getNom() + " :" + vCroupier);
		System.out.println("Total victoires " + j1.getNom() + " :" + vJoueur);

		
		
		
		

	}

}