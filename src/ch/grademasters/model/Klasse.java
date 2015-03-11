package ch.grademasters.model;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * @file Klasse.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Klasse {

	// Instanzvariablen
	private String klassenname;
	private String schule;
	private int semester;
	private Lehrer klassenLehrer;

	public Klasse(Lehrer lehrer, String klassenname, String schule, int semester) {
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
	public String getKlassenname() {
		return klassenname;
	}

	/**
	 * @param klassenname
	 */
	public void setKlassenname(String klassenname) {
		this.klassenname = klassenname;
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
	public Lehrer getKlassenLehrer() {
		return klassenLehrer;
	}

	/**
	 * @param klassenLehrer
	 */
	public void setKlassenLehrer(Lehrer klassenLehrer) {
		this.klassenLehrer = klassenLehrer;
	}

	/**
	 * @return semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @param semester
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String toString() {
		String l = "";
		l = "Klasse: " + "       " + this.getKlassenname() + "\n";
		l = l + "Semester: " + "     " + this.getSemester() + "\n";
		l = l + "Schule: " + "       " + this.getSchule() + "\n";
		l = l + this.getKlassenLehrer().toString() + "\n";
		return l;
	}
}
