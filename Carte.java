
public class Carte {
	
	private int valeur;
	private String symbole;
	private static final int max = 10;
	
	public Carte(String symbole,int valeur) {
		this.symbole= symbole;
		this.valeur = valeur;
		
	}
	
	public static int getMax() {
		return max;
	}
	
	public int getValeur() {
		return this.valeur;
		
	}
	
	public String getSymbole() {
		return this.symbole;
	}

	public static String symboles(int val) { 
		switch(val) {
			
			case 11:
				return "V";
				
			case 12:
				return "D";
			case 13:
				return "R";
				
			default :
				return String.valueOf(val);
		}
	}

	public void setValeur(int nb) {
		this.valeur = nb;
		
	}


}
