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

public class Abfrage_User extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Label LabelUsername = new Label("Username");
	Label LabelPasswort = new Label("Passwort");
	JTextField TextUsername = new JTextField(20); // Laenge angeben
	JPasswordField FieldPasswort = new JPasswordField(20); // Laenge angeben
	Button ButtonLogin = new Button("Login");
	Label LabelRegistration = new Label("Noch keinen Account? Hier Registrieren");
	Button ButtonRegistration = new Button("Registrieren");


	public Abfrage_User() {
		setLayout(new FlowLayout()); //Layout definieren
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
		addWindowListener(new WindowListener());
	}

	public void actionPerformed(ActionEvent e) {
		// Variablen deklarieren
		Connection con = null;
		 
		//### Datenbank ###
		String UsernameDb; //String für Username aus DB
		String PasswortDb; //String für PW aus DB
		String UserLocal = TextUsername.getText(); //Username von Eingabefeld auslesen
		@SuppressWarnings("deprecation")
		String PasswortLocal = FieldPasswort.getText(); //Passwort von Eingabefeld auslesen
		boolean login = false; //Setzt Login auf false

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234"); //Baut die Verbindung auf 
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from USER"); //Query ausführen 

			while (rs.next()) {
				// if ()
				UsernameDb = rs.getString("Username"); //Username aus DB lesen
				PasswortDb = rs.getString("Passwort"); // PW aus DB lesen
				login = false; //Login auf false setzen. 
				if ((!UserLocal.equals("")) || (!PasswortLocal.equals(""))) { //Ueberprueft, ob die TextFiels nicht leer sind
					if ((UsernameDb.equals(UserLocal)) //Ueberprueft, ob die Usernamen gleich sind mit .equals()
							&& (PasswortDb.equals(PasswortLocal))) { //Ueberprueft, ob die PWs gleich sind mit .equals()
						
						System.out.println("Herzlich Willkommen " + UserLocal + ", Du bist nun angemeldet!"); //Gibt den String aus
						login = true; //Setzt login auf true
					} 
					else if (login = false) { //Wenn login false ist, dann gibt es den String aus
						System.err.println("Fehler! Bitte Programm erneut starten");
					} 
					else if(!(UsernameDb.equals(UserLocal))){ //Wenn die Usernamen nicht uebereinstimmen, dann gibt es den String aus
						System.err.println("Benutzername und/oder Passwort stimmen nicht!");
					} 
					else if(!PasswortDb.equals(PasswortLocal)) { //Wenn die PWs nicht uebereinstimmen, dann gitb es den String aus 
						System.err.println("Benutzername und/oder Passwort stimmen nicht!");
					}
				} 
				else if((UserLocal.equals("")) && (PasswortLocal.equals(""))){ //Ueberprueft, ob nichts eingegeben wurde
					System.err.println("Felder müssen ausgefüllt sein!");
				}
			}
			//Alles wieder schliessen
			rs.close();
			s.close();
			con.close();
		} catch (Exception ex) { //Exception behandeln
			String ErrorMessage = ex.getMessage(); //Message ausgeben
			StackTraceElement[] StackTrace = ex.getStackTrace(); //Message ausgeben
		}
	}

	class WindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Abfrage_User(); //Abfrage_User aufrufen
	}
}