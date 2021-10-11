import java.util.Scanner;

public class JoueurHiLow extends Joueur {

	private int comptage;
	public JoueurHiLow(String n) {
		super(n);
		this.comptage = 0;
	}
	
	@Override
	public boolean accepter() {
		return true;
	}
	
	public int hiLow(String val) {
		switch(val) {
			
			case"2": case "3": case "4": case "5": case "6":
				return 1;
				
			case "7": case "8": case "9":
				return 0;
			case "10": case "V": case "R": case "D":
				return -1;
		}
		return 0;
		
	}
	
	public void piocher(Deck d,Scanner sc) {
		try {
			if(d.getDeck().peek().getValeur() == 1 ) {
				int nb=DemanderValeur(sc);
				Carte c = d.getDeck().removeFirst();
				c.setValeur(nb);
				main.add(c);
				return ;
			}
			main.add(d.getDeck().removeFirst());
		}
		
		catch(Exception e) {
			System.out.print("Pioche vide");
		}
		
	}
	
	public int comptageHiLow(int val) {
		int comptageFinal=0;
		for (int i = 0; i < array.length; i++) {
			hiLow(String.valueOf(val));
			 comptageFinal = val;
		}
		
		return comptageFinal;
	}
}
