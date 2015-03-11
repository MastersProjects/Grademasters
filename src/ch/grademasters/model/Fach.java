package ch.grademasters.model;
/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Fach.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Fach {
	
	//Instanzvariablen
	private String fach;
	private Pruefung pruefung = new Pruefung();
	

	
	//Getter und Setter
	/**
	* @return fach
	*/
	public String getFach() {
		return fach;
	}

	/**
	 * @param fach
	 */
	public void setFach(String fach) {
		this.fach = fach;
	}

	/**
	* @return pruefung
	*/
	public Pruefung getPruefung() {
		return pruefung;
	}
	/**
	 * @param pruefung
	 */
	public void setPruefung(Pruefung pruefung) {
		this.pruefung = pruefung;
	}
	
	//Methode
	
	/**
	* @return ZeugnisNote
	*/
	public float berechneZeugnisNote(float note) {
		return this.getPruefung().getNote();
	}
}
