package Black;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Joueur {

	protected int BlackJack = 21;
	
	private LinkedList<Carte> main ;
	private String nom;
	private boolean aGagne;
	
	// si "AS" demander valeur
	public void piocher(Deck d,Scanner sc) {
		try {
			if(d.getDeck().peek().getValeur() == 1 ) {
				int nb=choixValeur();
				Carte c = d.getDeck().removeFirst();
				c.setValeur(nb);
				getMain().add(c);
				return ;
			}
			main.add(d.getDeck().removeFirst());
		}catch(Error e) {
			System.out.print("Pioche vide");
		}
		
	}
	
	public boolean aPerdu() {
		return this.getTotal() > BlackJack;
	}
	
	protected int choixValeur() {
		if(this.getTotal() + 11 > BlackJack) return 1;
		else return 11;
	}
	
	protected int DemanderValeur(Scanner scanner) {
		 System.out.println("Joueur " + this.nom + " �crivez 1 ou 11 pour choisir la valeur de l'as");

		 System.out.println("Main courante : " + this.getTotal());
		 int nombre=scanner.nextInt();

		 while(nombre != 1 && nombre != 11) {
			 System.out.println("Ecrire 1 ou 11");
			 	//Lit l'entier �crit par l'utilisateur et l'affecte �  la variable nombre du programme
		      nombre = scanner.nextInt();
		        // Affiche le nombre saisit par l'utilisateur
		     
		 }
		 System.out.println("Vous avez choisi " + (nombre) + " comme valeur de votre as");
		 return nombre;
		
	}

	//Depend du type de joueur 
	public  abstract boolean accepter(Deck d);
	
	//Recuperer valeur totale dans main
	public int getTotal() {
		int t = 0;
		
		if (this.main.isEmpty()) return 0;
		for(Carte c : this.main) {
			t+=c.getValeur();
		}
		
		return t;
	}
	
	public String getNom() {
		return nom;
	}
	
	public LinkedList<Carte> getMain() {
		return main;
	}
	
	public Joueur(String n) {
		this.main = new LinkedList<Carte>();
		this.nom = n;
		this.aGagne = false;
	}

	public boolean isHiLow() {
		return this.getClass() == JoueurHiLow.class;
	}

	public void setAGagne() {
		this.aGagne = true;
		
	}
}