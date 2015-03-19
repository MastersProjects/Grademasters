package ch.grademasters.abfrage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.exception.SQLError;
import ch.grademasters.model.User;
import ch.grademasters.view.GradeMastersView;

public class Abfrage_User extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	Label LabelUsername = new Label("Username");
	Label LabelPasswort = new Label("Passwort");
	static JTextField TextUsername = new JTextField(20); // Laenge angeben
	static JPasswordField FieldPasswort = new JPasswordField(20); // Laenge
																	// angeben
	static Button ButtonLogin = new Button("Login");
	Label LabelRegistration = new Label(
			"Noch keinen Account? Hier Registrieren");
	static Button ButtonRegistration = new Button("Registrieren");

	public Abfrage_User() {

		setLayout(new FlowLayout()); // Layout definieren
		add(LabelUsername);
		add(TextUsername);
		add(LabelPasswort);
		add(FieldPasswort);
		add(ButtonLogin);
		add(LabelRegistration);
		add(ButtonRegistration);
		ButtonLogin.addActionListener(this);
		ButtonRegistration.addActionListener(this);
		setSize(275, 250);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowListener());

	}

	class WindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Abfrage_User gui = new Abfrage_User(); // Abfrage_User aufrufen
		gui.setLocationRelativeTo(null);
		// Action Listener erstellen
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String username = TextUsername.getText();
				final String passwort = new String(FieldPasswort.getPassword());
				try {
					User currentUser = new User();
					currentUser.setUsername(username);
					currentUser.setPasswort(passwort);
					if (GMController.getInstance().login(currentUser) == true) {
						gui.setVisible(false);
						GradeMastersView gradeMastersView = new GradeMastersView();
						gradeMastersView.setLocationRelativeTo(null);
					}
				}
				catch (Exception e1) {
					SQLError qulError = new SQLError();
					qulError.setLocationRelativeTo(null);
				}
				

			}
		});

		ButtonRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registr registr = new Registr();
				registr.setLocationRelativeTo(null);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
