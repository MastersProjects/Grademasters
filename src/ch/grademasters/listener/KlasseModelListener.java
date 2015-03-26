package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;


public class KlasseModelListener implements ActionListener {
	
	private JComboBox<?> addNoteKlasseListe;
	private JComboBox<?> addNoteFachListe;
	

	
	public KlasseModelListener(JComboBox<?> addNoteKlasseListe, JComboBox<?> addNoteFachListe) {
			this.setAddNoteKlasseListe(addNoteKlasseListe);			
			this.setAddNoteFachListe(addNoteFachListe);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * neue liste erzeugen
		 */
        Item item = (Item)getAddNoteKlasseListe().getSelectedItem();
        int klasse_ID = item.getId();
				     
        Vector<?> fachModel = GMController.getInstance().getFachByID(klasse_ID);
        
        
        /*
         * neue liste hinzufuegen
         */
        getAddNoteFachListe().setModel(new DefaultComboBoxModel(fachModel));

		
	}

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
