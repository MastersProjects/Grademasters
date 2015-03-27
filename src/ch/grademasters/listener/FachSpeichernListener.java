package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;

/**
 * @description Button Listener fuer das Fach speichern
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * FachSpeichernListener.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class FachSpeichernListener implements ActionListener {
	
	private JTextField fach;
	private JComboBox<?> klasse;

	
	/**
	 * Konstruktor fuer die Klasse CardButtonListener
	 * @param fach
	 * @param klasse
	 */
	public FachSpeichernListener(JTextField fach, JComboBox<?> klasse) {
		this.setFach(fach);
		this.setKlasse(klasse);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		//die klasse_ID des ausgewaehlten Item in der ComboBox rausfinden
		Item item = (Item) getKlasse().getSelectedItem();
		int ID_Klasse = item.getId();

		//liest die eingabe und setzt es in eine Variable
		String fachName = this.getFach().getText();
		
		//speichert die Eingaben in die Datenbank
		GMController.getInstance().fachSpeichern(ID_Klasse, fachName);

		//Text Felder clearen
		this.getFach().setText("");
	}
	

	//Getter und Setter
	public JTextField getFach() {
		return fach;
	}

	public void setFach(JTextField fach) {
		this.fach = fach;
	}

	public JComboBox<?> getKlasse() {
		return klasse;
	}

	public void setKlasse(JComboBox<?> klasse) {
		this.klasse = klasse;
	}
}

