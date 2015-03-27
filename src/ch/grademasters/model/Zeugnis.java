package ch.grademasters.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description Diese lasse wird dazu bennötigt, ein Zeugniss zu berechnen
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin Zeugnis.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Zeugnis {

	String alleNoten = "";

	private Klasse klasse;
	private KlassenLehrer klassenLehrer;
	private Collection<Fach> fach = new ArrayList<Fach>();

	// Getter und Setter
	public Collection<Fach> getFach() {
		return fach;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public void setFach(Collection<Fach> fach) {
		this.fach = fach;
	}

	public void addFach(Fach addFach) {
		this.getFach().add(addFach);
	}

	public void setKlasse(Klasse addKlasse) {
		this.klasse = addKlasse;
	}

	public void removeFach(Fach removeFach) {
		this.getFach().remove(removeFach);
	}

	/**
	 * Diese Methode rundet die Note in eine Zeugnisnote also auf 0.5 genau
	 * 
	 * @param durchschnitt
	 * @return gerundete Note auf 0.5
	 */
	public float noteRunden(float durchschnitt) {
		durchschnitt = durchschnitt * 2;
		durchschnitt = (float) Math.round(durchschnitt);
		durchschnitt = durchschnitt / 2;
		return durchschnitt;
	}

	/**
	 * To String Methode
	 * 
	 * @return String
	 */
	public String toString() {
		String s = "";
		s += "Klasse:          " + this.getKlasse().getKlassenname();
		s += "\nSemester:     " + this.getKlasse().getSemester();
		s += "\nSchule:         " + this.getKlasse().getSchule() + "\n";
		s += "\nKlassenlehrperson: \n" + "Name:          "
				+ this.getKlassenLehrer().getName() + " "
				+ this.getKlassenLehrer().getVorname();
		s += "\nEmail:           " + this.getKlassenLehrer().getEmail();
		s += "\n_____________________________________________________________________________\n";
		s += "\nNoten: \n";
		for (Fach fach : this.getFach()) {
			s = s + fach.getFach() + ": "
					+ this.noteRunden(fach.berechneZeugnisNote()) + "\n";
		}
		return s;

	}

	private KlassenLehrer getKlassenLehrer() {
		return klassenLehrer;
	}

	public void setKlassenLehrer(KlassenLehrer klassenLehrer) {
		this.klassenLehrer = klassenLehrer;
	}

}
