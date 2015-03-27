package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.grademasters.controller.GMController;
import ch.grademasters.item.Item;
import ch.grademasters.model.Zeugnis;

/**
 * @description ComboBox Listener fuer wechseln von Fach ComboBox
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class StartCardKlasseListener implements ActionListener  {
	
	private JComboBox<?> startKlasseListe;
	private JComboBox<?> startFachListe;
	private JTextArea klassenInfo;
	
	
	/**
	 * Konstruktor fuer die Klasse KlasseModelListener
	 * @param startKlasseListe
	 * @param startFachListe
	 * @param klassenInfo 
	 */	
	public StartCardKlasseListener (JComboBox<?> startKlasseListe, JComboBox<?> startFachListe, JTextArea klassenInfo) {
		this.setStartKlasseListe(startKlasseListe);
		this.setStartFachListe(startFachListe);
		this.setKlassenInfo(klassenInfo);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void actionPerformed(ActionEvent e) {

		//die klasse_ID des ausgewaehlten Item in der ComboBox rausfinden
        Item item = (Item)getStartKlasseListe().getSelectedItem();
        int klasse_ID = item.getId();
        
        getKlassenInfo().removeAll();
        ArrayList<Zeugnis> zeugnis = GMController.getInstance().getZeugnis(klasse_ID);
        String klasseInformation = null;
        for (Zeugnis zeugnisGross : zeugnis) {
        	klasseInformation = zeugnisGross.getKlasse().toString();
        	klasseInformation = klasseInformation + "\n" + zeugnisGross.getKlasse().getKlassenLehrer().toString();
			break;
		}
        System.out.println(klasseInformation);
		getKlassenInfo().setText(klasseInformation);
        
        //eine Fach Vector Model erstellen mit den ausgewaehlten klasse_ID
        Vector<?> fachModel = GMController.getInstance().getFachByID(klasse_ID);
              
        //das alte ComboBox model mit dem neu erstellten model wechseln
        getStartFachListe().setModel(new DefaultComboBoxModel(fachModel));
		
	}

	
	//Getter und Setter
	public JComboBox<?> getStartKlasseListe() {
		return startKlasseListe;
	}

	public JComboBox<?> getStartFachListe() {
		return startFachListe;
	}

	public void setStartKlasseListe(JComboBox<?> startKlasseListe) {
		this.startKlasseListe = startKlasseListe;
	}

	public void setStartFachListe(JComboBox<?> startFachListe) {
		this.startFachListe = startFachListe;
	}


	public JTextArea getKlassenInfo() {
		return klassenInfo;
	}


	public void setKlassenInfo(JTextArea klassenInfo) {
		this.klassenInfo = klassenInfo;
	}

}
