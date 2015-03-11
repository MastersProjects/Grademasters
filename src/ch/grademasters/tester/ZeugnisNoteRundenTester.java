package ch.grademasters.tester;

import ch.grademasters.model.Zeugnis;

/**
 * @description Dies ist die Testerklasse für die Rundungsfunktion in der Klasse Zeugnis
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file ZeugnisNoteRundenTester.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class ZeugnisNoteRundenTester {

	public static void main(String[] args) {
		Zeugnis z = new Zeugnis();
		
		//5 verschiedene Testnoten als Ausgangsdaten
		float[] zahlen = new float[5];
		zahlen[0] = 4.5f;
		zahlen[1] = 2.25f;
		zahlen[2] = 5.3f;
		zahlen[3] = 4.0f;
		zahlen[4] = 3.8f;
		
		//Liste fuer die Rueckgabewerte aus der Funktion noteRunden
		float[] zahlenNeu = new float[5];
		
		/**
		 * Aufruf der Funktion noteRunden mit Daten aus Liste zahlen resultate in Liste zahlenNeu
		 * @param Noten aus Liste zahlen
		 * @return gerundete Note auf 0.5 in Liste zahlenNeu
		 */
		for(int i = 0; i < 5; i++){
		zahlenNeu[i] = z.noteRunden(zahlen[i]);
		System.out.println("alt: " + zahlen[i] + " neu: " + zahlenNeu[i] + "\n");
		}
	}
}
