import java.util.LinkedList;
import java.util.Scanner;

public class Joueur {
	int BlackJack = 21;
	
	LinkedList<Carte> main ;
	
	// si "AS" demander valeur
	public void piocher(Deck d) {
		try {
			if(d.getDeck().peek().getValeur() == 1 ) {
				DemanderValeur();
				Carte c = d.getDeck().removeFirst();
				main.add(c);
				return ;
			}
			main.add(d.getDeck().removeFirst());
		}
		
		catch(Exception e) {
			System.out.print("Pioche vide");
		}
		
	}
	
	
	private void DemanderValeur() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Ecrire 1 ou 11 pour choisir la valeur de As");
		 
		 int nombre=scanner.nextInt();

		 while(nombre != 1 && nombre != 11) {
			 System.out.println("Ecrire 1 ou 11");
			 	//Lit l'entier écrit par l'utilisateur et l'affecte à  la variable nombre du programme
		      nombre = scanner.nextInt();
		        // Affiche le nombre saisit par l'utilisateur
		     
		 }
		 System.out.println("Vous avez choisi " + (nombre) + " comme valeur de votre As");
		 scanner.close();
		
	}

	//Depend du type de joueur 
	//PLus tard : methode abstraite
	public  boolean accepter() {
		return true;
	}
	
	//Recuperer valeur totale dans main
	public int getTotal() {
		int t = 0;
		
		if (this.main.isEmpty()) return 0;
		for(Carte c : this.main) {
			t+=c.getValeur();
		}
		
		return t;
	}
	
	public Joueur() {
		this.main = new LinkedList<Carte>();
	}
}
