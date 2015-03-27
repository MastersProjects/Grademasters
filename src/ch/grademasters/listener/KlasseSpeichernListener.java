package ch.grademasters.listener;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.KlassenLehrer;

/**
 * @description Button Listener fuer speichern der Klasse
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class KlasseSpeichernListener implements ActionListener {

	private JTextField klasse;
	private JTextField schule;
	private JTextField semester;
	private JTextField lehrerVorname;
	private JTextField lehrerNachname;
	private JTextField lehrerEmail;
	

	/**
	 * Konstruktor fuer die Klasse KlasseSpeichernListener
	 * @param klasse
	 * @param schule
	 * @param semester
	 * @param lehrerVorname
	 * @param lehrerNachname
	 * @param lehrerEmail
	 */
	public KlasseSpeichernListener(JTextField klasse, JTextField schule, JTextField semester, JTextField lehrerVorname, JTextField lehrerNachname, JTextField lehrerEmail ){
		this.setKlasse(klasse);
		this.setSchule(schule);
		this.setSemester(semester);
		this.setLehrerVorname(lehrerVorname);
		this.setLehrerNachname(lehrerNachname);
		this.setLehrerEmail(lehrerEmail);
	}

	
	public void actionPerformed(ActionEvent e) {
		//liest die eingabe setzt es in einere Variable
		String lehrerVorname = this.getLehrerVorname().getText();
		String lehrerNachname = this.getLehrerNachname().getText();
		String lehrerEmail = this.getLehrerEmail().getText();
		//KlassenLehrer Objekt mit den eingegebenen Informationen erzeugen
		KlassenLehrer lehrer = new KlassenLehrer(lehrerVorname, lehrerNachname, lehrerEmail);
		
		//liest die eingabe setzt es in einere Variable
		String klassenName = this.getKlasse().getText();
		String schule = this.getSchule().getText();
		int semester = Integer.parseInt(this.getSemester().getText());
		//Klasse Objekt mit den eingegebenen Informationen erzeugen
		Klasse klasse = new Klasse(lehrer, klassenName, schule, semester);
		
		//klasse in die Datenbank speichern
		GMController.getInstance().klasseSpeichern(klasse);
		
		//Text Felder clearen
		this.getLehrerVorname().setText("");
		this.getLehrerNachname().setText("");
		this.getLehrerEmail().setText("");
		this.getKlasse().setText("");
		this.getSchule().setText("");
		this.getSemester().setText("");		
	}

	
	//Getter und Setter
	public JTextField getKlasse() {
		return klasse;
	}

	public void setKlasse(JTextField klasse) {
		this.klasse = klasse;
	}

	public JTextField getSchule() {
		return schule;
	}

	public void setSchule(JTextField schule) {
		this.schule = schule;
	}

	public JTextField getSemester() {
		return semester;
	}

	public void setSemester(JTextField semester) {
		this.semester = semester;
	}

	public JTextField getLehrerVorname() {
		return lehrerVorname;
	}

	public void setLehrerVorname(JTextField lehrerVorname) {
		this.lehrerVorname = lehrerVorname;
	}

	public JTextField getLehrerNachname() {
		return lehrerNachname;
	}

	public void setLehrerNachname(JTextField lehrerNachname) {
		this.lehrerNachname = lehrerNachname;
	}

	public JTextField getLehrerEmail() {
		return lehrerEmail;
	}

	public void setLehrerEmail(JTextField lehrerEmail) {
		this.lehrerEmail = lehrerEmail;
	}
	
	

}