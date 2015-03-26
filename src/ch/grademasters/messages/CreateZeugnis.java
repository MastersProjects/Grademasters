package ch.grademasters.messages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ch.grademasters.controller.GMController;
import ch.grademasters.view.GradeMastersView;

public class CreateZeugnis extends JDialog {

	// Vektor
	Vector<?> klasseModel = GMController.getInstance().getKlasse();

	// JPanel
	protected JPanel addZeugnisCard = new JPanel(new BorderLayout());
	protected JPanel addZeugnisKlasseListePanel = new JPanel(new GridLayout(2,
			1));
	protected JPanel addZeugnisFormular = new JPanel(new FlowLayout());

	// JLabel
	protected JLabel addZeugnisKlasseListeLabel = new JLabel("Klasse: ");

	// Toolbar
	protected final JToolBar addZeugnisToolBar = new JToolBar();

	// Icons
	private static final Icon speichernIconLarge = GradeMastersView
			.loadIcon("zeugnis.png");
	private static final Icon verlassenIconLarge = GradeMastersView
			.loadIcon("verlassen.png");

	// JComboBox
	protected JComboBox<?> addZeugnisKlasseListe = new JComboBox<>(klasseModel);

	// JButton
	protected final JButton zeugnisSpeichern = new JButton("Zeugnis speichern",
			speichernIconLarge);
	protected final JButton zeugnisVerlassen = new JButton("Verlassen",
			verlassenIconLarge);

	private static final long serialVersionUID = 1L;

	public void CreatZeugnis() {
		/*
		 * addZeugnisCard
		 */
		// Eigenschaften definieren
		setSize(500, 350);
		setVisible(true);
		setResizable(false);

		// Toolbar
		addZeugnisToolBar.setFloatable(false);
		addZeugnisToolBar.add(zeugnisVerlassen);
		addZeugnisToolBar.add(zeugnisSpeichern);

		// addKlasseListePanel
		addZeugnisKlasseListePanel.add(addZeugnisKlasseListeLabel);
		addZeugnisKlasseListePanel.add(addZeugnisKlasseListe);
		addZeugnisKlasseListePanel.setPreferredSize(new Dimension(140, 40));

		// addZeugnisFormular
		addZeugnisFormular.add(addZeugnisKlasseListePanel);

		// addZeugnisCard
		addZeugnisCard.add(addZeugnisToolBar, BorderLayout.NORTH);
		addZeugnisCard.add(addZeugnisFormular, BorderLayout.CENTER);

	}

}
