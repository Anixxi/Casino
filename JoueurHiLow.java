import java.util.Scanner;

public class JoueurHiLow extends Joueur {

	private int seuil = 3;
	private static int comptage = 0;
	
	public JoueurHiLow(String n) {
		super(n);
	}
	
	public boolean accepter(Deck d) {
		return JoueurHiLow.comptage / d.getDeck().size() >= seuil;
	}
	

	public static void hiLow(String val) {
		switch(val) {
			
			case"2": case "3": case "4": case "5": case "6":
				JoueurHiLow.comptage+=1;
				return ;
				
			case "7": case "8": case "9":
				return ;
				
			case "10": case "V": case "R": case "D": case "1":
				JoueurHiLow.comptage-=1;
				return ;
		}	
	}
	
	@Override
	public void piocher(Deck d,Scanner sc) {
		try {
			if(d.getDeck().peek().getValeur() == 1 ) {
				int nb=DemanderValeur(sc);
				Carte c = d.getDeck().removeFirst();
				c.setValeur(nb);
				getMain().add(c);
				return ;
			}
			getMain().add(d.getDeck().removeFirst());
		}
		
		catch(Exception e) {
			System.out.print("Pioche vide");
		}
		
	}

	/*
	 * public int comptageHiLow(int val) { int comptageFinal=0; for (int i = 0; i <
	 * array.length; i++) { hiLow(String.valueOf(val)); comptageFinal = val; }
	 * 
	 * return comptageFinal; }
	 */
}