package ch.grademasters.view;

/**
  * @description GUI fuer erstellen einer Klasse
  * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
  * @file KlasseView.java 
  * Copyright Berufsbildungscenter GradeMasters 2015
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.text.MaskFormatter;

public class KlasseView extends JFrame {

	private static final long serialVersionUID = 1L;

	// Toolbar
	protected final JToolBar klasseToolBar = new JToolBar();
	
	//Formular
	protected JPanel klasseFormular = new JPanel(new GridLayout(1, 3));

	// Bilder & Button fuer Toolbar laden
	//Verlassen
	private static final Icon verlassenIconLarge = GradeMastersView
			.loadIcon("verlassen.png");
	protected final JButton verlassen = new JButton(
			"Verlassen",
			verlassenIconLarge);
	
	//Speichern
	private static final Icon speichernIconLarge = GradeMastersView
			.loadIcon("speichern.png");
	protected final JButton speichern = new JButton("Speichern",
			speichernIconLarge);
	
	//TextField fuer erfassen der Klasse
	private JTextField klasseName = new JTextField();
	private JTextField schuleName = new JTextField();
	private JTextField semester = new JFormattedTextField(
	        /*new MaskFormatter("##.##.####")*/); //Nur Zahlen sind gültige eingabe
	
	/**
	 * @description Konstruktor der Klasse KlasseView
	 */
	public KlasseView() {

		klasseToolBar.setFloatable(false);

		// Buttons fuer Toolbar
		verlassen.setToolTipText("Achtung Informationen werden nicht gespeichert");
		klasseToolBar.add(verlassen);

		speichern.setToolTipText("Klasse wird hinzugefuegt");
		klasseToolBar.add(speichern);
		
		//Textfield fuer Klasse
		klasseName.setText("Klassen Name");
		klasseFormular.add(klasseName);
		schuleName.setText("Schule");
		klasseFormular.add(schuleName);
		semester.setText("Semester");
		klasseFormular.add(semester);
		
		// Toolbar ins Fenster
		add(klasseToolBar, BorderLayout.NORTH);
		
		//Textfelder ins Fenster
		add(klasseFormular, BorderLayout.WEST);
	}

	public static void main(String[] args) {
		KlasseView gui2 = new KlasseView();
		gui2.setSize(1000, 600);
		gui2.setVisible(true);
	}

}
