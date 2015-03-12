package ch.grademasters.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class GradeMastersView extends JFrame {

	protected JMenuBar mainMenuBar = new JMenuBar();

	protected final JToolBar mainToolBar = new JToolBar();

	// Bilder laden
	protected static Icon noteLarge = loadIcon("add.png");
	protected static Icon fachLarge = loadIcon("fach.png");
	protected static Icon klasseLarge = loadIcon("klasse.png");
	protected static Icon zeugnisLarge = loadIcon("zeugnis.png");
	protected static Icon diagrammLarge = loadIcon("diagramm.png");

	// Bilder zu Button hinzufuegen
	protected final JButton addButton = new JButton(noteLarge);
	protected final JButton fachButton = new JButton(fachLarge);
	protected final JButton klasseButton = new JButton(klasseLarge);
	protected final JButton zeugnisButton = new JButton(zeugnisLarge);
	protected final JButton diagrammButton = new JButton(diagrammLarge);

	// Buttons hinzufuegen
	// mainToolBar.add(addButton);
	// mainToolBar.add(fachButton);
	// mainToolBar.add(klasseButton);
	// mainToolBar.add(printButton);
	// mainToolBar.add(exitButton);

	/**
	 * Laedt ein Bild aus dem Ordner images.
	 * 
	 * @param iconName
	 *            Name des Icons
	 * @return Das Icon.
	 */
	private static Icon loadIcon(String iconName) {
		final URL resource = GradeMastersView.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println("Error in " + GradeMastersView.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	public static void main(String[] args) {

	}

}
