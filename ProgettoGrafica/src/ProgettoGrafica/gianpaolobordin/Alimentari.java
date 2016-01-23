package ProgettoGrafica.gianpaolobordin;

public class Alimentari extends Prodotti{
	protected Data g;
	
	public Alimentari(int codice,String nome, double prezzo, Data g) {
		super(nome,prezzo,codice); //chiama il costruttore della classe estesa
		g=new Data();
		this.g=g;
	}

	public void setScadenza(Data scadenza){
		this.g = scadenza;
	}
	public Data getScadenza(){
		return g;
	}
	public void applicaSconto(){
		if(g.getDifference(new Data())<10){
			this.prezzo=this.prezzo*0.8;
		}else{
			super.applicaSconto();
		}
		
	}
}
