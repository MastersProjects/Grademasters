package ch.grademasters.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Fach.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Fach {
	
	//Instanzvariablen
	private String fach;
	private Collection<Pruefung> pruefung = new ArrayList<Pruefung>();
	
	
	//Kontruktor
	public Fach (String fach) {
		this.setFach(fach);
	}
	
	
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
	public Collection<Pruefung> getPruefung() {
		return pruefung;
	}
	
	/**
	 * @param pruefung
	 */
	public void setPruefung(Collection<Pruefung> pruefung) {
		this.pruefung = pruefung;
	}
	
		
	//Methode	
	/**
	* @return ZeugnisNote
	*/
	public float berechneZeugnisNote(float note) {
		return 0;
	}
	
	/**
	* @param addPruefung
	*/	
	public void addPruefung(Pruefung addPruefung) {
		this.getPruefung().add(addPruefung);
	}
	/**
	* @param removePruefung
	*/	
	public void removePruefung(Pruefung removePruefung) {
		this.getPruefung().remove(removePruefung);
	}
		
	/**
	* @return toString
	*/
	public String toString() {
		String s = null;
		s = this.getFach() + "\n" + this.getPruefung();
		return s;
	}
	
	

	


	
	
}
