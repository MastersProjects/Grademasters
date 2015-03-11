package ch.grademasters.model;
/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Pruefung.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Pruefung {
	
	//Instanzvariablen
	private float note;
	private float gewichtung;
	private String bezeichnung;
	
	//Konstruktor
	public Pruefung (String bezeichnung, float note, float gewichtung) {
		this.setNote(note);
		this.setGewichtung(gewichtung);
		this.setBezeichnung(bezeichnung);
	}
	
	
	//Getter und Setter
	/**
	 * @return note
	 */
	public float getNote() {
		return note;
	}
	/**
	 * @param note
	 */
	public void setNote(float note) {
		this.note = note;
	}
	
	/**
	 * @return gewichtung
	 */
	public float getGewichtung() {
		return gewichtung;
	}
	/**
	 * @param gewichtung
	 */
	public void setGewichtung(float gewichtung) {
		this.gewichtung = gewichtung;
	}
	
	/**
	 * @return bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	/**
	 * @param bezeichnung
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	//Methode
	/**
	 * To String Methode
	* @return toString
	*/
	public String toString() {
		String s = null;
		s = "\n" + this.getBezeichnung() + "\nNote: " + this.getNote() + "\nGewichtung: " + this.getGewichtung() + "\n";
		return s;
	}

	
	
}
