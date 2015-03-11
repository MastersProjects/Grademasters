package ch.grademasters.model;
/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Lehrer.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Lehrer {
	
	//Instanzvariablen
	private String name;
	private String vorname;
	private String email;
	
	//Getter und Setter
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
	
}