package ch.grademasters.abfrage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Abfrage_User extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Label l = new Label("Username");
	Label l2 = new Label("Passwort");
	JTextField Text_User = new JTextField(); // Zeilen, Spalten
	JTextField Text_PW = new JTextField(); // Zeilen, Spalten
	Button b = new Button("Login");

	public Abfrage_User() {
		this.Text_User.setSize(300, 100);
		setLayout(new FlowLayout()); // muss
		add(l);
		add(Text_User);
		add(l2);
		add(Text_PW);
		add(b);
		b.addActionListener(this);
		setSize(500, 300);
		setVisible(true);
		addWindowListener(new FensterLauscher());
	}

	public void actionPerformed(ActionEvent e) {
		// Variablen deklarieren
		Connection con = null;
		String UsernameDb;
		String PasswortDb;
		String user = null;
		String passwort;
		String userdb;
		String pwdb;
		boolean login = false;
	

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234");
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from USER where Username = 'zmartl'");

			while (rs.next()) {
				// if ()
				UsernameDb = rs.getString("Username");
				PasswortDb = rs.getString("Passwort");
				userdb = (user + "\t");

				passwort = rs.getString("Passwort");
				pwdb = (passwort + "\t");

				if ((user == userdb) && (passwort == pwdb)) {
					System.out.println("Hei! It works!");
				} else {
					System.out.println("Fail");
				}
			}
			rs.close();
			s.close();
			con.close();
		} catch (Exception ex) {
			Text_User.append("" + ex.getMessage());
		}
	}

	class FensterLauscher extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Abfrage_User();
	}
}