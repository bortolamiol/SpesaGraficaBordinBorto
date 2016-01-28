package ProgettoGrafica;

import javax.swing.*;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import ProgettoGrafica.gianpaolobordin.*;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Group;
public class GraficaProva {

	protected Shell shlNegoziofico;
	private Text Nome;
	private Text prezzo;
	private Text Materiale;
	private Text codiceprodotto;
	private Text text_3;
	private int controlloA=0;
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
		List carrello = new List(shlNegoziofico, SWT.BORDER);
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
				int Lunghezza;
				if( (Lunghezza = Nome.getText().length())==0 ){
					ControlloLunghezza++;
				}
				
				//controllo se il prezzo inserito è maggiore di 0.0
				double RisPrezzo=Double.parseDouble(prezzo.getText());
				if(RisPrezzo <=0.0){
					ControlloLunghezza++;
				}
				
				//controllo se il codice prodotto inserito è valido
				int LunghezzaCodiceProdotto;
				if( (LunghezzaCodiceProdotto = codiceprodotto.getText().length())<=0 ){
					ControlloLunghezza++;
				}
				
				//controllo se ho scelto non alimentari,controllo se ho messo materiale
				/*btnAlimentari.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
					Lunghezza=0;
						if( (Lunghezza = Materiale.getText().length())==0 ){
							ControlloLunghezza++;
						}
					}
				});
				
				btnNonAlimentari.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
					Lunghezza=0;
						if( (Lunghezza = data.getText().length())==0 ){
							ControlloLunghezza++;
						}
					}
				});*/
				//inserisco ciò che scritto nel text box carrello
				if(ControlloLunghezza==0){
					carrello.add(Nome.getText() + ":   " +RisPrezzo);
					if(btnNonAlimentare.getSelection() == true){
						ListaSpesa ls =new ListaSpesa(true);
						int codice = Integer.valueOf(codiceprodotto.getText());
						NonAlimentari nn = new NonAlimentari(codice, Nome.getText() ,RisPrezzo,  Materiale.getText());					
						}
					if(btnAlimentare.getSelection() == true){
						ListaSpesa ls =new ListaSpesa(true);
						int codice = Integer.valueOf(codiceprodotto.getText());
						Alimentari n = new Alimentari(codice, Nome.getText() ,RisPrezzo, new Data(DataScadenza.getDay(),DataScadenza.getMonth(),DataScadenza.getYear() )) ;					
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
		
		Label lblNegozioBord = new Label(shlNegoziofico, SWT.BORDER);
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
			}
		});
		btnElimina.setBounds(10, 287, 105, 25);
		btnElimina.setText("Elimina Prodotto");
		
		Button btnSalva = new Button(shlNegoziofico, SWT.NONE);
		btnSalva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSalva.setBounds(345, 287, 80, 25);
		btnSalva.setText("Salva Carrello");
		
		Button btnCaricaCarrello = new Button(shlNegoziofico, SWT.NONE);
		btnCaricaCarrello.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCaricaCarrello.setText("Carica Carrello");
		btnCaricaCarrello.setBounds(431, 287, 93, 25);
		
		Label label_2 = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.VERTICAL);
		label_2.setBounds(316, 68, 2, 213);
		
		Label label_3 = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(0, 32, 534, 2);
		
		Button btnCalcola = new Button(shlNegoziofico, SWT.NONE);
		btnCalcola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCalcola.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnCalcola.setBounds(343, 318, 82, 25);
		btnCalcola.setText("CALCOLA");
		
		text_3 = new Text(shlNegoziofico, SWT.BORDER);
		text_3.setBounds(441, 318, 83, 21);
		
		Label lblDataDiScadenza = new Label(shlNegoziofico, SWT.NONE);
		lblDataDiScadenza.setBounds(192, 131, 98, 15);
		lblDataDiScadenza.setText("Data di Scadenza");
		
		
		
		

	}
}
