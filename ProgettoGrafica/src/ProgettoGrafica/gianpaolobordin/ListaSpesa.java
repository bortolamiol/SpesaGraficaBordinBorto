package ProgettoGrafica.gianpaolobordin;

public class ListaSpesa {
	Prodotti[] lista;
	private int nprod;
	private final int max=100;
	private boolean tessera;
	public ListaSpesa(boolean t) {
			nprod=0;
			lista= new Prodotti[max];
			this.tessera=t;
		}
		
	public void aggiungiCarrello(Prodotti p) throws Exception {
		if(nprod<max){
			lista[nprod++]=p;
			if(tessera==true){
				p.applicaSconto();
			}
		}else{
			throw new Exception("lista piena");
		}
	}
	public double calcolaSpesa(){
		double tot = 0;
		for(int i=0;i<nprod;i++){
			tot=tot+lista[i].getPrezzo();
		}
		return tot;
	}
	public void eliminaProdotto(){
		if(nprod>0){
			nprod--;
		}
	}
}


