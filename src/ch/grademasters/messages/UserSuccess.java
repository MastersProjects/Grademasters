package ch.grademasters.messages;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.grademasters.view.GradeMastersView;

/**
 * @description Exceptionklasse wenn keine VErbindung zur Datenbank besteht.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * UserError.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class UserSuccess extends JDialog {

	private static final long serialVersionUID = 1L;
	
	//JPanel 
	protected JPanel error = new JPanel(new CardLayout());
	protected JPanel errorCard = new JPanel(new FlowLayout());

	//Buttons
	protected final Icon userAddImg = GradeMastersView.loadIcon("vcard_add.png");
	protected final JLabel userAddImageButton = new JLabel(userAddImg);
	protected final JButton ok = new JButton("Ok");

	//JLabel
	protected JLabel sucessText = new JLabel(
			"Sie wurden erfolgreich registriert!");

	//User Success Field
	public UserSuccess() {

		//Eigenschaften definieren
		setSize(240, 150);
		setVisible(true);
		setResizable(false);
		//hinzufuegen
		errorCard.add(userAddImageButton, BorderLayout.NORTH);
		errorCard.add(sucessText, BorderLayout.CENTER);
		errorCard.add(ok, BorderLayout.SOUTH);
		error.add(errorCard);

		this.add(error);

		//ActionListener hinzufuegen
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

	}

}
