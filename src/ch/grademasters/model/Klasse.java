package ch.grademasters.model;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file Klasse.java 
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Klasse {

	// Instanzvariablen
	private static String klassenName;
	private String schule;
	private int semester;
	private KlassenLehrer klassenLehrer;
	private Zeugnis zeugnis /*= new Zeugnis()*/;
	

	public Klasse(KlassenLehrer lehrer, String klassenname, String schule,
			int semester) {
		if (lehrer != null) {
			this.setKlassenLehrer(lehrer);
			this.setKlassenname(klassenname);
			this.setSchule(schule);
			this.setSemester(semester);
		}
		else {
			// this.setKlassenLehrer(new Lehrer("","",""));
		}
	}

	// Getter und Setter

	/**
	 * @return klassenname
	 */
	public static String getKlassenname() {
		return klassenName;
	}

	/**
	 * @param klassenname
	 */
	public void setKlassenname(String klassenName) {
		this.klassenName = klassenName;
	}

	/**
	 * @return schule
	 */
	public String getSchule() {
		return schule;
	}

	/**
	 * @param schule
	 */
	public void setSchule(String schule) {
		this.schule = schule;
	}

	/**
	 * @return klassenLehrer
	 */
	public KlassenLehrer getKlassenLehrer() {
		return klassenLehrer;
	}

	/**
	 * @param klassenLehrer
	 */
	public void setKlassenLehrer(KlassenLehrer klassenLehrer) {
		this.klassenLehrer = klassenLehrer;
	}

	/**
	 * @return semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @param zeugnis
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public Zeugnis getZeugnis() {
		return zeugnis;
	}
	
	/**
	 * @param zeugnis
	 */
	public void setZeugnis(Zeugnis zeugnis) {
		this.zeugnis = zeugnis;
	}

	

	// Methode
	/**
	 * To String Methode
	 * 
	 * @return toString
	 */
	public String toString() {
		String l = "";
		l = "Klasse: " + this.getKlassenname() + "\n";
		l = l + "Semester: " + this.getSemester() + "\n";
		l = l + "Schule: " + this.getSchule() + "\n";
		l = l + "Lehrer: \n" + this.getKlassenLehrer().toString() + "\n\n";
//		for (Fach fach : this.getZeugnis().getFach()) {
//			l = l + fach;
//		}
//		l = l + "\n" + this.getZeugnis();
		return l;
	}

	

	

	
}
