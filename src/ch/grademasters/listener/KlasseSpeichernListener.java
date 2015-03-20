package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
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
		String lehrerVorname = this.getLehrerVorname().getText();
		String lehrerNachname = this.getLehrerNachname().getText();
		String lehrerEmail = this.getLehrerEmail().getText();	
		KlassenLehrer lehrer = new KlassenLehrer(lehrerVorname, lehrerNachname, lehrerEmail);
		
		String klassenName = this.getKlasse().getText();
		String schule = this.getSchule().getText();
		int semester = Integer.parseInt(this.getSemester().getText());
		Klasse klasse = new Klasse(lehrer, klassenName, schule, semester);
		GMController.getInstance().klasseSpeichern(klasse);
		
		//clear textfield
		this.getLehrerVorname().setText("");
		this.getLehrerNachname().setText("");
		this.getLehrerEmail().setText("");
		this.getKlasse().setText("");
		this.getSchule().setText("");
		this.getSemester().setText("");
			
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