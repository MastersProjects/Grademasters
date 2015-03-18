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
	JTextField TextUsername = new JTextField(20); // Laenge angeben
	JPasswordField FieldPasswort = new JPasswordField(20); // Laenge angeben
	JPasswordField FieldPasswortBest = new JPasswordField(20); // Laenge angeben
	Button ButtonRegistration = new Button("Registrieren");

	public Registration() {
		setLayout(new FlowLayout()); // Layout definieren
		add(LabelUsername);
		add(TextUsername);
		add(LabelPasswort);
		add(FieldPasswort);
		add(LabelPasswortBest); // Best = Bestaetigung
		add(FieldPasswortBest); // Best = Bestaetigung
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
		String UsernameDb; //String für Username aus DB
		
		//### Datenbank ###
		String UserLocal = TextUsername.getText(); //Username von Eingabefeld auslesen
		@SuppressWarnings("deprecation")
		String PasswortLocal = FieldPasswort.getText(); //Passwort von Eingabefeld auslesen
		@SuppressWarnings("deprecation")
		String PasswortLocalBest = FieldPasswortBest.getText(); //Passwort von Eingabefeld auslesen
		
		try {
			select = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234"); //Baut die Verbindung auf 
			Statement sel = select.createStatement();
			ResultSet result = sel
					.executeQuery("Select * From User"); //Query ausführen
			
			while (result.next()) {
				UsernameDb = result.getString("Username");//Username aus DB lesen
			}
				if (!UsernameDb.equals(UserLocal)){
					System.out.println("Passt!");
					if ((!UserLocal.equals("")) || (!PasswortLocal.equals(""))) { //Ueberprueft, ob die TextFiels nicht leer sind
						if (PasswortLocal.equals(PasswortLocalBest)){
					
						try {
						con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234"); //Baut die Verbindung auf 
						Statement s = con.createStatement();
						ResultSet rs = s
								.executeQuery("INSERT INTO USER (Username, Passwort) VALUES (UserLocal, PasswortLocal)"); //Query ausführen
					}	finally {
						result.close();
						sel.close();
						con.close();
						rs.close();
						s.close();
					}
				}

				}
					
				}
			} finally {
				
			}
		
		}

	public static void main(String[] args) {
		new Registration(); // Abfrage_User aufrufen
	}

}
