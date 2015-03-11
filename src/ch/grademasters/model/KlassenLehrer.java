package ch.grademasters.model;

/**
 * @description Klasse Lehrer enthaelt alle Informationen ueber eine Lehrer einer Klasse
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file Lehrer.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class KlassenLehrer{

	// Instanzvariablen
	private String name;
	private String vorname;
	private String email;

	public KlassenLehrer(String name, String vorname, String email) {
		this.setName(name);
		this.setVorname(vorname);
		this.setEmail(email);
	}
	
	// Getter und Setter
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return String s mit Vorname, Nachname, Email
	 */
	public String toString() {
		String s = null;		
		s = this.getVorname() + " " + this.getName() + "\n";
		s = s + this.getEmail();
		return s; 
	}

}
