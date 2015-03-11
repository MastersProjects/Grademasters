package ch.grademasters.tester;

import ch.grademasters.model.Lehrer;

/**
 * @description Dies ist die Testkalsse fuer die Klasse Lehrer
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file LehrerTester.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class LehrerTester {
	public static void main(String[] args) {

		Lehrer b = new Lehrer();
		
		//Werte fuer den Test 
		b.setKlassenname("AP14a");
		b.setSchule("Technische Berufsschule Zürich");
		b.setSemester(2);
		
		b.setName("Schneider");
		b.setVorname("Günther");
		b.setEmail("guenther.schneider@tbz.ch");

		//Ausgabe der Werte mir richtiger Formatierung
		String s = b.toString();
		System.out.println(s);
		
	}

}
