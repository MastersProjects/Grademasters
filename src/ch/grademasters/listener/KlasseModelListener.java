package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ch.grademasters.controller.GMController;
import ch.grademasters.dao.Item;


public class KlasseModelListener implements ActionListener {
	
	private JComboBox<?> addNoteKlasseListe;
	private JPanel addNoteFachListePanel;
	private JComboBox<?> addNoteFachListe;
	private JPanel addNoteCard;

	
	public KlasseModelListener(JComboBox<?> addNoteKlasseListe, JPanel addNoteFachListePanel, JComboBox<?> addNoteFachListe, JPanel addNoteCard) {
			this.setAddNoteKlasseListe(addNoteKlasseListe);
			this.setAddNoteFachListePanel(addNoteFachListePanel);
			this.setAddNoteFachListe(addNoteFachListe);
			this.setAddNoteCard(addNoteCard);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * neue liste erzeugen
		 */
        Item item = (Item)getAddNoteKlasseListe().getSelectedItem();
        int klasse_ID = item.getId();
        System.out.println(klasse_ID);
				     
        Vector<?> fachModel = GMController.getInstance().getFachByID(klasse_ID);
        
        
        /*
         * neue liste hinzuf�gen
         */
        getAddNoteFachListe().setModel(new DefaultComboBoxModel(fachModel));

		
	}

	public JComboBox<?> getAddNoteKlasseListe() {
		return addNoteKlasseListe;
	}

	public void setAddNoteKlasseListe(JComboBox<?> addNoteKlasseListe) {
		this.addNoteKlasseListe = addNoteKlasseListe;
	}

	public JPanel getAddNoteFachListePanel() {
		return addNoteFachListePanel;
	}

	public void setAddNoteFachListePanel(JPanel addNoteFachListePanel) {
		this.addNoteFachListePanel = addNoteFachListePanel;
	}

	public JComboBox<?> getAddNoteFachListe() {
		return addNoteFachListe;
	}

	public void setAddNoteFachListe(JComboBox<?> addNoteFachListe) {
		this.addNoteFachListe = addNoteFachListe;
	}

	public JPanel getAddNoteCard() {
		return addNoteCard;
	}

	public void setAddNoteCard(JPanel addNoteCard) {
		this.addNoteCard = addNoteCard;
	}


        
        
		
	

}
