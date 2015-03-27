package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;

public class NoteSpeichernListener implements ActionListener {

	private JTextField note;
	private JTextField gewichtung;
	private JTextField benennung;
	private JComboBox<?> addNoteFachListe;
	private JSpinner datumSpinner;
	
	public NoteSpeichernListener(JTextField note, JTextField gewichtung, JTextField benennung, JComboBox<?> addNoteFachListe, JSpinner datumSpinner) {
		this.setNote(note);
		this.setGewichtung(gewichtung);
		this.setBenennung(benennung);
		this.setAddNoteFachListe(addNoteFachListe);
		this.setDatumSpinner(datumSpinner);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Item item = (Item) getAddNoteFachListe().getSelectedItem();
		int ID_Fach = item.getId();
		
		float note = Float.parseFloat(this.getNote().getText());
		float gewichtung = Float.parseFloat(this.getGewichtung().getText());
		String benennung = this.getBenennung().getText();
		JSpinner.DateEditor datumformatiert = new JSpinner.DateEditor(getDatumSpinner(), "dd/MM/yyyy");
		getDatumSpinner().setEditor(datumformatiert);
		
		System.out.println(getDatumSpinner().getValue());
		
		GMController.getInstance().noteSpeichern(note, gewichtung, ID_Fach, benennung);
		
		//clear textfield
		this.getNote().setText("");
		this.getGewichtung().setText("");
		this.getBenennung().setText("");
	}


	public JTextField getNote() {
		return this.note;
	}


	public void setNote(JTextField note) {
		this.note = note;
	}


	public JTextField getGewichtung() {
		return this.gewichtung;
	}


	public void setGewichtung(JTextField gewichtung) {
		this.gewichtung = gewichtung;
	}


	public JTextField getBenennung() {
		return this.benennung;
	}


	public void setBenennung(JTextField benennung) {
		this.benennung = benennung;
	}


	public JComboBox<?> getAddNoteFachListe() {
		return this.addNoteFachListe;
	}


	public void setAddNoteFachListe(JComboBox<?> fach) {
		this.addNoteFachListe = fach;
	}

	public JSpinner getDatumSpinner() {
		return datumSpinner;
	}

	public void setDatumSpinner(JSpinner datumSpinner) {
		this.datumSpinner = datumSpinner;
	}
	
	
	
	
}
