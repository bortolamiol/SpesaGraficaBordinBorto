package ProgettoGrafica.gianpaolobordin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;

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
	
	public void SalvaCarrello(){
		BufferedWriter scrittore;

		try {
			scrittore = new BufferedWriter(new FileWriter("Z:lista.txt", true)); //NB true per APPEND
			//scrittore.write("Negozio Bord && Bort\n");
			for(int i=0;i<this.nprod;i++){
				if(lista[i] instanceof Alimentari){
					scrittore.write(";" +"Alimentare: "+ lista[i].nome + ";" + lista[i].prezzo + ";" +lista[i].getCodice() + ";" + ((Alimentari)lista[i]).getScadenza() + "\r\n");
				}
				else{
				scrittore.write(";" +"Non Alimentare: "+lista[i].nome + ";" + lista[i].prezzo + ";" +lista[i].getCodice() + ";" + ((NonAlimentari)lista[i]).getMateriale() + "\r\n");
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
	
	public void CaricaCarrello(){
		BufferedReader lettore;
		String riga = "";
		String testo = "";
		String[] elementi;
		try {
			lettore = new BufferedReader(new FileReader("Z:lista.txt"));
			do {
				riga = lettore.readLine();
				testo = testo + riga + "\n";
				elementi = testo.split(";");
				elementi = testo.split("/");
				// crea oggetti alim o non alim
				if(elementi[0] == "Alimentari"){
					int c;
					double p;
					c = Integer.parseInt(elementi[1]);
					p = Double.parseDouble(elementi[3]);
					int g,m,a;
					g = Integer.parseInt(elementi[4]);
					m = Integer.parseInt(elementi[5]);
					a = Integer.parseInt(elementi[6]);
					Data d = new Data(g,m,a);
					Alimentari A = new Alimentari(c, elementi[1], p, d);
				}else{
					
					int c;
					double p;
					c = Integer.parseInt(elementi[1]);
					p = Double.parseDouble(elementi[3]);
					
				}
				
			} while (riga != null);
		//	MessageDialog.openInformation(shell, "Lettura file", "Riga: " + testo);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//MessageDialog.openError(shell, "Lettura file", "ERRORE");
		}
	}
}


