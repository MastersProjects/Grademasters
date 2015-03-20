package ch.grademasters.exception;

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
 * PasswortError.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class PasswortError extends JDialog {

	private static final long serialVersionUID = 1L;

	//JPanel erstellen
	protected JPanel error = new JPanel(new CardLayout());
	protected JPanel errorCard = new JPanel(new FlowLayout());

	//Buttons
	private final Icon errorImg = GradeMastersView.loadIcon("cancel.png");
	protected final JLabel errorImgButton = new JLabel(errorImg);
	protected final JButton ok = new JButton("Ok");

	//Jlabel
	protected JLabel sqlErrorLabel = new JLabel("Bitte Passwort eingeben");

	//Passwort error Field
	public PasswortError() {

		//Eigenschaften definieren
		setSize(200, 135);
		setVisible(true);
		setResizable(false);

		//hinzufuegen
		errorCard.add(errorImgButton, BorderLayout.NORTH);
		errorCard.add(sqlErrorLabel, BorderLayout.CENTER);
		errorCard.add(ok, BorderLayout.SOUTH);
		error.add(errorCard);

		this.add(error);

		//ActionListener erstellen
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//unsichtbar machen
				setVisible(false);
				//wegraumen
				dispose();
			}
		});

	}

}
