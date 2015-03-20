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
 * @description Exceptionklasse wenn keine Verbindung zur Datenbank besteht.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file LoginError.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class LoginError extends JDialog {

	private static final long serialVersionUID = 1L;

	protected JPanel error = new JPanel(new CardLayout());
	protected JPanel errorCard = new JPanel(new FlowLayout());

	// Buttons
	private final Icon errorImg = GradeMastersView.loadIcon("cancel.png");
	protected final JLabel errorImgButton = new JLabel(errorImg);
	protected final JButton ok = new JButton("Ok");

	// Jlabel
	protected JLabel sqlErrorLabel = new JLabel(
			"Benutzername und/oder Passwort stimmen nicht!");

	//Login Error Field
	public LoginError() {
		// Eigenschaften definieren
		setSize(300, 135);
		setVisible(true);
		setResizable(false);

		// Elemente hinzufuegen
		errorCard.add(errorImgButton, BorderLayout.NORTH);
		errorCard.add(sqlErrorLabel, BorderLayout.CENTER);
		errorCard.add(ok, BorderLayout.SOUTH);
		error.add(errorCard);
		this.add(error);

		// ActionListener erstellen
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// unsichtbar machen
				setVisible(false);
				//wegraumen
				dispose();
			}
		});
	}
}
