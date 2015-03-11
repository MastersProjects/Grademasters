package ch.grademasters.tester;

import ch.grademasters.model.Klasse;
import ch.grademasters.model.Lehrer;

/**
 * @description Dies ist die Testkalsse fuer die Klasse Lehrer
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file LehrerTester.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class KlasseTester {
	public static void main(String[] args) {

		Lehrer lehrer = new Lehrer("Guenther", "Schneider",
				"Guenter.Schneider@Access.tbz");
		Klasse klasse = new Klasse(lehrer, "AP14a", "TBZ", 2);

		System.out.println(klasse);

	}

}
