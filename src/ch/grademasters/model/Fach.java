package ch.grademasters.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Fach.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Fach {

	// Instanzvariablen
	private String fach;
	private Collection<Pruefung> pruefung = new ArrayList<Pruefung>();

	// Kontruktor
	public Fach(String fach) {
		this.setFach(fach);
	}

	// Getter und Setter
	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	
	public Collection<Pruefung> getPruefung() {
		return pruefung;
	}


	public void setPruefung(Collection<Pruefung> pruefung) {
		this.pruefung = pruefung;
	}

	// Methode
	/**
	 * Rechnet Durchschnitts Note vom Fach
	 * @return berechneZeugnisNote
	 */
	public float berechneZeugnisNote() {
		float summe = 0;
		float anzahlNoten = 0;

		// Summe aller Noten berechnen
		for (Pruefung pruefung : this.getPruefung()) {
			summe = summe + (pruefung.getNote() * pruefung.getGewichtung());
		}
		// Anzahl Noten Berechnen mit Gewichtung
		for (Pruefung pruefung : this.getPruefung()) {
			anzahlNoten = anzahlNoten + pruefung.getGewichtung();
		}
		return (summe / anzahlNoten);
	}

	/**
	 * Fuegt eine Pruefung hinzu
	 * @param addPruefung
	 */
	public void addPruefung(Pruefung addPruefung) {
		this.getPruefung().add(addPruefung);
	}

	/**
	 * Loescht eine Prüfung
	 * @param removePruefung
	 */
	public void removePruefung(Pruefung removePruefung) {
		this.getPruefung().remove(removePruefung);
	}

	/**
	 * To String Methode
	 * @return toString
	 */
	public String toString() {
		String s = null;
		s = "\nFach: " + this.getFach() + "\n";
		for (Pruefung pruefung : this.getPruefung()) {
			s = s + pruefung;
		}
		s = s + "\nDurchschnitt: " + this.berechneZeugnisNote() + "\n\n";
		return s;
	}

}
