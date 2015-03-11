package ch.grademasters.tester;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;

public class FachTester {

	public static void main(String[] args) {
		Fach mathe = new Fach("Mathe");
		mathe.setPruefung(new Pruefung("Gleichungen", 6, 1));
		
		System.out.println(mathe);
		
		

	}

}
