package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;
import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;

/**
 * @description ComboBox Listener fuer wechseln von Note Table
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class StartCardFachListener implements ActionListener {

	private JComboBox<?> startFachListe;
	private JTable startNoteTable;

	
	/**
	 * Konstruktor fuer die Klasse StartCardFachListener
	 * @param startFachListe
	 * @param startNoteTable
	 */
	public StartCardFachListener(JComboBox<?> startFachListe, JTable startNoteTable) {
		this.setStartFachListe(startFachListe);
		this.setStartNoteTable(startNoteTable);
	}
	

	public void actionPerformed(ActionEvent e) {
		//das facg_ID des ausgewaehlten Item in der ComboBox rausfinden
		Item item = (Item)getStartFachListe().getSelectedItem();
		int fach_ID = item.getId();
		
		//Objekt Fach erstellen, von den Daten aus der Datenbank mit dem entsprechenden fach_ID
		Fach fach = GMController.getInstance().getNotenByID(fach_ID);
		
		//Vector mit den Titeln erstellen
		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Pruefung");
		columnNames.addElement("Note");
		columnNames.addElement("Gewichtung");
		columnNames.addElement("Datum");
		columnNames.addElement("Fach");
		
		//Vector mit den Datensätze erstellen
		@SuppressWarnings("rawtypes")
		Vector<Vector> data = new Vector<Vector>();
		
		//erstellt ein Vector mit den Noten
		for(Pruefung pruefung : fach.getPruefung()){
			
			Vector<Object> row = new Vector<Object>();
				
			row.addElement(pruefung.getBezeichnung());	
			row.addElement(pruefung.getNote());
			row.addElement(pruefung.getGewichtung());
			row.addElement(pruefung.getDatum());
			row.addElement(fach.getFach());
			
			data.addElement(row);						
		}
		
		//Tabel Model erstellen
		TableModel model = new DefaultTableModel(data, columnNames);
		
		//das alte Table Model mit den neuen Model wechseln
		getStartNoteTable().setModel(model);		
	}


	//Getter und Setter
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
