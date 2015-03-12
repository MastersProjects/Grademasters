package ch.grademasters.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description Diese lasse wird dazu bennötigt, ein Zeugniss zu berechnen
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file Zeugnis.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Zeugnis {

	private Collection<Fach> fach = new ArrayList<Fach>();

	// Getter und Setter
	/**
	 * @return fach
	 */
	public Collection<Fach> getFach() {
		return fach;
	}

	/**
	 * @param fach
	 */
	public void setFach(Collection<Fach> fach) {
		this.fach = fach;
	}

	// Methode
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
	 * @return toString
	 */
	public String toString() {
		String s = null;
		s = "Zeugnis\n\n";
		for (Fach fach : this.getFach()) {
			s = s + fach.getFach() + ": "
					+ this.noteRunden(fach.berechneZeugnisNote()) + "\n";
		}
		return s;

	}

	/**
	 * Fuegt eine Fach hinzu
	 * 
	 * @param addFach
	 */
	public void addFach(Fach addFach) {
		this.getFach().add(addFach);
	}

	/**
	 * löscht eine Fach
	 * 
	 * @param removeFach
	 */
	public void removeFach(Fach removeFach) {
		this.getFach().remove(removeFach);
	}

}
