package ProgettoGrafica.gianpaolobordin;

public class NonAlimentari extends Prodotti{
	
	protected String materiale = new String();;
	
	public NonAlimentari(int codice, String nome, double prezzo, String s) {
		super(nome,prezzo,codice);
		
		materiale = s;
	}
	
	public void applicaSconto(){
		
		if(this.materiale.equalsIgnoreCase("carta") ||this.materiale.equalsIgnoreCase("plastica") || this.materiale.equalsIgnoreCase("vetro") || this.materiale.equalsIgnoreCase("umido")){
			this.prezzo = this.prezzo*0.9;
		}else{
			super.applicaSconto();
		}
		
	}

	public String getMateriale() {
		return materiale;
	}

	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
}
