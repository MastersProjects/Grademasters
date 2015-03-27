package ch.grademasters.tester;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;
import ch.grademasters.model.Zeugnis;

/**
 * @description Dies ist die Testerklasse für die Rundungsfunktion in der Klasse Zeugnis
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file ZeugnisNoteRundenTester.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class ZeugnisTester {

	public static void main(String[] args) {
		
		Zeugnis zeugnis = new Zeugnis();
		
		Fach mathe = new Fach("Mathe");
		
		zeugnis.addFach(mathe);
		Pruefung pruefung1 = new Pruefung("Gleichungen", 6f, 1f, null);
		Pruefung pruefung2 = new Pruefung("Eins mal Eins", 5.76f, 0.5f, null);		
		mathe.addPruefung(pruefung1);
		mathe.addPruefung(pruefung2);
		
		//Zweites Beispiel 
		Fach deutsch = new Fach("Deutsch");
		
		zeugnis.addFach(deutsch);
		Pruefung pruefung3 = new Pruefung("Gramatik", 4.25f, 1f, null);
		Pruefung pruefung4 = new Pruefung("Nomen", 5.25f, 0.5f, null);
		Pruefung pruefung5 = new Pruefung("Verben", 4.8f, 0.5f, null);		
		deutsch.addPruefung(pruefung3);
		deutsch.addPruefung(pruefung4);
		deutsch.addPruefung(pruefung5);
		
		//Ausgabe alles Informationen
		System.out.println(zeugnis);
		
		
		
		

	}
}
