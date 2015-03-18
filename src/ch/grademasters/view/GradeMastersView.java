package ch.grademasters.view;

/**
 * @description GUI 
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file GradeMastersView.java 
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import ch.grademasters.listener.ButtonListener;
import ch.grademasters.model.Fach;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.KlassenLehrer;
import ch.grademasters.model.Pruefung;

public class GradeMastersView extends JFrame {

	private static final long serialVersionUID = 1L;

	// HAUPT PANELS
	protected JPanel card = new JPanel(new CardLayout());

	protected JPanel startCard = new JPanel();
	protected JPanel addKlasseCard = new JPanel();
	protected JPanel addFachCard = new JPanel();
	protected JPanel addNoteCard = new JPanel();

	/*
	 * startPanel
	 */
	// Toolbar
	protected final JToolBar mainToolBar = new JToolBar();

	// Scrollfield
	JScrollPane scrollpaneKlasse;
	JScrollPane scrollpaneFach;
	JScrollPane scrollpaneNote;

	// GridLayout |Links| erstellen
	protected JPanel klasseGrid = new JPanel(new GridLayout(4, 1));

	// GridLayout |CENTER| erstellen
	protected JPanel noteGrid = new JPanel(new GridLayout(4, 1));

	// Bilder & Button fuer Toolbar laden
	private static final Icon addNoteIconLarge = loadIcon("add.png");
	protected final JButton addNote = new JButton("Note hinzufügen",addNoteIconLarge);

	private static final Icon addKlasseIconLarge = loadIcon("klasse.png");
	protected final JButton addKlasse = new JButton("Klasse hinzufügen",addKlasseIconLarge);

	private static final Icon addFachIconLarge = loadIcon("fach.png");
	protected final JButton addFach = new JButton("Fach hinzufügen",addFachIconLarge);

	private static final Icon addZeugnisIconLarge = loadIcon("zeugnis.png");
	protected final JButton addZeugnis = new JButton("Zeugnis erstellen",addZeugnisIconLarge);

	private static final Icon addDiagrammIconLarge = loadIcon("diagramm.png");
	protected final JButton addDiagramm = new JButton("Diagramm erstellen",addDiagrammIconLarge);

	private static final Icon addNoteIconLittle = loadIcon("add_little.png");
	protected final JButton addNoteLittle = new JButton("Note hinzufügen",addNoteIconLittle);

	/*
	 * addKlassePanel
	 */
	// Toolbar
	protected final JToolBar klasseToolBar = new JToolBar();

	// Formular
	protected JPanel klasseFormular = new JPanel(new GridLayout(3, 1));
	protected JPanel lehrerFormular = new JPanel(new GridLayout(3, 1));

	// Bilder & Button fuer Toolbar laden
	// Verlassen
	private static final Icon verlassenIconLarge = GradeMastersView
			.loadIcon("verlassen.png");
	protected final JButton verlassen = new JButton("Verlassen",
			verlassenIconLarge);

	// Speichern
	private static final Icon speichernIconLarge = GradeMastersView
			.loadIcon("speichern.png");
	protected final JButton speichern = new JButton("Speichern",
			speichernIconLarge);

	// TextField fuer erfassen der Klasse
	private JTextField klasseName = new JTextField();
	private JTextField schuleName = new JTextField();
	private JTextField semester = new JFormattedTextField(
	/* new MaskFormatter("##.##.####") */); // Nur Zahlen sind gültige eingabe

	// TextField fuer erfassen von Lehrer
	private JTextField lehrerVorname = new JTextField();
	private JTextField lehrerNachname = new JTextField();
	private JTextField lehrerEmail = new JTextField();

	/*
	 * AddFachPanel
	 */
	// Toolbar
	protected final JToolBar fachToolBar = new JToolBar();

	// Formular
	protected JPanel fachFormular = new JPanel(new GridLayout(1, 2));

	// TextField fuer erfassen der Faecher
	private JTextField fachName = new JTextField();
	private JComboBox schuleListe = new JComboBox();

	/*
	 * AddFachPanel
	 */
	
	//Formular
	protected JPanel addNoteFormular = new JPanel(new GridLayout(5,2));
	
	//Texfelder fuer eintragen der Note
	protected JTextField note = new JTextField();
	protected JTextField durchschnitt = new JTextField();
	protected JTextArea beschreibung = new JTextArea(); 
	
	
	
	public GradeMastersView() {

		/*
		 * startPanel
		 */
		mainToolBar.setFloatable(false);

		setTitle("GradeMasters");

		// Add buttons to maintoolbar
		addKlasse.setToolTipText("Klasse hinzufügen");
		mainToolBar.add(addKlasse);

		addFach.setToolTipText("Fach hinzufügen");
		mainToolBar.add(addFach);

		addNote.setToolTipText("Note hinzufügen");
		mainToolBar.add(addNote);

		addZeugnis.setToolTipText("Zeugnis erstellen");
		mainToolBar.add(addZeugnis);

		addDiagramm.setToolTipText("Diagramm erstellen");
		mainToolBar.add(addDiagramm);

		// Toolbar ins Fenster
		startCard.add(mainToolBar, BorderLayout.NORTH);

		/* ######## SCROLLFIELD & SCROLLBAR ######## */

		// Lehrer erstellen
		KlassenLehrer lehrer = new KlassenLehrer("Guenther", "Schneider",
				"Guenter.Schneider@Access.tbz");
		Klasse klasse = new Klasse(lehrer, "AP14a", "TBZ", 2);
		// Erstes Beispiel
		Fach mathe = new Fach("Mathe");

		klasse.getZeugnis().addFach(mathe);
		Pruefung pruefung1 = new Pruefung("Gleichungen", 6f, 1f);
		Pruefung pruefung2 = new Pruefung("Eins mal Eins", 5.76f, 0.5f);
		mathe.addPruefung(pruefung1);
		mathe.addPruefung(pruefung2);

		// Zweites Beispiel
		Fach deutsch = new Fach("Deutsch");

		klasse.getZeugnis().addFach(deutsch);
		Pruefung pruefung3 = new Pruefung("Gramatik", 4.25f, 1f);
		Pruefung pruefung4 = new Pruefung("Nomen", 5.25f, 0.5f);
		Pruefung pruefung5 = new Pruefung("Verben", 4.8f, 0.5f);
		deutsch.addPruefung(pruefung3);
		deutsch.addPruefung(pruefung4);
		deutsch.addPruefung(pruefung5);

		// Text Fach
		JLabel fachLabel = new JLabel("Bitte wähle dein Fach aus: ");

		// Text Fach
		JLabel klasseLabel = new JLabel("Bitte wähle deine Klasse aus: ");

		// Text Klasse
		klasseGrid.add(klasseLabel);

		// Scrollbar 1
		String schulKlasse[] = { "Klasse: " + klasse.getKlassenname() + "  |  "
				+ "Semester: " + klasse.getSemester() + "  |  " + "Schule: "
				+ klasse.getSchule() };

		JList<?> list = new JList<Object>(schulKlasse);
		scrollpaneKlasse = new JScrollPane(list);

		// Scroll Panel hinzufügen
		klasseGrid.add(scrollpaneKlasse);

		klasseGrid.add(fachLabel);

		// Scrollbar 2
		String faecher[] = { "Mathe", "Englisch", "Französisch", "Deutsch",
				"Sport" };

		JList<?> list2 = new JList<Object>(faecher);
		scrollpaneFach = new JScrollPane(list2);

		// Scroll Panel hinzufügen
		klasseGrid.add(scrollpaneFach);

		// KlassenGrid dem Borderlayout hinzufuegen (muss nur 1 Mal passieren)
		startCard.add(klasseGrid, BorderLayout.WEST);

		// Textfield 3 | Right

		// Text Fach
		JLabel klassenInfoDarstellen = new JLabel("Klassen-Information: ");

		// Beschreibung hinzufuegen
		noteGrid.add(klassenInfoDarstellen);

		JTextField klassenInfo = new JTextField("Kürzel: AP14a" + "\n "
				+ "Semester: 2 \n" + "Lehrer: Günther Access \n", 20);
		klassenInfo.setEditable(false);

		// Textfield hinzufuegen
		noteGrid.add(klassenInfo);

		// NoteGrid dem Borderlayout hinzufuegen (muss nur 1 Mal passieren)
		startCard.add(noteGrid, BorderLayout.CENTER);

		// Button hinzufuegen
		addNoteLittle.setToolTipText("Note hinzufügen");
		noteGrid.add(addNoteLittle);

		// Scrollbar 3 | Right
		String notenListe[] = { "Ein mal Eins: 5", "Brüche: 4.5", "Runden: 5.5" };

		JList<?> list3 = new JList<Object>(notenListe);
		scrollpaneNote = new JScrollPane(list3);

		// ScrollField hinzufuegen
		noteGrid.add(scrollpaneNote);

		

		/*
		 * addKlassePanel
		 */
		klasseToolBar.setFloatable(false);

		// Buttons fuer Toolbar
		verlassen.setToolTipText("Achtung Informationen werden nicht gespeichert");
		klasseToolBar.add(verlassen);

		speichern.setToolTipText("Klasse wird hinzugefuegt");
		klasseToolBar.add(speichern);
		

		// Textfield fuer Klasse hinzufuegen
		this.klasseName.setText("Klassen Name");
		klasseFormular.add(this.klasseName);
		this.schuleName.setText("Schule");
		klasseFormular.add(this.schuleName);
		this.semester.setText("Semester");
		klasseFormular.add(this.semester);

		// Texfield fuer Lehrer hinzufuegen
		this.lehrerNachname.setText("Lehrer Nachname");
		lehrerFormular.add(this.lehrerNachname);
		this.lehrerVorname.setText("Lehrer Vorname");
		lehrerFormular.add(this.lehrerVorname);
		this.lehrerEmail.setText("Lehrer Email");
		lehrerFormular.add(this.lehrerEmail);

		// Toolbar ins Fenster
		
		addKlasseCard.add(klasseToolBar, BorderLayout.NORTH);

		// Textfelder ins Fenster
		addKlasseCard.add(klasseFormular, BorderLayout.WEST);
		addKlasseCard.add(lehrerFormular, BorderLayout.EAST);

		

		/*
		 * AddFachPanel
		 */
		fachToolBar.setFloatable(false);

		fachToolBar.add(verlassen);

		fachToolBar.add(speichern);

		// Textfield fuer Fach hinzufuegen
		this.fachName.setText("Fach Name");
		fachFormular.add(this.fachName);

		// Test Wert hinzufuegen
		schuleListe.addItem("TEST");
		fachFormular.add(this.schuleListe);

		addFachCard.add(fachToolBar, BorderLayout.NORTH);

		// Textfelder ins Fenster
		addFachCard.add(fachFormular, BorderLayout.WEST);

		/*
		 * panels zu card hinzufügen
		 */
		startCard.setBackground(Color.yellow);
		addKlasseCard.setBackground(Color.yellow);
		addFachCard.setBackground(Color.yellow);
		card.add(startCard, "Start Panel");
		card.add(addKlasseCard, "Add Klasse Panel");
		card.add(addFachCard, "Add Fach Panel");
		card.add(addNoteCard, "Add Note Panel");

		addKlasse.addActionListener(new ButtonListener(card));
		addFach.addActionListener(new ButtonListener(card));
		addNote.addActionListener(new ButtonListener(card));
		verlassen.addActionListener(new ButtonListener(card));
		addNoteLittle.addActionListener(new ButtonListener(card));

		this.add(card);

	}

	/**
	 * Loads an icon from the resource folder images.
	 * 
	 * @param iconName
	 *            Name of the icon to load
	 * @return The icon.
	 */
	static Icon loadIcon(String iconName) {
		final URL resource = GradeMastersView.class.getResource("/images/"
				+ iconName);

		if (resource == null) {
			System.err.println("Error in " + GradeMastersView.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	public static void main(String[] args) {
		GradeMastersView gui = new GradeMastersView();
		gui.setSize(1000, 700);
		gui.setName("GradeMasters");
		gui.setVisible(true);
	}

}