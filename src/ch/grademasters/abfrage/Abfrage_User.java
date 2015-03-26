package ch.grademasters.abfrage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.exception.SQLError;
import ch.grademasters.model.User;
import ch.grademasters.view.GradeMastersView;

/**
 * @description Start Klasse, hier wird das Programm gestartet
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin Abfrage_User.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Abfrage_User extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static GradeMastersView gradeMastersView;
	// Label fuer GUI
	Label LabelUsername = new Label("Username");
	Label LabelPasswort = new Label("Passwort");
	Label LabelRegistration = new Label(
			"Noch keinen Account? Hier Registrieren");

	// TextFields fuer GUI
	static JTextField TextUsername = new JTextField(20);
	static JPasswordField FieldPasswort = new JPasswordField(20);

	// Button fuer GUI
	static Button ButtonLogin = new Button("Login");
	static Button ButtonRegistration = new Button("Registrieren");

	/**
	 * Gui erstellen
	 */
	public Abfrage_User() {
		// Layout definieren
		setLayout(new FlowLayout());

		// Hinzufuegen zum GUI
		add(LabelUsername);
		add(TextUsername);
		add(LabelPasswort);
		add(FieldPasswort);
		add(ButtonLogin);
		add(LabelRegistration);
		add(ButtonRegistration);
		ButtonLogin.addActionListener(this);
		ButtonRegistration.addActionListener(this);

		// Eigenschaften des GUI
		setSize(275, 250);
		setVisible(true);
		setResizable(false);

		// Add WindowListener
		addWindowListener(new WindowListener());

	}

	// WindowListener Event
	class WindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void creatGradeMastersView() {
		setGradeMastersView(new GradeMastersView());
		getGradeMastersView().setLocationRelativeTo(null);
	}

	/**
	 * Main Methode fuer Programm
	 */
	public static void main(String[] args) {

		// Abfrage_User aufrufen
		Abfrage_User gui = new Abfrage_User();
		gui.setLocationRelativeTo(null);
		
		gui.setIconImage(new ImageIcon("src/images/icon.png").getImage());
		

		// Action Listener erstellen
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Final Strings fuer Username und Passwort
				final String username = TextUsername.getText();
				final String passwort = new String(FieldPasswort.getPassword());
				try {
					// Neuer User anlegen
					User currentUser = new User();

					// Username und Passwort setzen
					currentUser.setUsername(username);
					currentUser.setPasswort(passwort);

					// Wenn login == true, dann oeffnen des Programmes
					if (GMController.getInstance().login(currentUser) == true) {
						// Login GUI nicht sichbar machen
						gui.setVisible(false);
						// Neue GradeMastersView()
						creatGradeMastersView();
					}
				}
				// Exception auffange
				catch (Exception e1) {
					// Neuer SQLError aufrufen
					SQLError qulError = new SQLError();
					qulError.setLocationRelativeTo(null);
				}

			}
		});

		// ButtonRegistration - ActionListener
		ButtonRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Neues Fenster Registr
				Registr registr = new Registr();
				// Fenster in die Mitte setzen
				registr.setLocationRelativeTo(null);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static GradeMastersView getGradeMastersView() {
		return gradeMastersView;
	}

	public static void setGradeMastersView(GradeMastersView gradeMastersView) {
		Abfrage_User.gradeMastersView = gradeMastersView;
	}

}
