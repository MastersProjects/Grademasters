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
	
	private Vector<?> fachModel;
	private JComboBox<?> klasseModel;
	private JPanel addNoteCard;
	
	public KlasseModelListener(JComboBox<?> addNoteKlasseListe, Vector<?> fachModel, JPanel addNoteCard) {
		this.setKlasseModel(addNoteKlasseListe);
		this.setFachModel(fachModel);
		this.setAddNoteCard(addNoteCard);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        Item item = (Item)getKlasseModel().getSelectedItem();
        int klasse_ID = item.getId();
        Vector<?> newFachModelVector = GMController.getInstance().getFachByID(klasse_ID);

        setFachModel(newFachModelVector);
        
        getAddNoteCard().repaint();

        
        System.out.println(klasse_ID);
        System.out.println(newFachModelVector);
        
        
		
	}

	public Vector<?> getFachModel() {
		return fachModel;
	}

	public void setFachModel(Vector<?> fachModel) {
		this.fachModel = fachModel;
	}

	public JComboBox<?> getKlasseModel() {
		return klasseModel;
	}

	public void setKlasseModel(JComboBox<?> addNoteKlasseListe) {
		this.klasseModel = addNoteKlasseListe;
	}

	public JPanel getAddNoteCard() {
		return addNoteCard;
	}

	public void setAddNoteCard(JPanel addNoteCard) {
		this.addNoteCard = addNoteCard;
	}

}
