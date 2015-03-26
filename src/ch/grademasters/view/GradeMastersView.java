package ch.grademasters.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerDateModel;

import ch.grademasters.controller.GMController;
import ch.grademasters.listener.CardButtonListener;
import ch.grademasters.listener.FachSpeichernListener;
import ch.grademasters.listener.KlasseModelListener;
import ch.grademasters.listener.KlasseSpeichernListener;
import ch.grademasters.listener.NoteSpeichernListener;
import ch.grademasters.listener.StartCardFachListener;
import ch.grademasters.listener.StartCardKlasseListener;

/**
 * @description Das ganze GUI befindet sich in dieser Klasse
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * GradeMastersView.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class GradeMastersView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Vector<?> klasseModel = GMController.getInstance().getKlasse();
	Vector<?> fachModel = GMController.getInstance().getFachByID(1);

	
	/*
	 * CARDS
	 */
	protected JPanel cards = new JPanel(new CardLayout());

	protected JPanel startCard = new JPanel(new BorderLayout());
	protected JPanel addKlasseCard = new JPanel(new BorderLayout());
	protected JPanel addFachCard = new JPanel(new BorderLayout());
	protected JPanel addNoteCard = new JPanel(new BorderLayout());
	
	/*
	 * PANELS
	 */
	//startCard
//	protected JPanel startTop = new JPanel(new BorderLayout());
//	protected JPanel startBottom = new JPanel(new BorderLayout());
//	protected JPanel startTopLeft = new JPanel(new BorderLayout());
//	protected JPanel startTopRight = new JPanel(new BorderLayout());
//	protected JPanel startBottomLeft = new JPanel(new BorderLayout());
//	protected JPanel startBottomRight = new JPanel(new BorderLayout());
	protected JPanel startCenter = new JPanel(new GridLayout(2,2));
	protected JPanel klassePanel = new JPanel(new BorderLayout());
	protected JPanel klasseInfoPanel = new JPanel(new BorderLayout());
	protected JPanel fachPanel = new JPanel(new BorderLayout());
	protected JPanel startNotePanel = new JPanel(new BorderLayout());
	
	//addKlasseCard
	protected JPanel klasseFormular = new JPanel(new FlowLayout());
	protected JPanel lehrerFormular = new JPanel(new FlowLayout());
	protected JPanel klasseNamePanel = new JPanel(new GridLayout(2,1));
	protected JPanel schuleNamePanel = new JPanel(new GridLayout(2,1));
	protected JPanel semesterPanel = new JPanel(new GridLayout(2,1));
	protected JPanel lehrerVornamePanel = new JPanel(new GridLayout(2,1));
	protected JPanel lehrerNachnamePanel = new JPanel(new GridLayout(2,1));
	protected JPanel lehrerEmailPanel = new JPanel(new GridLayout(2,1));
	
	//addFachCard
	protected JPanel fachFormular = new JPanel(new FlowLayout());
	protected JPanel fachNamePanel = new JPanel(new GridLayout(2,1));
	protected JPanel addFachklasseListePanel = new JPanel(new GridLayout(2,1));
	
	//addNoteCard
	protected JPanel addNoteFormular = new JPanel(new FlowLayout());
	protected JPanel notePanel = new JPanel(new GridLayout(2,1));
	protected JPanel gewichtungPanel = new JPanel(new GridLayout(2,1));
	protected JPanel addNoteKlasseListePanel = new JPanel(new GridLayout(2,1));
	protected JPanel addNoteFachListePanel = new JPanel(new GridLayout(2,1));
	protected JPanel benennungPanel = new JPanel(new GridLayout(2,1));
	protected JPanel datumPanel = new JPanel(new GridLayout(2,1));
		
	/*
	 * TOOLBARS
	 */
	//startCard 
	protected final JToolBar startToolBar = new JToolBar();
	
	//addKlasseCard 
	protected final JToolBar addKlasseToolBar = new JToolBar();
	
	//addFachCard
	protected final JToolBar addFachToolBar = new JToolBar();
	
	//addNoteCard
	protected final JToolBar addNoteToolBar = new JToolBar();
	
	/*
	 * ICONS
	 */
	private static final Icon addNoteIconLarge = loadIcon("add.png");
	private static final Icon addKlasseIconLarge = loadIcon("klasse.png");
	private static final Icon addFachIconLarge = loadIcon("fach.png");
	private static final Icon addZeugnisIconLarge = loadIcon("zeugnis.png");
	private static final Icon addDiagrammIconLarge = loadIcon("diagramm.png");
	private static final Icon speichernIconLarge = loadIcon("zeugnis.png");
	private static final Icon verlassenIconLarge = loadIcon("verlassen.png");
	
	
	/*
	 * BUTTONS
	 */
	//startToolbar	
	protected final JButton addNote = new JButton("Note hinzufügen",addNoteIconLarge);	
	protected final JButton addKlasse = new JButton("Klasse hinzufügen",addKlasseIconLarge);	
	protected final JButton addFach = new JButton("Fach hinzufügen",addFachIconLarge);	
	protected final JButton addZeugnis = new JButton("Zeugnis erstellen",addZeugnisIconLarge);	
	protected final JButton addDiagramm = new JButton("Diagramm erstellen",addDiagrammIconLarge);

	//addKlasseToolBar	
	protected final JButton klasseSpeichern = new JButton("Klasse speichern",speichernIconLarge);
	protected final JButton klasseVerlassen = new JButton("Verlassen",verlassenIconLarge);
	
	//addFachToolBar
	protected final JButton fachSpeichern = new JButton("Fach speichern",speichernIconLarge);
	protected final JButton fachVerlassen = new JButton("Verlassen",verlassenIconLarge);
	
	//addNoteToolBar
	protected final JButton noteSpeichern = new JButton("Note speichern",speichernIconLarge);
	protected final JButton noteVerlassen = new JButton("Verlassen",verlassenIconLarge);
		
	/*
	 * TEXTFIELDS
	 */	
	//startCard
	protected JTextField klassenInfo = new JTextField("uabgfjkabfkabkfbhakfhnkasbfkasenfkeasnbkfnakdflnalk");
	
	//addKlasseCard
	protected JTextField klasseName = new JTextField();
	protected JTextField schuleName = new JTextField();
	protected JTextField semester = new JFormattedTextField(); 
	protected JTextField lehrerVorname = new JTextField();
	protected JTextField lehrerNachname = new JTextField();
	protected JTextField lehrerEmail = new JTextField();
	
	//addFachCard
	protected JTextField fachName = new JTextField();
	
	//addFachCard
	protected JTextField zeugnisName = new JTextField();
	
	//addNoteCard
	protected JTextField note = new JTextField();
	protected JTextField gewichtung = new JTextField();
	protected JTextField benennung = new JTextField(); 

	
	/*
	 * JLABELS
	 */
	//startCard
	protected JLabel startFachListeLabel = new JLabel("Fächer: ");
	protected JLabel startKlasseListeLabel = new JLabel("Bitte wähle deine Klasse aus: ");
	protected JLabel klassenInfoLabel = new JLabel("Klassen-Information: ");
	protected JLabel startNoteTableLabel = new JLabel("Noten: ");
	

	//addKlasseCard
	protected JLabel klasseNameLabel = new JLabel("Klasse: ");
	protected JLabel schuleNameLabel = new JLabel("Schule: ");
	protected JLabel semesterLabel = new JLabel("Semester: ");
	protected JLabel lehrerVornameLabel = new JLabel("Lehrer Vorname: ");
	protected JLabel lehrerNachnameLabel = new JLabel("Lehrer Nachname: ");
	protected JLabel lehrerEmailLabel = new JLabel("Lehrer E-mail: ");
	
	//addFachCard
	protected JLabel fachNameLabel = new JLabel("Fach: ");
	protected JLabel addFachKlasseListeLabel = new JLabel ("Klasse: ");
	
	//addNoteCard
	protected JLabel noteLabel = new JLabel ("Note: ");
	protected JLabel gewichtungLabel = new JLabel ("Gewichtung: ");
	protected JLabel addNoteKlasseListeLabel = new JLabel ("Klasse: ");
	protected JLabel addNoteFachListeLabel = new JLabel ("Fach: ");
	protected JLabel benennungLabel = new JLabel ("Benennung: ");
	protected JLabel datumSpinnerLabel = new JLabel ("Datum: ");
	
	
	/*
	 * TABLE
	 */
	//startCard
	protected JTable startNoteTable = new JTable();
	
	

	/*
	 * COMBOXES
	 */
	//startCard
	protected JComboBox<?> startKlasseListe = new JComboBox<>(klasseModel);
	protected JComboBox<?> startFachListe = new JComboBox<>(fachModel);
	
	//addFachCard
	protected JComboBox<?> addFachKlasseListe = new JComboBox<>(klasseModel);
	
	//addNoteCard
	protected JComboBox<?> addNoteKlasseListe = new JComboBox<>(klasseModel);
	protected JComboBox<?> addNoteFachListe = new JComboBox<>(fachModel);
	
	/*
	 * JSPINNER
	 */
	//addNoteCard
	Date today = new Date();
    JSpinner datumSpinner = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
    JSpinner.DateEditor datumformatiert = new JSpinner.DateEditor(datumSpinner, "dd/MM/yyyy");

	
	
	public GradeMastersView() {	
		
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setName("GradeMasters");
		setSize(800, 500);
		setVisible(true);
		
		/*
		 *startCard 
		 */
		//Toolbar
		startToolBar.setFloatable(false);
		startToolBar.add(addKlasse);
		startToolBar.add(addFach);
		startToolBar.add(addNote);
		startToolBar.add(addZeugnis);
		startToolBar.add(addDiagramm);

		//startTop
//		startTopLeft.add(startKlasseListeLabel, BorderLayout.NORTH);
//		startTopLeft.add(startKlasseListe, BorderLayout.CENTER);
//		
//		startTopRight.add(klassenInfoLabel, BorderLayout.NORTH);
//		startTopRight.add(klassenInfo, BorderLayout.CENTER);
//		startTopRight.setPreferredSize(new Dimension(500, 200));
//		
//		
//		startTop.add(startTopLeft, BorderLayout.WEST);
//		startTop.add(startTopRight, BorderLayout.CENTER);
//		startTop.setPreferredSize(new Dimension(800, 200));
//		
//		//startBottom
//		startBottomLeft.add(startFachListeLabel, BorderLayout.NORTH);
//		startBottomLeft.add(startFachListe, BorderLayout.CENTER);
//		
//		startBottomRight.add(startNoteTableLabel, BorderLayout.NORTH);
//		startBottomRight.add(startNoteTable, BorderLayout.CENTER);
//		startBottomRight.setPreferredSize(new Dimension(500, 200));
//		
//		startBottom.add(startBottomLeft, BorderLayout.WEST);
//		startBottom.add(startBottomRight, BorderLayout.CENTER);
//		startBottom.setPreferredSize(new Dimension(800, 200));
//		
//		//startCard
//		startCard.add(startToolBar, BorderLayout.NORTH);
//		startCard.add(startTop, BorderLayout.CENTER);
//		startCard.add(startBottom, BorderLayout.SOUTH);
		
		klassePanel.add(startKlasseListeLabel, BorderLayout.NORTH);
		klassePanel.add(startKlasseListe, BorderLayout.CENTER);
		
		klasseInfoPanel.add(klassenInfoLabel, BorderLayout.NORTH);
		klasseInfoPanel.add(klassenInfo, BorderLayout.CENTER);
		
		fachPanel.add(startFachListeLabel, BorderLayout.NORTH);
		fachPanel.add(startFachListe, BorderLayout.CENTER);
		
		startNotePanel.add(startNoteTableLabel, BorderLayout.NORTH);
		startNotePanel.add(startNoteTable, BorderLayout.CENTER);
		
		startCenter.add(klassePanel);
		startCenter.add(klasseInfoPanel);
		startCenter.add(fachPanel);
		startCenter.add(startNotePanel);

		startCard.add(startToolBar, BorderLayout.NORTH);
		startCard.add(startCenter, BorderLayout.CENTER);
		
		
		//Add in Cards
		cards.add(startCard, "Start Card");
				
//		//Colors for Test
//		startTopLeft.setBackground(Color.yellow);
//		startTopRight.setBackground(Color.red);
//		startBottomLeft.setBackground(Color.green);
//		startBottomRight.setBackground(Color.blue);
		
		
		/*
		 * addKlasseCard
		 */
		//Toolbar
		addKlasseToolBar.setFloatable(false);
		addKlasseToolBar.add(klasseVerlassen);
		addKlasseToolBar.add(klasseSpeichern);
		
		//klassenFormular				
		klasseNamePanel.add(klasseNameLabel);
		klasseNamePanel.add(klasseName);
		klasseNamePanel.setPreferredSize(new Dimension(140,40));
		
		schuleNamePanel.add(schuleNameLabel);
		schuleNamePanel.add(schuleName);
		schuleNamePanel.setPreferredSize(new Dimension(140,40));
		
		semesterPanel.add(semesterLabel);
		semesterPanel.add(semester);
		semesterPanel.setPreferredSize(new Dimension(140,40));
		
		klasseFormular.add(klasseNamePanel);
		klasseFormular.add(schuleNamePanel);
		klasseFormular.add(semesterPanel);
				
		//lehrerFormular
		lehrerVornamePanel.add(lehrerVornameLabel);
		lehrerVornamePanel.add(lehrerVorname);
		lehrerVornamePanel.setPreferredSize(new Dimension(140,40));
		
		lehrerNachnamePanel.add(lehrerNachnameLabel);
		lehrerNachnamePanel.add(lehrerNachname);
		lehrerNachnamePanel.setPreferredSize(new Dimension(140,40));
		
		lehrerEmailPanel.add(lehrerEmailLabel);
		lehrerEmailPanel.add(lehrerEmail);	
		lehrerEmailPanel.setPreferredSize(new Dimension(140,40));
		
		lehrerFormular.add(lehrerVornamePanel);
		lehrerFormular.add(lehrerNachnamePanel);
		lehrerFormular.add(lehrerEmailPanel);
		lehrerFormular.setPreferredSize(new Dimension(800, 200));
		
		//Alle ins addKlasseCard
		addKlasseCard.add(addKlasseToolBar, BorderLayout.NORTH);
		addKlasseCard.add(klasseFormular, BorderLayout.CENTER);
		addKlasseCard.add(lehrerFormular, BorderLayout.SOUTH);
		
		
		//Add in Cards
		cards.add(addKlasseCard, "Add Klasse Card");
		
		//Colors for Test
		addKlasseToolBar.setBackground(Color.yellow);
		klasseFormular.setBackground(Color.blue);
		lehrerFormular.setBackground(Color.red);
		
		
		/*
		 * addFachCard
		 */
		//Toolbar
		addFachToolBar.setFloatable(false);
		addFachToolBar.add(fachVerlassen);
		addFachToolBar.add(fachSpeichern);
				
		//fachFormular
		fachNamePanel.add(fachNameLabel);
		fachNamePanel.add(fachName);
		fachNamePanel.setPreferredSize(new Dimension(140,40));
		
		addFachklasseListePanel.add(addFachKlasseListeLabel);
		addFachklasseListePanel.add(addFachKlasseListe);
		addFachklasseListePanel.setPreferredSize(new Dimension(140,40));
				
		fachFormular.add(fachNamePanel);
		fachFormular.add(addFachklasseListePanel);
		
		
		//addFachCard
		addFachCard.add(addFachToolBar, BorderLayout.NORTH);
		addFachCard.add(fachFormular, BorderLayout.CENTER);
		
		//Add in Card
		cards.add(addFachCard, "Add Fach Card");
		
		
		/*
		 * addNoteCard
		 */
		//Toolbar
		addNoteToolBar.setFloatable(false);
		addNoteToolBar.add(noteVerlassen);
		addNoteToolBar.add(noteSpeichern);
		
		//notePanel
		notePanel.add(noteLabel);
		notePanel.add(note);		
		notePanel.setPreferredSize(new Dimension(90,40));
		
		//gewichtungPanel
		gewichtungPanel.add(gewichtungLabel);
		gewichtungPanel.add(gewichtung);
		gewichtungPanel.setPreferredSize(new Dimension(90,40));
				
		//addKlasseListePanel
		addNoteKlasseListePanel.add(addNoteKlasseListeLabel);
		addNoteKlasseListePanel.add(addNoteKlasseListe);
		addNoteKlasseListePanel.setPreferredSize(new Dimension(140,40));
		
		//addFachListePanel
		addNoteFachListePanel.add(addNoteFachListeLabel);
//		addNoteFachListe = new JComboBox<>(fachModel);
		addNoteFachListePanel.add(addNoteFachListe);
		addNoteFachListePanel.setPreferredSize(new Dimension(90,40));
		
		//benennungPanel
		benennungPanel.add(benennungLabel);
		benennungPanel.add(benennung);
		benennungPanel.setPreferredSize(new Dimension(90,40));
		
		//datumPanel
		datumSpinner.setEditor(datumformatiert);
		datumPanel.add(datumSpinnerLabel);
		datumPanel.add(datumSpinner);
		datumPanel.setPreferredSize(new Dimension(90,40));
		
		//addNoteFormular
		addNoteFormular.add(notePanel);
		addNoteFormular.add(gewichtungPanel);		
		addNoteFormular.add(addNoteKlasseListePanel);
		addNoteFormular.add(addNoteFachListePanel);
		addNoteFormular.add(benennungPanel);
		addNoteFormular.add(datumPanel);
	
		//addNoteCard
		addNoteCard.add(addNoteToolBar, BorderLayout.NORTH);
		addNoteCard.add(addNoteFormular, BorderLayout.CENTER);
		
		//Add in Card
		cards.add(addNoteCard, "Add Note Card");
				
		/*
		 * CardLayout zu Frame adden
		 */
		this.add(cards);
		
		
		/*
		 * BUTTON COMMANDS
		 */
		//Cards wechseln
		addKlasse.addActionListener(new CardButtonListener(cards));
		addFach.addActionListener(new CardButtonListener(cards));
		addNote.addActionListener(new CardButtonListener(cards));
		klasseVerlassen.addActionListener(new CardButtonListener(cards));
		fachVerlassen.addActionListener(new CardButtonListener(cards));
		noteVerlassen.addActionListener(new CardButtonListener(cards));
		addDiagramm.addActionListener(new CardButtonListener(cards));
		addZeugnis.addActionListener(new CardButtonListener(cards));
		
		/*
		 * SPEICHERN
		 */
		//klasseSpeichern
		klasseSpeichern.addActionListener(new KlasseSpeichernListener(klasseName, schuleName, 
																semester, lehrerVorname, 
																lehrerNachname, lehrerEmail));
		
		//fachSpeichern
		fachSpeichern.addActionListener(new FachSpeichernListener(fachName, addFachKlasseListe));
		
		//noteSpeichern
		noteSpeichern.addActionListener(new NoteSpeichernListener(note, gewichtung, benennung, addNoteFachListe));
		
		/*
		 * EVENTS
		 */
		//addNoteCard je nach klasse andere fächer
		addNoteKlasseListe.addActionListener(new KlasseModelListener(addNoteKlasseListe, addNoteFachListe));
		
		//startCard je nach klasse andere fächer
		startKlasseListe.addActionListener(new StartCardKlasseListener(startKlasseListe, startFachListe));		
		//startCard je nach fach andere pruefungen anzeigen
		startFachListe.addActionListener(new StartCardFachListener(startFachListe, startNoteTable));
		
	}
	

	
	/**
	 * Lädt das Bild
	 * 
	 * @param iconName
	 *            Name of the icon to load
	 * @return The icon.
	 */
	public static Icon loadIcon(String iconName) {
		final URL resource = GradeMastersView.class.getResource("/images/"
				+ iconName);
	
		if (resource == null) {
			System.err.println("Error in " + GradeMastersView.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}
	
}
