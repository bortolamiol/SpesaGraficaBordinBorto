package ProgettoGrafica.gianpaolobordin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;

import ProgettoGrafica.GraficaProva;

public class ListaSpesa {
	Prodotti[] lista;
	private int nprod;
	private final int max=100;
	private boolean tessera;
	
	GraficaProva gp = new GraficaProva();
	
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
	public void eliminaProdotto(int pos){
		if(nprod>0){
			for(int i=pos;i<nprod;i++){
			lista[i]=lista[i+1];
			}
		}
			nprod--;
		
	}
	
	public void eliminaUltimoProdotto(){
		if(nprod>0){
		
			nprod--;
		}
	}
	
	public void SalvaCarrello(){
		BufferedWriter scrittore;

		try {
			scrittore = new BufferedWriter(new FileWriter("lista.txt", true)); //NB true per APPEND
			for(int i=0;i<this.nprod;i++){
				if(lista[i] instanceof Alimentari){
					scrittore.write("Alimentare;"+ lista[i].nome + ";" + lista[i].prezzo + ";" +lista[i].getCodice() + ";" + ((Alimentari)lista[i]).getScadenza() + ";\r\n");
				}
				else{
				scrittore.write("Non Alimentare;"+lista[i].nome + ";" + lista[i].prezzo + ";" +lista[i].getCodice() + ";" + ((NonAlimentari)lista[i]).getMateriale() + ";\r\n");
				}
			}
			scrittore.close();
			//MessageDialog.openInformation(shell, "Scrittura file", "TUTTO OK");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//MessageDialog.openError(shell, "Scrittura file", "ERRORE");
		}

	}
	
	public void CaricaCarrello() throws Exception{
		BufferedReader lettore;
		String riga = new String();
		String testo = new String();
		String[] elementi = new String[5];
		String[] da = new String[3];
		String pr;
		try {
			lettore = new BufferedReader(new FileReader("lista.txt"));
			riga = lettore.readLine();
			 while (riga != null){
				 
				elementi = riga.split(";");
				// crea oggetti alim o non alim
				if(elementi[0].equals("Alimentare")){
					//prendo codice e prezzo
					float c;
					double p;
					c = Float.parseFloat(elementi[3]);
					p = Double.parseDouble(elementi[2]);
					da=elementi[4].split("/");
					Data d = new Data(Integer.parseInt(da[0]),Integer.parseInt(da[1]),Integer.parseInt(da[2]));
					//creo alimentari e aggiungo a carrello
					Alimentari A = new Alimentari((int)c, elementi[1], p, d);
					aggiungiCarrello(A);
					pr =  ""+A.getNome() +" "+ A.getCodice() +" "+A.getPrezzo();
					System.out.println(pr);
					gp.carrello.add(pr);
				}else{
					
					//int c;
					double c, p;
					c = Double.parseDouble(elementi[3]);
					p = Double.parseDouble(elementi[2]);
					
					NonAlimentari na = new NonAlimentari((int)c,elementi[1],p,elementi[4]);
					aggiungiCarrello(na);
					
				}
				riga = lettore.readLine();
			}
		//	MessageDialog.openInformation(shell, "Lettura file", "Riga: " + testo);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//MessageDialog.openError(shell, "Lettura file", "ERRORE");
		}
	}

	public Prodotti[] getLista() {
		return lista;
	}
	
	public int nProdotti() {
		return nprod;
	}
}


