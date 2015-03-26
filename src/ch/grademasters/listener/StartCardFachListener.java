package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;
import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;

public class StartCardFachListener implements ActionListener {

	private JComboBox<?> startFachListe;
	private JTable startNoteTable;
	
	public StartCardFachListener(JComboBox<?> startFachListe, JTable startNoteTable) {
		this.setStartFachListe(startFachListe);
		this.setStartNoteTable(startNoteTable);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Item item = (Item)getStartFachListe().getSelectedItem();
		int fach_ID = item.getId();
		Fach fach = GMController.getInstance().getNotenByID(fach_ID);
		

		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Pruefung");
		columnNames.addElement("Note");
		columnNames.addElement("Gewichtung");
		columnNames.addElement("Datum");
		columnNames.addElement("Fach");
		
		Vector<Vector> data = new Vector<Vector>();
		
		for(Pruefung pruefung : fach.getPruefung()){
			
			Vector<Object> row = new Vector<Object>();
				
			row.addElement(pruefung.getBezeichnung());	
			row.addElement(pruefung.getNote());
			row.addElement(pruefung.getGewichtung());
			// datum
			row.addElement(fach.getFach());
			
			data.addElement(row);
						
		}
		TableModel model = new DefaultTableModel(data, columnNames);
		getStartNoteTable().setModel(model);
		
	}

		
	



	public JComboBox<?> getStartFachListe() {
		return startFachListe;
	}


	public void setStartFachListe(JComboBox<?> startFachListe) {
		this.startFachListe = startFachListe;
	}


	public JTable getStartNoteTable() {
		return startNoteTable;
	}


	public void setStartNoteTable(JTable startNoteTable) {
		this.startNoteTable = startNoteTable;
	}




}
