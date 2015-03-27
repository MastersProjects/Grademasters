package ch.grademasters.model;

/**
 * @description Klasse Lehrer enthaelt alle Informationen ueber eine Lehrer
 *              einer Klasse
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin KlassenLehrer.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class KlassenLehrer {

	// Instanzvariablen
	private String name;
	private String vorname;
	private String email;

	/**
	 * @description Konstruktor fuer einen KlassenLeherer
	 * @param name
	 *            , vorname, email
	 */
	public KlassenLehrer(String name, String vorname, String email) {
		this.setName(name);
		this.setVorname(vorname);
		this.setEmail(email);
	}

	// Getter und Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @description To String Methode
	 * @return String mit Vorname, Nachname, Email
	 */
	public String toString() {
		String kl = "";
		kl = "Klassenlehrperson: " + this.getVorname() + " " + this.getName()
				+ "\n";
		kl = kl + "E-Mail: " + this.getEmail() + "\n";
		return kl;
	}
}
