package ch.grademasters.tester;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;

public class FachTester {

	public static void main(String[] args) {
		Fach mathe = new Fach("Mathe");
		
		Pruefung pruefung1 = new Pruefung("Gleichungen", 6f, 1f);
		Pruefung pruefung2 = new Pruefung("Eins mal Eins", 5.76f, 0.5f);
		
		mathe.addPruefung(pruefung1);
		mathe.addPruefung(pruefung2);
		
		Fach deutsch = new Fach("Deutsch");
		
		Pruefung pruefung3 = new Pruefung("Gramatik", 4.25f, 1f);
		Pruefung pruefung4 = new Pruefung("Nomen", 5.25f, 0.5f);
		Pruefung pruefung5 = new Pruefung("Verben", 4.8f, 0.5f);
		
		deutsch.addPruefung(pruefung3);
		deutsch.addPruefung(pruefung4);
		deutsch.addPruefung(pruefung5);
		
		
			
		
		
		System.out.println(mathe);
		System.out.println(deutsch);
		
		
		

	}

}
