package ch.grademasters.abfrage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch.grademasters.abfrage.Abfrage_User.WindowListener;

public class Registration extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Label LabelUsername = new Label("Username");
	Label LabelPasswort = new Label("Passwort");
	Label LabelPasswortBest = new Label("Passwort bestätigen");
	// Laenge angeben
	JTextField TextUsername = new JTextField(20);
	// Laenge angeben
	JPasswordField FieldPasswort = new JPasswordField(20);
	// Laenge angeben
	JPasswordField FieldPasswortBest = new JPasswordField(20);
	Button ButtonRegistration = new Button("Registrieren");

	public Registration() {
		// Layout definieren
		setLayout(new FlowLayout());
		add(LabelUsername);
		add(TextUsername);
		add(LabelPasswort);
		add(FieldPasswort);
		// Best = Bestaetigung
		add(LabelPasswortBest);
		add(FieldPasswortBest);
		add(ButtonRegistration);
		ButtonRegistration.addActionListener(this);
		setSize(275, 250);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Variablen deklarieren
		Connection con = null;
		Connection select = null;
		// String für Username aus DB
		String UsernameDb;

		// ### Datenbank ###
		// Username von Eingabefeld auslesen
		String UserLocal = TextUsername.getText();
		@SuppressWarnings("deprecation")
		// Passwort von Eingabefeld auslesen
		char[] PasswortLocal = FieldPasswort.getPassword();
		@SuppressWarnings("deprecation")
		// Passwort von Eingabefeld auslesen
		char[] PasswortLocalBest = FieldPasswortBest.getPassword();
		Statement s = null;
		ResultSet rs = null;

		try {
			select = DriverManager.getConnection(
			// Baut die Verbindung auf
					"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234");
			s = select.createStatement();
			// Query ausführen
			rs = s.executeQuery("Select * From User");

			while (rs.next()) {
				// Username aus DB lesen
				UsernameDb = rs.getString("Username");

				if (!UsernameDb.equals(UserLocal)) {
					System.out.println("Passt!");

					// Ueberprueft, ob die TextFiels nicht leer sind
					if ((!UserLocal.equals("")) || (!PasswortLocal.equals(""))) {
						if (PasswortLocal.equals(PasswortLocalBest)) {

							try {
								s = con.createStatement();
								// Query ausführen
								rs = s.executeQuery("INSERT INTO USER (Username, Passwort) VALUES (UserLocal, PasswortLocal)");
							} finally {
								if (rs != null) {
									rs.close();
								}
								if (s != null) {
									s.close();
								}
								if (con != null) {
									con.close();
								}

							}
						}
					}

				}

			}
		}
		catch (Exception ex) { // Exception behandeln
			String ErrorMessage = ex.getMessage(); // Message ausgeben
			StackTraceElement[] StackTrace = ex.getStackTrace(); // Message
																	// ausgeben
		}

	}

	public static void main(String[] args) {
		new Registration(); // Abfrage_User aufrufen
	}

}
