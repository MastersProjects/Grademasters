package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import ch.grademasters.controller.GMController;
import ch.grademasters.dao.Item;

public class StartCardKlasseListener implements ActionListener  {
	
	private JComboBox<?> startKlasseListe;
	private JList<?> startFachListe;
	
	public StartCardKlasseListener (JComboBox<?> startKlasseListe, JList<?> startFachListe) {
		setStartKlasseListe(startKlasseListe);
		setStartFachListe(startFachListe);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * neue liste erzeugen
		 */
        Item item = (Item)getStartKlasseListe().getSelectedItem();
        int klasse_ID = item.getId();
				     
        Vector<?> fachModel = GMController.getInstance().getFachByID(klasse_ID);
        
        
        /*
         * neue liste hinzuf�gen
         */
        getStartFachListe().setModel(new DefaultComboBoxModel(fachModel));
		
	}

	public JComboBox<?> getStartKlasseListe() {
		return startKlasseListe;
	}

	public JList<?> getStartFachListe() {
		return startFachListe;
	}

	public void setStartKlasseListe(JComboBox<?> startKlasseListe) {
		this.startKlasseListe = startKlasseListe;
	}

	public void setStartFachListe(JList<?> startFachListe) {
		this.startFachListe = startFachListe;
	}

}
