package ch.grademasters.messages;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.grademasters.view.GradeMastersView;

/**
 * @description Exceptionklasse wenn keine VErbindung zur Datenbank besteht.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin UserError.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class ZeugnisSuccess extends JDialog {

	private static final long serialVersionUID = 1L;

	// JPanel
	protected JPanel error = new JPanel(new CardLayout());
	protected JPanel errorCard = new JPanel(new FlowLayout());

	// Buttons
	protected final Icon zeugnisErstelltImg = GradeMastersView
			.loadIcon("information.png");
	protected final JLabel zeugnisErstelltButton = new JLabel(
			zeugnisErstelltImg);
	protected final JButton openButton = new JButton("Ordner öffnen");

	// JLabel
	protected JLabel sucessText = new JLabel("Dein Zeugnis wurde erstellt!");

	// User Success Field
	public ZeugnisSuccess() {

		// Eigenschaften definieren
		setSize(240, 115);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		// hinzufuegen
		errorCard.add(zeugnisErstelltButton, BorderLayout.NORTH);
		errorCard.add(sucessText, BorderLayout.CENTER);
		errorCard.add(openButton, BorderLayout.SOUTH);
		error.add(errorCard);

		this.add(error);

		// ActionListener hinzufuegen
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(
							new File("C:/GradeMasters/Zeugnisse/").toURI());
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					setVisible(false);
					dispose();
				}

			}
		});

	}

}
