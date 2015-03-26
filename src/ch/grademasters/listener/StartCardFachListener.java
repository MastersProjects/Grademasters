package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;
import ch.grademasters.model.Fach;

public class StartCardFachListener implements ActionListener {

	private JComboBox<?> startFachListe;

	
	public StartCardFachListener(JComboBox<?> startFachListe) {
		this.setStartFachListe(startFachListe);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Item item = (Item)getStartFachListe().getSelectedItem();
		int fach_ID = item.getId();
		System.out.println(fach_ID);
		Fach fach = GMController.getInstance().getNotenByID(fach_ID);
		
		System.out.println(fach);
	}

		
	



	public JComboBox<?> getStartFachListe() {
		return startFachListe;
	}


	public void setStartFachListe(JComboBox<?> startFachListe) {
		this.startFachListe = startFachListe;
	}




}
