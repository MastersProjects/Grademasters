package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;

/**
 * @description ComboBox Listener fuer wechseln von Fach ComboBox
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * KlasseModelListener.java Copyright Berufsbildungscenter GradeMasters 2015
 */

public class KlasseModelListener implements ActionListener {

	private JComboBox<?> addNoteKlasseListe;
	private JComboBox<?> addNoteFachListe;

	
	/**
	 * Konstruktor fuer die Klasse KlasseModelListener
	 * @param addNoteKlasseListe
	 * @param addNoteFachListe
	 */
	public KlasseModelListener(JComboBox<?> addNoteKlasseListe, JComboBox<?> addNoteFachListe) {
		this.setAddNoteKlasseListe(addNoteKlasseListe);
		this.setAddNoteFachListe(addNoteFachListe);
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void actionPerformed(ActionEvent e) {

		//die klasse_ID des ausgewaehlten Item in der ComboBox rausfinden
		Item item = (Item) getAddNoteKlasseListe().getSelectedItem();
		int klasse_ID = item.getId();

		//eine Fach Vector Model erstellen mit den ausgewaehlten klasse_ID
		Vector<?> fachModel = GMController.getInstance().getFachByID(klasse_ID);

		//das alte ComboBox model mit dem neu erstellten model wechseln
		getAddNoteFachListe().setModel(new DefaultComboBoxModel(fachModel));
	}

	
	//Getter und Setter
	public JComboBox<?> getAddNoteKlasseListe() {
		return addNoteKlasseListe;
	}

	public void setAddNoteKlasseListe(JComboBox<?> addNoteKlasseListe) {
		this.addNoteKlasseListe = addNoteKlasseListe;
	}

	public JComboBox<?> getAddNoteFachListe() {
		return addNoteFachListe;
	}

	public void setAddNoteFachListe(JComboBox<?> addNoteFachListe) {
		this.addNoteFachListe = addNoteFachListe;
	}

}
