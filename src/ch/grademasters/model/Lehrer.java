package ch.grademasters.model;

/**
 * @description Klasse Lehrer enthaelt alle Informationen ueber eine Lehrer einer Klasse
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file Lehrer.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Lehrer extends Klasse{

	// Instanzvariablen
	private String name;
	private String vorname;
	private String email;
	Klasse l;

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
		String s = "";
		s = super.toString();
		s = s + vorname + " " + name + "\n";
		s = s + email;
		return s; 
	}

}
