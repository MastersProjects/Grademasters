package ch.grademasters.tester;

import ch.grademasters.model.Klasse;
import ch.grademasters.model.Lehrer;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin Lehrer.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class LehrerTester {
	public static void main(String[] args) {

		Klasse a = new Klasse();
		Lehrer b = new Lehrer();
		
		a.setKlassenname("AP14a");
		a.setSchule("Technische Berufsschule Zürich");
		a.setSemester(2);
		a.setKlassenlehrer("Günther Schneider");
		
		b.setName("Schneider");
		b.setVorname("Günther");
		b.setEmail("guenther.schneider@tbz.ch");
		String s = a.toString() + b.toString();
		System.out.println(s);
		
	}

}
