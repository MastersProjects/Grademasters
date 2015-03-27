package ch.grademasters.model;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * Klasse.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Klasse {

	// Instanzvariablen
	private String klassenName;
	private String schule;
	private int semester;
	private KlassenLehrer klassenLehrer;
	private Zeugnis zeugnis;
	
/**
 * Konstruktor fuer eine neue Klasse
 * @param lehrer, klassenname, schule, semester
 */
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
	public String getKlassenname() {
		return klassenName;
	}

	public void setKlassenname(String klassenName) {
		this.klassenName = klassenName;
	}

	public String getSchule() {
		return schule;
	}

	public void setSchule(String schule) {
		this.schule = schule;
	}

	public KlassenLehrer getKlassenLehrer() {
		return klassenLehrer;
	}

	public void setKlassenLehrer(KlassenLehrer klassenLehrer) {
		this.klassenLehrer = klassenLehrer;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public Zeugnis getZeugnis() {
		return zeugnis;
	}

	public void setZeugnis(Zeugnis zeugnis) {
		this.zeugnis = zeugnis;
	}
	
	/**
	 * To String Methode
	 * @return String
	 */
	public String toString() {
		String l = "";
		l = "Schule: " + this.getSchule() + "\n";
		l =  l + "Klasse: " + this.getKlassenname() + "\n";
		l = l + "Semester: " + this.getSemester() + "\n";
		
//		l = l + "Lehrer: \n" + this.getKlassenLehrer().toString() + "\n\n";
//		for (Fach fach : this.getZeugnis().getFach()) {
//			l = l + fach;
//		}
//		l = l + "\n" + this.getZeugnis();
		return l;
	}	
}
