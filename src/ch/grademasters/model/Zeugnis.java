package ch.grademasters.model;
/**
 * @description Diese lasse wird dazu bennötigt, ein Zeugniss zu berechnen
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Zeugnis.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Zeugnis {
	/**
	 * Diese Methode rundet die Note in eine Zeugnisnote also auf 0.5 genau
	 * @param durchschnitt
	 * @return gerundete Note auf 0.5
	 */
	public float noteRunden(float durchschnitt){
		durchschnitt = durchschnitt * 2;
		durchschnitt = (float)Math.ceil(durchschnitt);
		durchschnitt = durchschnitt / 2;
		return durchschnitt;
	}
}


