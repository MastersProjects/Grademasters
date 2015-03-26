package ch.grademasters.messages;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;
import ch.grademasters.pdf.ZeugnisPdf;
import ch.grademasters.view.GradeMastersView;

/**
 * @description Exceptionklasse wenn keine VErbindung zur Datenbank besteht.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * UserError.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class CreateZeugnis extends JDialog {
	
	Vector<?> klasseModel = GMController.getInstance().getKlasse();
	protected JComboBox<?> startKlasseListe = new JComboBox<>(klasseModel);
	
	

	private static final long serialVersionUID = 1L;
	
	//JPanel 
	protected JPanel createZeugnis = new JPanel(new CardLayout());
	protected JPanel createZeugnisCard = new JPanel(new FlowLayout());

	//Buttons
	protected final Icon exportImg = GradeMastersView.loadIcon("pdf.png");
	protected final JLabel exportPdf = new JLabel(exportImg);
	protected final JButton exportButton = new JButton("Exportieren");

	//JLabel
	protected JLabel sucessText = new JLabel(
			"Bitte wählen Sie die Klasse aus:");

	//User Success Field
	public CreateZeugnis() {

		//Eigenschaften definieren
		setSize(240, 150);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		//hinzufuegen
		createZeugnisCard.add(exportPdf, BorderLayout.NORTH);
		createZeugnisCard.add(sucessText, BorderLayout.CENTER);
		createZeugnisCard.add(startKlasseListe, BorderLayout.CENTER);
		createZeugnisCard.add(exportButton, BorderLayout.SOUTH);
		createZeugnis.add(createZeugnisCard);
		

		this.add(createZeugnis);

		//ActionListener hinzufuegen
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Item item = (Item)startKlasseListe.getSelectedItem();
			      int klasse_ID = item.getId();
			      new ZeugnisPdf(klasse_ID);
			      
			}
		});

	}

}
