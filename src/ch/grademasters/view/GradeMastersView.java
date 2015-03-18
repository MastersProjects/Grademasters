package ch.grademasters.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import ch.grademasters.model.Zeugnis;

public class GradeMastersView extends JFrame {

	private static final long serialVersionUID = 1L;

	
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
	protected JPanel startCenter = new JPanel(new BorderLayout());
	protected JPanel startLeft = new JPanel(new BorderLayout());
	protected JPanel startRight = new JPanel(new BorderLayout());
	protected JPanel startLeftTop = new JPanel(new BorderLayout());
	protected JPanel startLeftBottom = new JPanel(new BorderLayout());
	protected JPanel startRightTop = new JPanel(new BorderLayout());
	protected JPanel startRightBottom = new JPanel(new BorderLayout());
	
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
	protected JPanel fachFormular = new JPanel(new GridLayout(1, 2));
	
	//addNoteCard
	protected JPanel addNoteFormular = new JPanel(new GridLayout(5,2));
	
	
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
	private static final Icon speichernIconLarge = loadIcon("speichern.png");
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
	
	//addFachToolBar
	protected final JButton fachSpeichern = new JButton("Fach speichern",speichernIconLarge);
	
	//addNoteToolBar
	protected final JButton noteSpeichern = new JButton("Note speichern",speichernIconLarge);
	
	//verlassen
	protected final JButton verlassen = new JButton("Verlassen",verlassenIconLarge);
	
	
	/*
	 * TEXTFIELDS
	 */
	
	//addKlasseCard
	protected JTextField klasseName = new JTextField();
	protected JTextField schuleName = new JTextField();
	protected JTextField semester = new JFormattedTextField(); 
	protected JTextField lehrerVorname = new JTextField();
	protected JTextField lehrerNachname = new JTextField();
	protected JTextField lehrerEmail = new JTextField();
	
	//addFachCard
	protected JTextField fachName = new JTextField();
	
	//addNoteCard
	protected JTextField note = new JTextField();
	protected JTextField durchschnitt = new JTextField();
	
	
	/*
	 * JLABELS
	 */
	//startCard
	protected JLabel scrollpaneFachLabel = new JLabel("Bitte wähle dein Fach aus: ");
	protected JLabel scrollpaneKlasseLabel = new JLabel("Bitte wähle deine Klasse aus: ");
	protected JLabel klassenInfoLabel = new JLabel("Klassen-Information: ");
	protected JLabel scrollpaneNoteLabel = new JLabel("Noten: ");
	protected JLabel klassenInfo = new JLabel();

	//addKlasseCard
	protected JLabel klasseNameLabel = new JLabel("KLasse Name: ");
	protected JLabel schuleNameLabel = new JLabel("Schul Name: ");
	protected JLabel semesterLabel = new JLabel("Semester: ");
	protected JLabel lehrerVornameLabel = new JLabel("Lehrer Vorname: ");
	protected JLabel lehrerNachnameLabel = new JLabel("Lehrer Nachname: ");
	protected JLabel lehrerEmailLabel = new JLabel("Lehrer E-mail: ");
	
	
	/*
	 * TEXTAREAS
	 */
	//addNoteCard
	protected JTextArea beschreibung = new JTextArea(); 
	
	
	/*
	 * SCROLLPANES
	 */
	//startCard
	protected JScrollPane scrollpaneKlasse = new JScrollPane();
	protected JScrollPane scrollpaneFach = new JScrollPane();
	protected JScrollPane scrollpaneNote = new JScrollPane();
	
	
	
	
	/*
	 * COMBOXES
	 */
	//addFachCard
	protected JComboBox schuleListe = new JComboBox();
	
	
	
	public GradeMastersView() {		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setName("GradeMasters");

		
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

		//Left startCenter
		startLeftTop.add(scrollpaneKlasseLabel, BorderLayout.NORTH);
		startLeftTop.add(scrollpaneKlasse, BorderLayout.CENTER);
		startLeftBottom.add(scrollpaneFachLabel, BorderLayout.NORTH);
		startLeftBottom.add(scrollpaneFach, BorderLayout.CENTER);
		
		startLeft.add(startLeftTop, BorderLayout.NORTH);
		startLeft.add(startLeftBottom, BorderLayout.CENTER);
		
		startCenter.add(startLeft, BorderLayout.WEST);
		
		//Right startCenter
		startRightTop.add(klassenInfoLabel, BorderLayout.NORTH);
		startRightTop.add(klassenInfo, BorderLayout.CENTER);
		startRightBottom.add(scrollpaneNoteLabel, BorderLayout.NORTH);
		startRightBottom.add(scrollpaneNote, BorderLayout.CENTER);
				
		startRight.add(startRightTop, BorderLayout.NORTH);
		startRight.add(startRightBottom, BorderLayout.CENTER);
		
		startCenter.add(startRight, BorderLayout.CENTER);
				
		//Alle Layout an stardCard
		startCard.add(startToolBar, BorderLayout.NORTH);
		startCard.add(startCenter, BorderLayout.CENTER);
		
		//Add in Cards
		cards.add(startCard, "Start Card");
				
		////Colors for Test
		//startLeftTop.setBackground(Color.yellow);
		//startLeftBottom.setBackground(Color.red);
		//startRightTop.setBackground(Color.green);
		//startRightBottom.setBackground(Color.blue);
		
		
		/*
		 * addKlasseCard
		 */
		//Toolbar
		addKlasseToolBar.setFloatable(false);
		addKlasseToolBar.add(verlassen);
		addKlasseToolBar.add(klasseSpeichern);
		
		//klassenFormular				
		klasseNamePanel.add(klasseNameLabel);
		klasseNamePanel.add(klasseName);
		
		schuleNamePanel.add(schuleNameLabel);
		schuleNamePanel.add(schuleName);
		
		semesterPanel.add(semesterLabel);
		semesterPanel.add(semester);
		
		klasseFormular.add(klasseNamePanel);
		klasseFormular.add(schuleNamePanel);
		klasseFormular.add(semesterPanel);
				
		//lehrerFormular
		lehrerVornamePanel.add(lehrerVornameLabel);
		lehrerVornamePanel.add(lehrerVorname);
		
		lehrerNachnamePanel.add(lehrerNachnameLabel);
		lehrerNachnamePanel.add(lehrerNachname);
		
		lehrerEmailPanel.add(lehrerEmailLabel);
		lehrerEmailPanel.add(lehrerEmail);	
		
		lehrerFormular.add(lehrerVornamePanel);
		lehrerFormular.add(lehrerNachnamePanel);
		lehrerFormular.add(lehrerEmailPanel);
		
		//Alle ins addKlasseCard
		addKlasseCard.add(addKlasseToolBar, BorderLayout.NORTH);
		addKlasseCard.add(klasseFormular, BorderLayout.CENTER);
		addKlasseCard.add(lehrerFormular, BorderLayout.SOUTH);
		
		
		//Add in Cards
		cards.add(addKlasseCard, "Add Klasse Card");
		
//		//Colors for Test
//		addKlasseToolBar.setBackground(Color.yellow);
//		klasseFormular.setBackground(Color.blue);
//		lehrerFormular.setBackground(Color.red);
		
				
		/*
		 * BUTTON COMMANDS
		 */
		addKlasse.addActionListener(new ButtonListener(cards));
		addFach.addActionListener(new ButtonListener(cards));
		addNote.addActionListener(new ButtonListener(cards));
		verlassen.addActionListener(new ButtonListener(cards));

		this.add(cards);
		
	}
	
	public static void main(String[] args) {
		GradeMastersView gui = new GradeMastersView();
		gui.setSize(760, 500);
		gui.setVisible(true);
	}
	
	
	
	
	/**
	 * Lädt das Bild
	 * 
	 * @param iconName
	 *            Name of the icon to load
	 * @return The icon.
	 */
	public static Icon loadIcon(String iconName) {
		final URL resource = GradeMastersViewAlt.class.getResource("/images/"
				+ iconName);
	
		if (resource == null) {
			System.err.println("Error in " + GradeMastersViewAlt.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}
}