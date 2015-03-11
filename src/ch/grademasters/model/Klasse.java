package ch.grademasters.model;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file Klasse.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Klasse {

	// Instanzvariablen
	private String klassenname;
	private String schule;
	private String klassenlehrer;
	private int Semester;

	/**
	 * @return klassenname
	 */
	public String getKlassenname() {
		return klassenname;
	}

	/**
	 * 
	 * @param klassenname
	 */
	public void setKlassenname(String klassenname) {
		this.klassenname = klassenname;
	}

	/**
	 * 
	 * @return schule
	 */
	public String getSchule() {
		return schule;
	}

	/**
	 * 
	 * @param schule
	 */
	public void setSchule(String schule) {
		this.schule = schule;
	}

	/**
	 * 
	 * @return Klassenlehrer
	 */
	public String getKlassenlehrer() {
		return klassenlehrer;
	}

	/**
	 * 
	 * @param klassenlehrer
	 */
	public void setKlassenlehrer(String klassenlehrer) {
		this.klassenlehrer = klassenlehrer;
	}

	/**
	 * 
	 * @return semester
	 */
	public int getSemester() {
		return Semester;
	}

	/**
	 * 
	 * @param semester
	 */
	public void setSemester(int semester) {
		Semester = semester;
	}
	
	public String toString(){
		String l = "";
		l =     "Klasse: " + "       "  + klassenname + "\n";
		l = l + "Semester: " + "     " + Semester + "\n";
		l = l + "Schule: " + "       " + schule + "\n";
		l = l + "********************************************** \n" ;
		l = l + "Klassenlehrer: " +  "\n";
		return l;
	}
}
