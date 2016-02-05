package ProgettoGrafica.gianpaolobordin;

public class Prodotti {
	//attribute
	protected String nome;
	protected double prezzo;
	private int codice;
	//constructors
	public Prodotti(){
		nome = new String();
		prezzo = 0.0;
		codice = 0;
	}
	public Prodotti(String s,double p,int c){
		super();
		this.nome = s;
		this.prezzo = p;
		this.codice = c;
	}
	public Prodotti(Prodotti Object){
		this.nome = Object.nome;
		this.prezzo = Object.prezzo;
		this.codice = Object.codice;
	}
	//methods
	
	//Getters
	public String getNome() {
		return nome;
	}
	public double getCodice() {
		return codice;
	}
	public double getPrezzo() {
		return prezzo;
	}
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	//others
	public void applicaSconto(){
		//this.prezzo=this.prezzo-3;
	}
	@Override
	public String toString() {
		return "Prodotti [nome=" + this.nome + ", prezzo=" + this.prezzo + ", codice=" + this.codice + "]";
	}
	public boolean equals(Prodotti obj) {
		if(this.prezzo == obj.prezzo && this.codice == obj.codice && this.nome == obj.nome){
			return true;
		}else{
			return false;
		}
	}
	public void clone(Prodotti copia){
		copia.codice=this.codice;
		copia.nome=this.nome;
		copia.prezzo=this.prezzo;
	} 
	
}
