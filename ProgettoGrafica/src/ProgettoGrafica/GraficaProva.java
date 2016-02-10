package ProgettoGrafica;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import ProgettoGrafica.gianpaolobordin.Alimentari;
import ProgettoGrafica.gianpaolobordin.Data;
import ProgettoGrafica.gianpaolobordin.ListaSpesa;
import ProgettoGrafica.gianpaolobordin.NonAlimentari;
import ProgettoGrafica.gianpaolobordin.Prodotti;
public class GraficaProva {

	protected Shell shlNegoziofico;
	private Text Nome;
	private Text prezzo;
	private Text Materiale;
	private Text codiceprodotto;
	private Text txtTotale;
	private int controlloA=0;
	private int ncarr=0;
	private ListaSpesa ls;
	private int nElimina=0;
	private Prodotti p =new Prodotti();
	public List carrello;
	
	
	//private ListaSpesa lst =new ListaSpesa(true);
	private int controllo2A=0;
	private int ControlloLunghezza=0;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			GraficaProva window = new GraficaProva();
			window.open();
			
			
			
		} catch (Exception e) {//ciaoaoa
			
			e.printStackTrace();
		}
	}//ciao
//cjd
	/**
	 * Open the window.
	 */
	public void open() {
		
		Display display = Display.getDefault();
		createContents();
		shlNegoziofico.open();
		shlNegoziofico.layout();
		
		int nat= JOptionPane.showConfirmDialog(null,"Hai la tessera fedeltà?", "tessera", JOptionPane.YES_NO_OPTION);
		if(nat==0){
			//si ce l'ho
			 ls =new ListaSpesa(true);
		}
		else{
			//no
			ls =new ListaSpesa(false);
		}
		
		while (!shlNegoziofico.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		
		shlNegoziofico = new Shell();
		shlNegoziofico.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		//shell.setEnabled(false);
		shlNegoziofico.setSize(550, 390);
		shlNegoziofico.setText("NegozioFico");
		//JOptionPane.showMessageDialog (null, "Benvenuto");
		
		carrello = new List(shlNegoziofico, SWT.BORDER);
		carrello.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int nat= JOptionPane.showConfirmDialog(null,"Vuoi eliminare questo prodotto?", "Elimina", JOptionPane.YES_NO_OPTION);
				if(nat==0){
					
					if(ncarr>0){
						
						nElimina= carrello.getSelectionIndex();
						//JOptionPane.showMessageDialog(null, nElimina);
						carrello.remove(nElimina);
						ls.eliminaProdotto(nElimina);
						ncarr--;
						}
						else{
							JOptionPane.showMessageDialog(null, "Il tuo carrello è vuoto");
						}
					//si ce l'ho
				
				}
				else{
					return;
					//no
					
				}
			}
		});
		carrello.setBounds(343, 79, 250, 194);


		
		
		DateTime DataScadenza = new DateTime(shlNegoziofico, SWT.BORDER);
		DataScadenza.setEnabled(false);
		DataScadenza.setBounds(192, 149, 80, 24);
		
		
		Group group = new Group(shlNegoziofico, SWT.NONE);
		group.setBounds(20, 47, 218, 30);
		
		Button btnNonAlimentare = new Button(group, SWT.RADIO);
		btnNonAlimentare.setSelection(true);
		btnNonAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Materiale.setEnabled(true);
				DataScadenza.setEnabled(false);
			}
		});
		btnNonAlimentare.setBounds(0, 10, 105, 16);
		btnNonAlimentare.setText("Non Alimentare");
		
		Button btnAlimentare = new Button(group, SWT.RADIO);
		btnAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Materiale.setEnabled(false);
				DataScadenza.setEnabled(true);
			}
		});
		
		
		btnAlimentare.setBounds(111, 10, 107, 16);
		btnAlimentare.setText("Alimentare");
	
		
		Button btnAggiungi = new Button(shlNegoziofico, SWT.NONE);
		btnAggiungi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//controllo se ho inserito qualcosa nel nome 
				ControlloLunghezza = 0;
				int Lunghezza;
				try {
					if( (Lunghezza = Nome.getText().length())==0 ){
						ControlloLunghezza++;
						JOptionPane.showMessageDialog(null, "Inserisci il nome del prodotto");
					}
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Inserisci un Nome valido");
				}
				
				
				//controllo se il prezzo inserito Ã¨ maggiore di 0.0
				double RisPrezzo=0;
				try {
					RisPrezzo = Double.parseDouble(prezzo.getText());
					if(RisPrezzo <=0.0){
						ControlloLunghezza++;
						JOptionPane.showMessageDialog(null, "Inserisci un Prezzo valido,non regaliamo nulla");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Inserisci un Prezzo valido");
				}
				
				
				//controllo se il codice prodotto inserito e' valido
				int LunghezzaCodiceProdotto;
				int codiceProdotto;//=codiceprodotto.getText();
				try {
					codiceProdotto = Integer.parseInt(codiceprodotto.getText());
					if( ( LunghezzaCodiceProdotto = codiceprodotto.getText().length())<=0 ){
						ControlloLunghezza++;
						JOptionPane.showMessageDialog(null, "Inserisci il codice prodotto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Inserisci un codice valido");
					return;
				}
				 
				
				
			
				if(ControlloLunghezza==0){
					carrello.add(Nome.getText() + ":   " +RisPrezzo + " €");
					ncarr++;
					if(btnNonAlimentare.getSelection() == true){
					
						int codice = Integer.valueOf(codiceprodotto.getText());
						NonAlimentari nn = new NonAlimentari(codice, Nome.getText() ,RisPrezzo,  Materiale.getText());
						System.out.println(nn.getMateriale());
						//nn.applicaSconto();
						
					//	NonAlimentari nnn = new NonAlimentari(codice, Nome.getText() ,RisPrezzo,  Materiale.getText());
						try {
							//nn.applicaSconto();
						
							ls.aggiungiCarrello(nn);
							//lst.aggiungiCarrello(nnn);
							
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(btnAlimentare.getSelection() == true){
						
						int codice = Integer.valueOf(codiceprodotto.getText());
						Alimentari n = new Alimentari(codice, Nome.getText() ,RisPrezzo, new Data(DataScadenza.getDay(),DataScadenza.getMonth(),DataScadenza.getYear() )) ;					
						//Alimentari na = new Alimentari(codice, Nome.getText() ,RisPrezzo, new Data(DataScadenza.getDay(),DataScadenza.getMonth(),DataScadenza.getYear() )) ;	
						
						try {
							
							//n.applicaSconto();
							
							ls.aggiungiCarrello(n);
							//lst.aggiungiCarrello(na);
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			
				}
			}
		});
		 
		
		
		btnAggiungi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnAggiungi.setBounds(67, 243, 125, 30);
		btnAggiungi.setText("Aggiungi Al Carrello");
		
		Nome = new Text(shlNegoziofico, SWT.BORDER);
		Nome.setBounds(10, 152, 105, 21);
		
		prezzo = new Text(shlNegoziofico, SWT.BORDER);
		prezzo.setBounds(138, 152, 34, 21);
		
		Label lblCarrello = new Label(shlNegoziofico, SWT.NONE);
		lblCarrello.setBounds(343, 47, 55, 15);
		lblCarrello.setText("Carrello:");
		
		Label lblNomeProdotto = new Label(shlNegoziofico, SWT.NONE);
		lblNomeProdotto.setBounds(10, 131, 105, 15);
		lblNomeProdotto.setText("Nome Prodotto");
		
		Label lblNegozioBord = new Label(shlNegoziofico, SWT.NONE);
		lblNegozioBord.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblNegozioBord.setAlignment(SWT.CENTER);
		lblNegozioBord.setFont(SWTResourceManager.getFont("Snap ITC", 14, SWT.NORMAL));
		lblNegozioBord.setBounds(160, 0, 238, 25);
		lblNegozioBord.setText("Negozio Bord && Bort");
		
		Label lblPrezzo = new Label(shlNegoziofico, SWT.NONE);
		lblPrezzo.setBounds(138, 131, 34, 15);
		lblPrezzo.setText("Prezzo");
		
		Materiale = new Text(shlNegoziofico, SWT.BORDER);
		Materiale.setBounds(138, 216, 105, 21);
		
		Label lblMateriale = new Label(shlNegoziofico, SWT.NONE);
		lblMateriale.setBounds(138, 195, 55, 15);
		lblMateriale.setText("Materiale");
		
		Label label = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(-18, 109, 281, 2);
		
		Label label_1 = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 279, 267, 2);
		
		codiceprodotto = new Text(shlNegoziofico, SWT.BORDER);
		codiceprodotto.setBounds(10, 216, 105, 21);
		
		Label lblNewLabel = new Label(shlNegoziofico, SWT.NONE);
		lblNewLabel.setBounds(10, 195, 92, 15);
		lblNewLabel.setText("Codice Prodotto");
		
		Button btnElimina = new Button(shlNegoziofico, SWT.NONE);
		btnElimina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(ncarr>0){
				
					ls.eliminaUltimoProdotto();
					
					ncarr--;
					carrello.remove(ncarr);
				}
				else{
					JOptionPane.showMessageDialog(null, "Il tuo carrello è vuoto");
				}
			}
		});
		btnElimina.setBounds(10, 287, 105, 25);
		btnElimina.setText("Elimina Prodotto");
		
		Button btnSalva = new Button(shlNegoziofico, SWT.NONE);
		btnSalva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ls.SalvaCarrello();
				
			}
		});
		btnSalva.setBounds(345, 287, 80, 25);
		btnSalva.setText("Salva Carrello");
		
		Button btnCaricaCarrello = new Button(shlNegoziofico, SWT.NONE);
		btnCaricaCarrello.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					double RisPrezzo=0;
					ls.CaricaCarrello();
					for(int i=0;i<ls.nProdotti();i++){
						carrello.add(ls.getLista()[i].getNome() + ":   " +ls.getLista()[i].getPrezzo() + " €");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCaricaCarrello.setText("Carica Carrello");
		btnCaricaCarrello.setBounds(431, 287, 93, 25);
		
		txtTotale = new Text(shlNegoziofico, SWT.CENTER);
		txtTotale.setFont(SWTResourceManager.getFont("Segoe UI Black", 11, SWT.BOLD));
		txtTotale.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		txtTotale.setBounds(431, 318, 93, 26);
		
		Label lblDataDiScadenza = new Label(shlNegoziofico, SWT.NONE);
		lblDataDiScadenza.setBounds(192, 131, 98, 15);
		lblDataDiScadenza.setText("Data di Scadenza");
		
		Label label_2 = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.VERTICAL);
		label_2.setBounds(316, 68, 2, 213);
		
		Label label_3 = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(0, 32, 534, 2);
		
		
		
		Button btnCalcola = new Button(shlNegoziofico, SWT.NONE);
		btnCalcola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			/*
				if(nat==0){
					
					txtTotale.setText(" "+  lst.calcolaSpesa());
				}
				else{*/
				
					txtTotale.setText(" "+ ls.calcolaSpesa() );
				//}
				
			}
		});
		btnCalcola.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnCalcola.setBounds(343, 318, 82, 25);
		btnCalcola.setText("CALCOLA");
		
		

		
		
		
		
		
		
		

	}
}
