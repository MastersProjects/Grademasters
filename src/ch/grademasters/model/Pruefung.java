package ch.grademasters.model;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Pruefung.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Pruefung {

	// Instanzvariablen
	private float note;
	private float gewichtung;
	private String bezeichnung;
	private String datum;

	/**
	 * @description Konstruktor fuer die Klasse Pruefung
	 * @param bezeichnung, note, gewichtung, datum
	 */
	public Pruefung(String bezeichnung, float note, float gewichtung, String datum) {
		this.setNote(note);
		this.setGewichtung(gewichtung);
		this.setBezeichnung(bezeichnung);
		this.setDatum(datum);
	}

	// Getter und Setter
	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public float getGewichtung() {
		return gewichtung;
	}

	public void setGewichtung(float gewichtung) {
		this.gewichtung = gewichtung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * @description To String Methode
	 * @return toString
	 */
	public String toString() {
		String s = null;
		s = "\n" + this.getBezeichnung() + "\nNote: " + this.getNote()
				+ "\nGewichtung: " + this.getGewichtung() + "\n";
		return s;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

}
