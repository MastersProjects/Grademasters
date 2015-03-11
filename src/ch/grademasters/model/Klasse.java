package ch.grademasters.model;

import java.util.ArrayList;
import java.util.Collection;

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
	private KlassenLehrer klassenLehrer;
	private Collection<Fach> fach = new ArrayList<Fach>();

	public Klasse(KlassenLehrer lehrer, String klassenname, String schule, int semester) {
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
	 * @param semester
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	/**
	 * @return fach
	 */
	public Collection<Fach> getFach() {
		return fach;
	}
	
	/**
	 * @param fach
	 */
	public void setFach(Collection<Fach> fach) {
		this.fach = fach;
	}
	

	public String toString() {
		String l = "";
		l = "Klasse: " + "       " + this.getKlassenname() + "\n";
		l = l + "Semester: " + "     " + this.getSemester() + "\n";
		l = l + "Schule: " + "       " + this.getSchule() + "\n";
		l = l + this.getKlassenLehrer().toString() + "\n\n";
		for (Fach fach : this.getFach() ) {
			l = l + fach;
		}
		return l;
	}
	
	/**
	 * Fuegt eine Fach hinzu
	* @param addFach
	*/	
	public void addFach(Fach addFach) {
		this.getFach().add(addFach);
	}
	/**
	 * löscht eine Fach
	* @param removeFach
	*/	
	public void removeFach(Fach removeFach) {
		this.getFach().remove(removeFach);
	}



	

	

	
}
