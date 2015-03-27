package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;

/**
 * @description Button Listener fuer speichern der Note
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class NoteSpeichernListener implements ActionListener {

	private JTextField note;
	private JTextField gewichtung;
	private JTextField benennung;
	private JComboBox<?> addNoteFachListe;
	private JSpinner datumSpinner;
	
	
	/**
	 * Konstruktor fuer die Klasse KlasseSpeichernListener
	 * @param note
	 * @param gewichtung
	 * @param benennung
	 * @param addNoteFachListe
	 * @param datumSpinner
	 */
	public NoteSpeichernListener(JTextField note, JTextField gewichtung, JTextField benennung, JComboBox<?> addNoteFachListe, JSpinner datumSpinner) {
		this.setNote(note);
		this.setGewichtung(gewichtung);
		this.setBenennung(benennung);
		this.setAddNoteFachListe(addNoteFachListe);
		this.setDatumSpinner(datumSpinner);
	}


	public void actionPerformed(ActionEvent e) {
		//das fach_ID des ausgewaehlten Item in der ComboBox rausfinden
		Item item = (Item) getAddNoteFachListe().getSelectedItem();
		int ID_Fach = item.getId();
		
		//liest die eingabe setzt es in einere Variable
		float note = Float.parseFloat(this.getNote().getText());
		float gewichtung = Float.parseFloat(this.getGewichtung().getText());
		String benennung = this.getBenennung().getText();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy"); //datum Format
		String datum = formater.format(getDatumSpinner().getValue());	//liest datum mit dem entsprechendem erstellten Format
		
		//note in die Datenbank speichern
		GMController.getInstance().noteSpeichern(note, gewichtung, ID_Fach, benennung, datum);
		
		//Text Felder clearen
		this.getNote().setText("");
		this.getGewichtung().setText("");
		this.getBenennung().setText("");
	}


	//Getter und Setter
	public JTextField getNote() {
		return this.note;
	}


	public void setNote(JTextField note) {
		this.note = note;
	}


	public JTextField getGewichtung() {
		return this.gewichtung;
	}


	public void setGewichtung(JTextField gewichtung) {
		this.gewichtung = gewichtung;
	}


	public JTextField getBenennung() {
		return this.benennung;
	}


	public void setBenennung(JTextField benennung) {
		this.benennung = benennung;
	}


	public JComboBox<?> getAddNoteFachListe() {
		return this.addNoteFachListe;
	}


	public void setAddNoteFachListe(JComboBox<?> fach) {
		this.addNoteFachListe = fach;
	}

	public JSpinner getDatumSpinner() {
		return datumSpinner;
	}

	public void setDatumSpinner(JSpinner datumSpinner) {
		this.datumSpinner = datumSpinner;
	}
	
	
	
	
}
