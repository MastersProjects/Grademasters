package ch.grademasters.tester;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.KlassenLehrer;
import ch.grademasters.model.Pruefung;

/**
 * @description Dies ist die Testkalsse fuer die Klasse Lehrer
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file LehrerTester.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class KlasseTester {
	public static void main(String[] args) {

		KlassenLehrer lehrer = new KlassenLehrer("Guenther", "Schneider",
				"Guenter.Schneider@Access.tbz");
		Klasse klasse = new Klasse(lehrer, "AP14a", "TBZ", 2);

		Fach mathe = new Fach("Mathe");
		klasse.addFach(mathe);
		Pruefung pruefung1 = new Pruefung("Gleichungen", 6f, 1f);
		Pruefung pruefung2 = new Pruefung("Eins mal Eins", 5.76f, 0.5f);		
		mathe.addPruefung(pruefung1);
		mathe.addPruefung(pruefung2);
		
		Fach deutsch = new Fach("Deutsch");
		klasse.addFach(deutsch);
		Pruefung pruefung3 = new Pruefung("Gramatik", 4.25f, 1f);
		Pruefung pruefung4 = new Pruefung("Nomen", 5.25f, 0.5f);
		Pruefung pruefung5 = new Pruefung("Verben", 4.8f, 0.5f);		
		deutsch.addPruefung(pruefung3);
		deutsch.addPruefung(pruefung4);
		deutsch.addPruefung(pruefung5);
		
		System.out.println(klasse);

	}

}
