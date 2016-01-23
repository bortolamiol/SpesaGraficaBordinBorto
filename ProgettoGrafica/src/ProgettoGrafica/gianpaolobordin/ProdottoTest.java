package ProgettoGrafica.gianpaolobordin;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class ProdottoTest {

	public static void main(String[] args) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		
		int codice = 0;
		double prezzo = 0;
		String s = new String();
		String dati = new String(); 
		Prodotti prod = new Prodotti();
		try{
		System.out.println("inserisci prezzo");
		dati = tastiera.readLine();
		prezzo = Integer.valueOf(dati);
		}catch(Exception e){
			System.out.println("Errore");
		}
		prod.setPrezzo(prezzo);
		try{
			System.out.println("inserisci codice");
			dati = tastiera.readLine();
			codice = Integer.parseInt(dati);
			}catch(Exception e){
				System.out.println("Errore");
			}
		prod.setCodice(codice);
		try{
			System.out.println("inserisci nome");
			dati = tastiera.readLine();
			s = dati;
			}catch(Exception e){
				System.out.println("Errore");
			}
		prod.setNome(s);
		System.out.println(prod.toString());
		
		prod.applicaSconto();
		System.out.println(prod.toString());
		
		Prodotti copia = new Prodotti("Pane",45,6430);
		System.out.println(copia.toString());
		
		Prodotti prod2 = new Prodotti(prod); 
		System.out.println(prod2.toString());
		
		System.out.println(prod.equals(prod2));
		System.out.println(prod.equals(copia));
		
		Prodotti clone = new Prodotti();
		prod.clone(clone);
		System.out.println(clone.toString());
	}

}
