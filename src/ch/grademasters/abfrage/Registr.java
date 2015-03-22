package ch.grademasters.abfrage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import ch.grademasters.controller.GMController;
import ch.grademasters.exception.SQLError;
import ch.grademasters.exception.UserFail;
import ch.grademasters.exception.UserSuccess;
import ch.grademasters.model.User;
import ch.grademasters.util.EncryptUtils;

/**
 * @description Klasse um sich in der DB zu registrieren
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Registr.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Registr extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	Label LabelBeschreibung = new Label(
			"Hier registrieren und gleich loslegen:");
	Label LabelUsername = new Label("Username");
	Label LabelPasswort = new Label("Passwort");
	static JTextField TextUsername = new JTextField(20); // Laenge angeben
	static JPasswordField FieldPasswort = new JPasswordField(20); // Laenge
	
	static Button ButtonRegistr = new Button("Registrieren");

	/**
	 * Konstruktor der Klasse Registr.
	 * Hier wird ein neues Fenster erstellt
	 */
	public Registr() {
		
		setLocationRelativeTo(null);
		setLayout(new FlowLayout()); // Layout definieren
		add(LabelBeschreibung);
		add(LabelUsername);
		add(TextUsername);
		add(LabelPasswort);
		add(FieldPasswort);
		add(ButtonRegistr);
		ButtonRegistr.addActionListener(this);

		setSize(275, 250);
		setVisible(true);

	}

	/**
	 * Actionlistener fuer die Registration
	 */
	public void actionPerformed(ActionEvent arg0) {

		String username = TextUsername.getText();
		String passwort = new String(FieldPasswort.getPassword());

		// Ueberpreuft ob feld nicht leer ist
		if (StringUtils.isBlank(username) || StringUtils.isBlank(passwort)) {
			UserFail userFail = new UserFail();
			userFail.setLocationRelativeTo(null);
		}
		//Verschlüsselt das Passwort
		else {
			passwort = EncryptUtils.base64encode(passwort);
			
			//Versucht neuen Benutzer anzulegen
			try {
				User currentUser = new User();
				currentUser.setUsername(username);
				currentUser.setPasswort(passwort);
				GMController.getInstance().insert(currentUser);
				setVisible(false);
				setAlwaysOnTop(true);
				UserSuccess userSuccess = new UserSuccess();
				userSuccess.setLocationRelativeTo(null);

			}
			catch (Exception e1) {
				SQLError sqlError = new SQLError();
				sqlError.setLocationRelativeTo(null);
			}

		}
		
		//Setzt Felder wieder auf 0
		username = null;
		passwort = null;
	}
}
