package ch.grademasters.view;

/**
 * @description GUI 
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file GradeMastersView.java 
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import ch.grademasters.model.Klasse;
import ch.grademasters.model.KlassenLehrer;


public class GradeMastersView extends JFrame {

	// Toolbar
	protected final JToolBar mainToolBar = new JToolBar();

	// Scrollfield
	JScrollPane scrollpaneKlasse;
	JScrollPane scrollpaneFach;

	// GridLayout |Links| erstellen
	protected JPanel klasseGrid = new JPanel(new GridLayout(4, 1));

	// GridLayout |CENTER| erstellen
	protected JPanel NoteGrid = new JPanel(new GridLayout(2, 2));

	
	// Bilder & Button fuer Toolbar laden
	private static final Icon addNoteIconLarge = loadIcon("add.png");
	protected final JButton addNote = new JButton("Note hinzufügen",
			addNoteIconLarge);

	private static final Icon addKlasseIconLarge = loadIcon("klasse.png");
	protected final JButton addKlasse = new JButton("Klasse hinzufügen",
			addKlasseIconLarge);
	
	private static final Icon addFachIconLarge = loadIcon("fach.png");
	protected final JButton addFach = new JButton("Fach hinzufügen",
			addFachIconLarge);

	private static final Icon addZeugnisIconLarge = loadIcon("zeugnis.png");
	protected final JButton addZeugnis = new JButton("Zeugnis erstellen",
			addZeugnisIconLarge);

	private static final Icon addDiagrammIconLarge = loadIcon("diagramm.png");
	protected final JButton addDiagramm = new JButton("Diagramm erstellen",
			addDiagrammIconLarge);

	public GradeMastersView() {

		mainToolBar.setFloatable(false);

		setTitle("GradeMasters");

		// Add buttons to tool bar
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
		add(mainToolBar, BorderLayout.NORTH);

		
		/* ######## SCROLLFIELD & SCROLLBAR ######## */
		
		//Lehrer erstellen
		KlassenLehrer lehrer = new KlassenLehrer("Guenther", "Schneider", "Guenter.Schneider@Access.tbz");
		Klasse klasse = new Klasse(lehrer, "AP14a", "TBZ", 2);
		
		// Text Fach
				JLabel fachLabel = new JLabel("Bitte wähle dein Fach aus: ");
				
		// Text Fach
		JLabel klasseLabel = new JLabel("Bitte wähle deine Klasse aus: ");
		
		// Text Klasse
		klasseGrid.add(klasseLabel);
		
		// Scrollbar 1
		Object schulKlasse[] = { klasse };

		JList<?> list = new JList<Object>(schulKlasse);
		scrollpaneKlasse = new JScrollPane(list);

		// Scroll Panel hinzufügen
		klasseGrid.add(scrollpaneKlasse);

		klasseGrid.add(fachLabel);
				
		// Scrollbar 2
		String faecher[] = { "Mathe", "Deutsch", "Französisch",
				"Englisch" };

		JList<?> list2 = new JList<Object>(faecher);
		scrollpaneFach = new JScrollPane(list2);

		// Scroll Panel hinzufügen
		klasseGrid.add(scrollpaneFach);

		// KlassenGrid dem Borderlayout hinzufuegen
		add(klasseGrid, BorderLayout.WEST);

	}

	/**
	 * Loads an icon from the resource folder images.
	 * 
	 * @param iconName
	 *            Name of the icon to load
	 * @return The icon.
	 */
	private static Icon loadIcon(String iconName) {
		final URL resource = GradeMastersView.class.getResource("/images/"
				+ iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println("Error in " + GradeMastersView.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	public static void main(String[] args) {
		GradeMastersView gui = new GradeMastersView();
		gui.setSize(1000, 600);
		gui.setVisible(true);
	}

}