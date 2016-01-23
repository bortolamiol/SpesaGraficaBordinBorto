package ProgettoGrafica;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import ProgettoGrafica.gianpaolobordin.*;
public class GraficaProva {

	protected Shell shell;

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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setEnabled(false);
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnAggiungi = new Button(shell, SWT.NONE);
		btnAggiungi.setEnabled(false);
		btnAggiungi.setBounds(332, 87, 90, 30);
		btnAggiungi.setText("aggiungi");

	}
}
