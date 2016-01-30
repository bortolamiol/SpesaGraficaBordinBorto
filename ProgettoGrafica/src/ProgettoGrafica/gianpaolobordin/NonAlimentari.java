package ProgettoGrafica.gianpaolobordin;

public class NonAlimentari extends Prodotti{
	
	protected String materiale;
	
	public NonAlimentari(int codice, String nome, double prezzo, String s) {
		super(nome,prezzo,codice);
		materiale = new String();
		materiale = s;
	}
	
	public void applicaSconto(){
		
		if(materiale=="carta" || materiale=="plastica" || materiale == "vetro" || materiale=="umido"){
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
