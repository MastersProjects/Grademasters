package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ch.grademasters.model.Klasse;
import ch.grademasters.model.KlassenLehrer;

public class KlasseSpeichernListener implements ActionListener {

	private JTextField klasse;
	private JTextField schule;
	private JTextField semester;
	private JTextField lehrerVorname;
	private JTextField lehrerNachname;
	private JTextField lehrerEmail;
	

	public KlasseSpeichernListener(JTextField klasse, JTextField schule, JTextField semester, JTextField lehrerVorname, JTextField lehrerNachname, JTextField lehrerEmail ){
		this.setKlasse(klasse);
		this.setSchule(schule);
		this.setSemester(semester);
		this.setLehrerVorname(lehrerVorname);
		this.setLehrerNachname(lehrerNachname);
		this.setLehrerEmail(lehrerEmail);
	}
		
	public void actionPerformed(ActionEvent e) {
		String lehrerVorname = getLehrerVorname().getText();
		String lehrerNachname = getLehrerNachname().getText();
		String lehrerEmail = getLehrerEmail().getText();	
		KlassenLehrer lehrer = new KlassenLehrer(lehrerVorname, lehrerNachname, lehrerEmail);
		
		String klassenName = getKlasse().getText();
		String schule = getSchule().getText();
		int semester = Integer.parseInt(getSemester().getText());
		Klasse klasse = new Klasse(lehrer, klassenName, schule, semester);
		
		System.out.println(klasse);
		
		
	}

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
