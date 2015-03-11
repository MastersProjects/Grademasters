package ch.grademasters.tester;

import ch.grademasters.model.Lehrer;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin Lehrer.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class LehrerTester {
	public static void main(String[] args) {

		Lehrer b = new Lehrer();
		
		b.setKlassenname("AP14a");
		b.setSchule("Technische Berufsschule Zürich");
		b.setSemester(2);
		b.setKlassenlehrer("Günther Schneider");
		
		b.setName("Schneider");
		b.setVorname("Günther");
		b.setEmail("guenther.schneider@tbz.ch");
		String s = b.toString();
		System.out.println(s);
		
	}

}
