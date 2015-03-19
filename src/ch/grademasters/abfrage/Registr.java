package ch.grademasters.abfrage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import ch.grademasters.controller.GMController;
import ch.grademasters.exception.SQLError;
import ch.grademasters.model.User;
import ch.grademasters.util.EncryptUtils;

public class Registr extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Label LabelBeschreibung = new Label(
			"Hier registrieren und gleich loslegen:");
	Label LabelUsername = new Label("Username");
	Label LabelPasswort = new Label("Passwort");
	static JTextField TextUsername = new JTextField(20); // Laenge angeben
	static JPasswordField FieldPasswort = new JPasswordField(20); // Laenge
																	// angeben
	static Button ButtonRegistr = new Button("Registrieren");

	public Registr() {
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
		addWindowListener(new WindowListener());

	}

	class WindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		final String username = TextUsername.getText();
		String passwort = new String(FieldPasswort.getPassword());

		if (StringUtils.isBlank(username) || StringUtils.isBlank(passwort)) {

		}
		else {
			passwort = EncryptUtils.base64encode(passwort);
			

			try {
				User currentUser = new User();
				currentUser.setUsername(username);
				currentUser.setPasswort(passwort);
				GMController.getInstance().insert(currentUser);

			}
			catch (Exception e1) {
				new SQLError();
			}

		}
	}
}
