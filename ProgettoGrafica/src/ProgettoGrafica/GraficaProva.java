package ProgettoGrafica;

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
public class GraficaProva {

	protected Shell shlNegoziofico;
	private Text Nome;
	private Text text;
	private Table table;
	private Text text_1;
	private Text text_2;
	private Text text_3;

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
		
		Button btnAggiungi = new Button(shlNegoziofico, SWT.NONE);
		btnAggiungi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAggiungi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnAggiungi.setBounds(67, 243, 125, 30);
		btnAggiungi.setText("Aggiungi Al Carrello");
		
		Nome = new Text(shlNegoziofico, SWT.BORDER);
		Nome.setBounds(10, 152, 105, 21);
		
		text = new Text(shlNegoziofico, SWT.BORDER);
		text.setBounds(138, 152, 34, 21);
		
		Label lblCarrello = new Label(shlNegoziofico, SWT.NONE);
		lblCarrello.setBounds(343, 47, 55, 15);
		lblCarrello.setText("Carrello:");
		
		Button btnAlimentari = new Button(shlNegoziofico, SWT.CHECK);
		btnAlimentari.setBounds(170, 46, 93, 16);
		btnAlimentari.setText("Alimentari");
		
		Button btnNon = new Button(shlNegoziofico, SWT.CHECK);
		btnNon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNon.setBounds(10, 46, 105, 16);
		btnNon.setText("Non Alimentare");
		
		table = new Table(shlNegoziofico, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(343, 68, 181, 213);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
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
		
		text_1 = new Text(shlNegoziofico, SWT.BORDER);
		text_1.setBounds(138, 216, 105, 21);
		
		Label lblMateriale = new Label(shlNegoziofico, SWT.NONE);
		lblMateriale.setBounds(138, 195, 55, 15);
		lblMateriale.setText("Materiale");
		
		Label label = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(-18, 109, 281, 2);
		
		Label label_1 = new Label(shlNegoziofico, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 279, 267, 2);
		
		Button btnRadioButton = new Button(shlNegoziofico, SWT.RADIO);
		btnRadioButton.setBounds(81, 79, 111, 15);
		btnRadioButton.setText("Tessera Fedelt\u00E0");
		
		text_2 = new Text(shlNegoziofico, SWT.BORDER);
		text_2.setBounds(10, 216, 105, 21);
		
		Label lblNewLabel = new Label(shlNegoziofico, SWT.NONE);
		lblNewLabel.setBounds(10, 195, 92, 15);
		lblNewLabel.setText("Codice Prodotto");
		
		Button btnSalva = new Button(shlNegoziofico, SWT.NONE);
		btnSalva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSalva.setBounds(10, 287, 105, 25);
		btnSalva.setText("Elimina Prodotto");
		
		Button btnNewButton = new Button(shlNegoziofico, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(345, 287, 80, 25);
		btnNewButton.setText("Salva Carrello");
		
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

	}
}
