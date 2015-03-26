package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ch.grademasters.item.Item;

public class StartCardFachListener implements ListSelectionListener {

	private JList startFachListe;
	private Vector<?> fachModel;
	
	public StartCardFachListener(JList startFachListe, Vector<?> fachModel) {
		this.setStartFachListe(startFachListe);
		this.setFachModel(fachModel);
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int sel = getStartFachListe().getSelectedIndex();
		System.out.println(getFachModel().get(sel));
		
		

      
		
		
	}


	public Vector<?> getFachModel() {
		return fachModel;
	}


	public void setFachModel(Vector<?> fachModel) {
		this.fachModel = fachModel;
	}


	public JList getStartFachListe() {
		return startFachListe;
	}


	public void setStartFachListe(JList startFachListe) {
		this.startFachListe = startFachListe;
	}


}
