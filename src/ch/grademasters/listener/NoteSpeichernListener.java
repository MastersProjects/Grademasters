package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.dao.Item;

public class NoteSpeichernListener implements ActionListener {

	private JTextField note;
	private JTextField gewichtung;
	private JTextField benennung;
	private JComboBox<?> fach;
	
	public NoteSpeichernListener(JTextField note, JTextField gewichtung, JTextField benennung, JComboBox<?> fach) {
		this.setNote(note);
		this.setGewichtung(gewichtung);
		this.setBenennung(benennung);
		this.setFach(fach);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Item item = (Item) getFach().getSelectedItem();
		int ID_Fach = item.getId();
		
		int note = Integer.parseInt(this.getNote().getText());
		float gewichtung = Float.parseFloat(this.getGewichtung().getText());
		String benennung = this.getBenennung().getText();
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


	public JComboBox<?> getFach() {
		return this.fach;
	}


	public void setFach(JComboBox<?> fach) {
		this.fach = fach;
	}
	
	
	
	
}
