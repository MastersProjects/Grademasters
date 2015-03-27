package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;

/**
 * @description Listener dammit man eine Klasse speichern kann
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * FachSpeichernListener.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class FachSpeichernListener implements ActionListener {
	private JTextField fach;
	private JComboBox<?> klasse;

	public FachSpeichernListener(JTextField fach, JComboBox<?> klasse) {
		this.setFach(fach);
		this.setKlasse(klasse);

	}

	public void actionPerformed(ActionEvent e) {
		Item item = (Item) getKlasse().getSelectedItem();
		int ID_Klasse = item.getId();

		String fachName = this.getFach().getText();
		GMController.getInstance().fachSpeichern(ID_Klasse, fachName);

		// clear textfield
		this.getFach().setText("");
	}

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
