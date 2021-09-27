
public class Carte {
	
	private int valeur;
	private String symbole;
	
	
	public Carte(String symbole,int valeur) {
		this.symbole= symbole;
		this.valeur = valeur;
		
	}
	
	public int getValeur() {
	
		return this.valeur;
		
	}
	
	public String getSymbole() {
		return this.symbole;
	}

	public String symboles(int val) { 
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


}
