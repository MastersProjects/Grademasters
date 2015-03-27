package ch.grademasters.model;

/**
 * @description Klasse User wird bennoetigt fuer das Login
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * User.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class User {
	private String Username = null;
	private String Passwort = null;

	//Getter und Setter
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPasswort() {
		return Passwort;
	}

	public void setPasswort(String passwort2) {
		Passwort = passwort2;
	}

}
