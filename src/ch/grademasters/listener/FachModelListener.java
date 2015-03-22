package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ch.grademasters.dao.Item;

public class FachModelListener implements ActionListener {

	private JComboBox<?> addNoteFachListe;
	
	public FachModelListener(JComboBox<?> addNoteFachListe) {
		setAddNoteFachListe(addNoteFachListe);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Item item = (Item) getAddNoteFachListe().getSelectedItem();
		int ID_Fach = item.getId();
		System.out.println(ID_Fach);
	}

	public JComboBox<?> getAddNoteFachListe() {
		return addNoteFachListe;
	}

	public void setAddNoteFachListe(JComboBox<?> addNoteFachListe) {
		this.addNoteFachListe = addNoteFachListe;
	}

}
