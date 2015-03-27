package ch.grademasters.tester;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;

/**
 * @description Dies ist die Testerklasse fuer die Klasse Fach, sie enthaelt
 *              zwei Beispiele
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file FachTester.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class FachTester {

	public static void main(String[] args) {

		// Erstes Beispiel
		Fach mathe = new Fach("Mathe");

		Pruefung pruefung1 = new Pruefung("Gleichungen", 6f, 1f, null);
		Pruefung pruefung2 = new Pruefung("Eins mal Eins", 5.76f, 0.5f, null);
		mathe.addPruefung(pruefung1);
		mathe.addPruefung(pruefung2);

		// Zweites Beispiel
		Fach deutsch = new Fach("Deutsch");

		Pruefung pruefung3 = new Pruefung("Gramatik", 4.25f, 1f, null);
		Pruefung pruefung4 = new Pruefung("Nomen", 5.25f, 0.5f, null);
		Pruefung pruefung5 = new Pruefung("Verben", 4.8f, 0.5f, null);
		deutsch.addPruefung(pruefung3);
		deutsch.addPruefung(pruefung4);
		deutsch.addPruefung(pruefung5);

		// Erwartetes Resultat 5.92
		System.out.println(mathe);

		// Erwartetes Resultat 4.6375
		System.out.println(deutsch);

	}

}
