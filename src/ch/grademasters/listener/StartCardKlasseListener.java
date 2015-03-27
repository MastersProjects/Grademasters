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
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class StartCardKlasseListener implements ActionListener  {
	
	private JComboBox<?> startKlasseListe;
	private JComboBox<?> startFachListe;
	
	
	/**
	 * Konstruktor fuer die Klasse KlasseModelListener
	 * @param startKlasseListe
	 * @param startFachListe
	 */	
	public StartCardKlasseListener (JComboBox<?> startKlasseListe, JComboBox<?> startFachListe) {
		setStartKlasseListe(startKlasseListe);
		setStartFachListe(startFachListe);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void actionPerformed(ActionEvent e) {

		//die klasse_ID des ausgewaehlten Item in der ComboBox rausfinden
        Item item = (Item)getStartKlasseListe().getSelectedItem();
        int klasse_ID = item.getId();
		
        //eine Fach Vector Model erstellen mit den ausgewaehlten klasse_ID
        Vector<?> fachModel = GMController.getInstance().getFachByID(klasse_ID);
              
        //das alte ComboBox model mit dem neu erstellten model wechseln
        getStartFachListe().setModel(new DefaultComboBoxModel(fachModel));
		
	}

	
	//Getter und Setter
	public JComboBox<?> getStartKlasseListe() {
		return startKlasseListe;
	}

	public JComboBox<?> getStartFachListe() {
		return startFachListe;
	}

	public void setStartKlasseListe(JComboBox<?> startKlasseListe) {
		this.startKlasseListe = startKlasseListe;
	}

	public void setStartFachListe(JComboBox<?> startFachListe) {
		this.startFachListe = startFachListe;
	}

}
